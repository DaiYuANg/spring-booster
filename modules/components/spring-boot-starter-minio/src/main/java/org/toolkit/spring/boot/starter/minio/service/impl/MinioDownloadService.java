package org.toolkit.spring.boot.starter.minio.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;
import org.toolkit.spring.boot.starter.minio.service.IMinioDownloadService;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

@Service
@Slf4j
public class MinioDownloadService implements IMinioDownloadService {

    @Resource
    private ConcurrentMap<String, MinioTemplate> templates;

    @Override
    public InputStreamResource downloadObject(String clientInstance, String bucket, String objectName) {
        val template = Optional.ofNullable(templates.get(clientInstance)).orElseThrow();
        val stream = template.getObject(bucket, objectName);
        return new InputStreamResource(stream);
    }
}
