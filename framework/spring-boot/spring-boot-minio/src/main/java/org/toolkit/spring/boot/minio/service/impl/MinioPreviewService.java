package org.toolkit.spring.boot.minio.service.impl;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;
import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.toolkit.spring.boot.minio.event.ObjectAccessEvent;
import org.toolkit.spring.boot.minio.service.IMinioPreviewService;
import org.toolkit.spring.boot.minio.service.IMinioTemplateService;
import org.toolkit.spring.boot.minio.vo.PreviewVo;

@Service
@Slf4j
public class MinioPreviewService implements IMinioPreviewService {

	@Resource
	private IMinioTemplateService templateService;

	@Resource(name = "ToolkitMinioThreadPool")
	private ThreadPoolTaskExecutor executor;

	@Resource
	private ApplicationEventPublisher eventPublisher;

	/**
	 * @param clientInstance minio config key
	 * @param bucket         preview object storage bucket
	 * @param objectPath     object path
	 * @return
	 */
	@Override
	@SneakyThrows
	public PreviewVo previewObject(String clientInstance, String bucket, String objectPath) {
		val getObjectSingle = Single.fromCallable(() -> IOUtils.toByteArray(
						templateService.findTemplate(clientInstance).getObject(bucket, objectPath)))
				.subscribeOn(Schedulers.from(executor));

		val statSingle = Single.fromCallable(() -> templateService
						.findTemplate(clientInstance)
						.stat(bucket, objectPath)
						.contentType())
				.subscribeOn(Schedulers.from(executor));

		val resultSingle = Single.zip(getObjectSingle, statSingle, this::previewBuilder)
				.doFinally(() -> eventPublisher.publishEvent(new ObjectAccessEvent(this, objectPath)))
				.doOnError(throwable -> {
					throw throwable;
				});
		return resultSingle.blockingGet();
	}

	private PreviewVo previewBuilder(byte[] objectData, String contentType) {
		return PreviewVo.builder()
				.resource(new ByteArrayResource(objectData))
				.mediaType(MediaType.parseMediaType(contentType))
				.build();
	}
}
