package org.toolkit.spring.boot.minio.persistence.listener;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.toolkit.spring.boot.minio.core.event.ObjectUploadedEvent;
import org.toolkit.spring.boot.minio.persistence.entity.MinioObjectEntity;
import org.toolkit.spring.boot.minio.persistence.repository.MinioResourceEntityRepository;

@Component
@Slf4j
public class ObjectUploadedListener implements ApplicationListener<ObjectUploadedEvent> {

	@Resource
	private MinioResourceEntityRepository minioResourceEntityRepository;

	@Override
	@Async
	public void onApplicationEvent(@NotNull ObjectUploadedEvent event) {
		val template = event.getTemplate();
		val stat = template.stat(event.getObject());
		val entity = new MinioObjectEntity() {
			{
				setObject(event.getObject());
				setMd5(event.getMd5());
				//				setInstance(template.getSelfKey());
				setContentType(stat.contentType());
			}
		};
		minioResourceEntityRepository.save(entity);
		log.atInfo().log("save object:{}", event);
	}
}
