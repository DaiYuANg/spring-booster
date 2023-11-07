package org.toolkit.spring.boot.starter.minio.service;

import org.toolkit.spring.boot.starter.minio.functional.MinioTemplate;

public interface IMinioTemplateService {
    MinioTemplate findTemplate(String instance);
}
