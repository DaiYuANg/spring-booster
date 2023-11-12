package org.toolkit.spring.boot.minio.core.template;

import cn.hutool.core.util.IdUtil;
import io.minio.*;
import io.minio.errors.ErrorResponseException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Optional;
import lombok.Getter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;
import org.toolkit.spring.boot.minio.core.exception.ObjectNotExistsException;

@Slf4j
public final class MinioTemplate {

	@Getter
	private final String identifier;

	private static final String defaultContentType = "application/octet-stream";
	private final MinioClient client;
	private final String defaultBucket;

	public MinioTemplate(MinioClient client, String defaultBucket, String identifier) {
		this.client = client;
		this.defaultBucket = defaultBucket;
		this.identifier = identifier;
		createBucket(this.defaultBucket);
	}

	public MinioTemplate(MinioClient client, String defaultBucket) {
		this.client = client;
		this.defaultBucket = defaultBucket;
		this.identifier = IdUtil.fastUUID();
		createBucket(this.defaultBucket);
	}

	@SneakyThrows
	public void upload(File file, String targetName, String bucketName, String contentType) {
		upload(FileUtils.readFileToByteArray(file), targetName, bucketName, contentType);
	}

	@SneakyThrows
	public void upload(@NotNull MultipartFile multipartFile, String targetName, String bucketName, String contentType) {
		upload(multipartFile.getResource().getFile(), targetName, bucketName, contentType);
	}

	public void upload(MultipartFile multipartFile, String targetName, String contentType) {
		upload(multipartFile, targetName, defaultBucket, contentType);
	}

	public void upload(File file, String targetName, String contentType) {
		upload(file, targetName, defaultBucket, contentType);
	}

	@SneakyThrows
	public void upload(@NotNull Path path, String targetName, String bucketName, String contentType) {
		upload(path.toFile(), targetName, bucketName, contentType);
	}

	@SneakyThrows
	public void upload(byte[] fileBytes, String targetName, String bucketName, String contentType) {
		if (objectExists(targetName, bucketName)) return;
		try (ByteArrayInputStream inputStream = new ByteArrayInputStream(fileBytes)) {
			PutObjectArgs putObjectArgs = PutObjectArgs.builder().bucket(bucketName).object(targetName).stream(
							inputStream, inputStream.available(), -1)
					.contentType(contentTypeWithDefault(contentType))
					.build();
			client.putObject(putObjectArgs);
		}
	}

	public void upload(byte[] fileBytes, String targetName, String contentType) {
		upload(fileBytes, defaultBucket, targetName, contentType);
	}

	private String contentTypeWithDefault(String contentType) {
		return Optional.ofNullable(contentType).orElse(defaultContentType);
	}

	@SneakyThrows
	public InputStream getObject(String object) {
		return getObject(defaultBucket, object);
	}

	@SneakyThrows
	public InputStream getObject(String bucket, String object) {
		if (objectExists(object)) {
			throw new ObjectNotExistsException(object);
		}
		client.composeObject(ComposeObjectArgs.builder().build());
		return client.getObject(
				GetObjectArgs.builder().bucket(bucket).object(object).build());
	}

	@SneakyThrows
	public byte[] getObjectBytes(String bucket, String object) {
		return IOUtils.toByteArray(getObject(bucket, object));
	}

	public byte[] getObjectBytes(String object) {
		return getObjectBytes(defaultBucket, object);
	}

	@SneakyThrows
	public void downloadAsFile(String object, String bucketName, String filename) {
		client.downloadObject(DownloadObjectArgs.builder()
				.object(object)
				.bucket(bucketName)
				.filename(filename)
				.build());
	}

	public void downloadAsFile(String object, String filename) {
		downloadAsFile(object, defaultBucket, filename);
	}

	@SneakyThrows
	public StatObjectResponse stat(String bucket, String object) {
		val arg = StatObjectArgs.builder().bucket(bucket).object(object).build();
		return client.statObject(arg);
	}

	public StatObjectResponse stat(String object) {
		return stat(defaultBucket, object);
	}

	@SneakyThrows
	public boolean objectExists(String bucket, String object) {
		try {
			client.statObject(
					StatObjectArgs.builder().bucket(bucket).object(object).build());
			return true;
		} catch (ErrorResponseException e) {
			log.atDebug().log("object not exists");
			return false;
		}
	}

	public boolean objectExists(String object) {
		return objectExists(defaultBucket, object);
	}

	@SneakyThrows
	public void createBucket(String bucket) {
		val existsArg = BucketExistsArgs.builder().bucket(bucket).build();
		if (client.bucketExists(existsArg)) {
			log.atInfo().log("bucket :{} existed!", bucket);
			return;
		}
		client.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
	}
}
