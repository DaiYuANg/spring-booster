package org.toolkit.spring.boot.starter.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.core.task.TaskExecutor;

public class AsyncMinioTemplate implements IMinioTemplate {

	@Resource
	private TaskExecutor taskExecutor;

	private final MinioTemplate template;

	public AsyncMinioTemplate(MinioClient minioClient, ThreadPoolExecutor threadPoolExecutor) {
		this.template = new MinioTemplate(minioClient);
		//		this.asyncWorker = AsyncWorker.builder().executor(threadPoolExecutor).build();
	}

	public CompletableFuture<String> upload(File file, String bucket) {
		//		return asyncWorker.supply(() -> template.upload(file, bucket));
		return null;
	}
}
