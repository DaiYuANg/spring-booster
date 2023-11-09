package org.toolkit.spring.boot.minio.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.DigestUtil;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Optional;
import java.util.function.Supplier;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.toolkit.spring.boot.minio.checker.BeforeUploadCheckMd5Exists;
import org.toolkit.spring.boot.minio.core.event.ObjectUploadedEvent;
import org.toolkit.spring.boot.minio.core.template.MinioTemplate;
import org.toolkit.spring.boot.minio.params.Base64UploadParam;
import org.toolkit.spring.boot.minio.params.UploadParams;
import org.toolkit.spring.boot.minio.service.IMinioTemplateService;
import org.toolkit.spring.boot.minio.service.IMinioUploadService;
import org.toolkit.spring.boot.minio.vo.UploadResultVo;

@Service
@Slf4j
public class MinioUploadUploadService implements IMinioUploadService {
	@Resource
	private ApplicationEventPublisher eventPublisher;

	@Resource
	private Optional<BeforeUploadCheckMd5Exists> beforeUploadCheckMd5Exists;

	@Resource
	private IMinioTemplateService minioTemplateService;

	@PostConstruct
	public void init() {
		log.info("minio upload service init");
		log.info("checker exists:{}", beforeUploadCheckMd5Exists.isPresent());
	}

	@Override
	public UploadResultVo checkMd5OrUpload(String md5, Supplier<String> md5NotExistsSupplier) {
		val path = beforeUploadCheckMd5Exists
				.flatMap(checkMd5Exists -> checkMd5Exists.check(md5))
				.orElseGet(md5NotExistsSupplier);
		return new UploadResultVo(path);
	}

	@Override
	@SneakyThrows
	@NotNull public UploadResultVo upload(@NotNull UploadParams arguments) {
		val md5 = DigestUtil.md5Hex(
				FileUtil.readUtf8String(arguments.getFile().getResource().getFile()));
		return checkMd5OrUpload(md5, () -> uploadToMinio(arguments, md5));
	}

	@Override
	public UploadResultVo upload(@NotNull Base64UploadParam base64UploadParam) {
		val md5 = DigestUtil.md5Hex(base64UploadParam.getBase64());
		return checkMd5OrUpload(md5, () -> base64Upload(base64UploadParam, md5));
	}

	@SneakyThrows
	private @NotNull String uploadToMinio(@NotNull UploadParams arguments, String md5) {
		val template = minioTemplateService.findTemplate(arguments.getClientInstance());
		val contentType = Optional.ofNullable(arguments.getFile())
				.map(MultipartFile::getContentType)
				.orElseThrow(FileNotFoundException::new);
		val targetName = nameBuilder(md5);
		template.upload(arguments.getFile(), targetName, contentType);
		publishEvent(targetName, md5, template);
		return targetName;
	}

	private String nameBuilder(String md5) {
		return String.format("%s/%s", DateUtil.today(), md5);
	}

	@SneakyThrows
	private @NotNull String base64Upload(@NotNull Base64UploadParam base64UploadParam, String md5) {
		val template = minioTemplateService.findTemplate(base64UploadParam.getClientInstance());
		byte[] data = Base64.getDecoder().decode(base64UploadParam.getBase64());
		InputStream inputStream = new ByteArrayInputStream(data);
		String contentType = URLConnection.guessContentTypeFromStream(inputStream);
		val targetName = nameBuilder(md5);
		template.upload(data, targetName, contentType);
		publishEvent(targetName, md5, template);
		return targetName;
	}

	private void publishEvent(String path, String md5, MinioTemplate template) {
		eventPublisher.publishEvent(new ObjectUploadedEvent(this, path, md5, template));
	}
}
