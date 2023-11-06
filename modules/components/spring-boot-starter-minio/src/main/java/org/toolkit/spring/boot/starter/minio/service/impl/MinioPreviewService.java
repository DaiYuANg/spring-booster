package org.toolkit.spring.boot.starter.minio.service.impl;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.minio.entity.MinioResourceAccessRecord;
import org.toolkit.spring.boot.starter.minio.events.ResourceAccessedEvent;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.repository.MinioResourceAccessRecordRepository;
import org.toolkit.spring.boot.starter.minio.repository.MinioResourceEntityRepository;
import org.toolkit.spring.boot.starter.minio.service.IMinioPreviewService;
import org.toolkit.spring.boot.starter.minio.vo.PreviewVo;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class MinioPreviewService implements IMinioPreviewService {

    @Resource
    private ConcurrentMap<String, MinioTemplate> templates;

    @Resource
    private MinioResourceEntityRepository repository;

    @Resource
    private ApplicationEventPublisher eventPublisher;

    @Resource
    private MinioResourceAccessRecordRepository accessRecordRepository;

    @Resource
    private HttpServletRequest currentRequest;

    @Resource
    private Executor executor;

    @Override
    @SneakyThrows
    public PreviewVo previewObject(String clientInstance, String bucket, String objectId) {
        return Single.fromCallable(() -> {
                    val resource = repository.findById(objectId).orElseThrow();
                    val template = Optional.ofNullable(templates.get(clientInstance)).orElseThrow();
                    val stream = template.getObject(bucket, resource.getPath());
                    return PreviewVo.builder()
                            .resource(new ByteArrayResource(IOUtils.toByteArray(stream)))
                            .mediaType(MediaType.parseMediaType(resource.getContentType()))
                            .build();
                })
                .subscribeOn(Schedulers.io())
                .doOnSuccess(result -> CompletableFuture.runAsync(() -> saveAccessLogAndPublishEvent(objectId), executor))
                .blockingGet();
    }

    private void saveAccessLogAndPublishEvent(String resourceId) {
        val entity = new MinioResourceAccessRecord() {{
            setIpAddress(currentRequest.getRemoteHost());
            setId(resourceId);
            setUserAgent(currentRequest.getHeader("User-Agent"));
        }};
        accessRecordRepository.save(entity);
        eventPublisher.publishEvent(new ResourceAccessedEvent(this, resourceId));
    }
}
