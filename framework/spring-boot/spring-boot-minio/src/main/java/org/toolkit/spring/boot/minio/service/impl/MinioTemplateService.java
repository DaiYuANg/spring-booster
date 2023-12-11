package org.toolkit.spring.boot.minio.service.impl;

import jakarta.annotation.Resource;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.minio.exceptions.MinioInstanceNotFound;
import org.toolkit.spring.boot.minio.service.IMinioTemplateService;
import org.toolkit.spring.boot.minio.template.MinioTemplate;

@Service
@Slf4j
public class MinioTemplateService implements IMinioTemplateService {

	@Resource
	private ConcurrentMap<String, MinioTemplate> templates;

	@Override
	public MinioTemplate findTemplate(String instance) {
		return Optional.ofNullable(templates.get(instance)).orElseThrow(MinioInstanceNotFound::new);
	}
}
