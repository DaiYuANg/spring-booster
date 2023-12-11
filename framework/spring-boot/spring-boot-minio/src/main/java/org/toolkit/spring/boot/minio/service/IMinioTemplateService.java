package org.toolkit.spring.boot.minio.service;

import org.toolkit.spring.boot.minio.template.MinioTemplate;

public interface IMinioTemplateService {
	MinioTemplate findTemplate(String instance);
}
