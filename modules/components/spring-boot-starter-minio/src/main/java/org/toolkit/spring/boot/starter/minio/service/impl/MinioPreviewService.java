package org.toolkit.spring.boot.starter.minio.service.impl;

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

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
@Slf4j
public class MinioPreviewService implements IMinioPreviewService {

    @Resource
    private Map<String, MinioTemplate> clients;

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
        val resource = repository.findById(objectId).orElseThrow();
        val template = Optional.ofNullable(clients.get(clientInstance)).orElseThrow();
        val stream = template.getObject(bucket, resource.getPath());
        val result = PreviewVo.builder()
                .resource(new ByteArrayResource(IOUtils.toByteArray(stream)))
                .mediaType(MediaType.parseMediaType(resource.getContentType()))
                .build();
        CompletableFuture.runAsync(() -> saveAccessLogAndPublishEvent(objectId), executor);
        return result;
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
