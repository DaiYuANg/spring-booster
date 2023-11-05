package org.toolkit.spring.boot.starter.minio.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.crypto.digest.DigestUtil;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.minio.events.UploadedEvent;
import org.toolkit.spring.boot.starter.minio.params.Base64UploadParam;
import org.toolkit.spring.boot.starter.minio.params.UploadParams;
import org.toolkit.spring.boot.starter.minio.entity.MinioResourceEntity;
import org.toolkit.spring.boot.starter.minio.exceptions.MinioInstanceNotFound;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.repository.MinioResourceEntityRepository;
import org.toolkit.spring.boot.starter.minio.service.IMinioUploadService;
import org.toolkit.spring.boot.starter.minio.vo.UploadResultVo;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.Base64;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class MinioUploadUploadService implements IMinioUploadService {

    @Resource
    private Executor executor;

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Resource
    private MinioResourceEntityRepository repository;

    @Resource
    private Map<String, MinioTemplate> clients;

    @Override
    @SneakyThrows
    @NotNull
    public UploadResultVo upload(@NotNull UploadParams arguments) {
        val md5 = DigestUtil.md5Hex(FileUtil.readUtf8String(arguments.getFile().getResource().getFile()));
        val entity = repository.findByMd5(md5).orElseGet(() -> uploadToMinio(arguments, md5));
        return new UploadResultVo() {{
            setId(entity.getId());
        }};
    }

    private MinioResourceEntity uploadToMinio(@NotNull UploadParams arguments, String md5) {
        val template = Optional.ofNullable(clients.get(arguments.getClientInstance())).orElseThrow(MinioInstanceNotFound::new);
        val contentType = arguments.getFile().getContentType();
        val targetName = nameBuilder(md5);
        val entity = new MinioResourceEntity() {{
            setPath(targetName);
            setAnonymous(arguments.isAnonymous());
            setContentType(contentType);
            setMd5(md5);
            setInstance(arguments.getClientInstance());
        }};
        val async = CompletableFuture
                .runAsync(() -> template.upload(arguments.getFile(), targetName, contentType), executor)
                .thenCompose((Void) -> CompletableFuture.supplyAsync(() -> repository.save(entity), executor))
                .thenApply(resourceEntity -> {
                    eventPublisher.publishEvent(new UploadedEvent(this, entity.getId()));
                    return resourceEntity;
                });
        return async.join();
    }

    private String nameBuilder(String md5) {
        return String.format("%s/%s", DateUtil.today(), md5);
    }

    @Override
    public UploadResultVo upload(@NotNull Base64UploadParam base64UploadParam) {
        val md5 = DigestUtil.md5Hex(base64UploadParam.getBase64());
        val entity = repository.findByMd5(md5).orElseGet(() -> base64Upload(base64UploadParam));
        val result = new UploadResultVo().setId(entity.getId());
        eventPublisher.publishEvent(new UploadedEvent(this, entity.getId()));
        return result;
    }

    @SneakyThrows
    private @NotNull MinioResourceEntity base64Upload(@NotNull Base64UploadParam base64UploadParam) {
        byte[] data = Base64.getDecoder().decode(base64UploadParam.getBase64());
        InputStream inputStream = new ByteArrayInputStream(data);
        String contentType = URLConnection.guessContentTypeFromStream(inputStream);
        return new MinioResourceEntity();
    }
}
