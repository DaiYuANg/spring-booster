package org.toolkit.spring.boot.minio.service.impl;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.minio.core.event.ObjectAccessEvent;
import org.toolkit.spring.boot.minio.service.IMinioDownloadService;
import org.toolkit.spring.boot.minio.service.IMinioTemplateService;

@Service
@Slf4j
public class MinioDownloadService implements IMinioDownloadService {

	@Resource
	private ApplicationEventPublisher eventPublisher;

	@Resource
	private IMinioTemplateService templateService;

	@Resource
	private HttpServletRequest request;

	@Override
	public InputStreamResource downloadObject(String clientInstance, String bucket, String objectName) {
		val template = templateService.findTemplate(clientInstance);
		val stream = template.getObject(bucket, objectName);
		eventPublisher.publishEvent(new ObjectAccessEvent(this, objectName, request));
		return new InputStreamResource(stream);
	}
}
