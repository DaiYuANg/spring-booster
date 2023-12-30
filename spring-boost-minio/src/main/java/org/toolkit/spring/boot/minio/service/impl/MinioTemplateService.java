/* (C)2023*/
package org.toolkit.spring.boot.minio.service.impl;

import jakarta.annotation.Resource;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.minio.MinioTemplate;
import org.toolkit.spring.boot.minio.service.IMinioTemplateService;

@Service
@Slf4j
public class MinioTemplateService implements IMinioTemplateService {

	@Resource
	private ConcurrentMap<String, MinioTemplate> templates;

	@Override
	public MinioTemplate findTemplate(String instance) {
		return null;
		//		return Optional.ofNullable(templates.get(instance)).orElseThrow(MinioInstanceNotFound::new);
	}
}
