/* (C)2023*/
package org.toolkit.spring.boot.minio.service;

import org.toolkit.minio.MinioTemplate;

public interface IMinioTemplateService {
	MinioTemplate findTemplate(String instance);
}
