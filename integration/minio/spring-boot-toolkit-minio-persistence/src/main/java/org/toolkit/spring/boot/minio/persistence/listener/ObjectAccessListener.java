package org.toolkit.spring.boot.minio.persistence.listener;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.minio.core.event.ObjectAccessEvent;
import org.toolkit.spring.boot.minio.persistence.repository.MinioResourceAccessRecordRepository;

@Component
@Slf4j
public class ObjectAccessListener implements ApplicationListener<ObjectAccessEvent> {
	@Resource
	private MinioResourceAccessRecordRepository repository;

	@Override
	public void onApplicationEvent(@NotNull ObjectAccessEvent event) {}
}
