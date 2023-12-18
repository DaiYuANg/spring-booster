/* (C)2023*/
package org.toolkit.spring.boot.minio.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.minio.event.ObjectAccessEvent;
import org.toolkit.spring.boot.minio.service.IMinioDownloadService;
import org.toolkit.spring.boot.minio.service.IMinioTemplateService;

@Service
@Slf4j
public class MinioDownloadService implements IMinioDownloadService {

	@Resource
	@Lazy
	private ApplicationEventPublisher eventPublisher;

	@Resource
	@Lazy
	private IMinioTemplateService templateService;

	@Override
	public InputStreamResource downloadObject(String clientInstance, String bucket, String objectName) {
		val template = templateService.findTemplate(clientInstance);
		val stream = template.getObject(bucket, objectName);
		eventPublisher.publishEvent(new ObjectAccessEvent(this, objectName));
		return new InputStreamResource(stream);
	}
}
