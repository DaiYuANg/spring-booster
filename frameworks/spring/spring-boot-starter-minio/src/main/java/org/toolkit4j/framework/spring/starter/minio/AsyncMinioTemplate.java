package org.toolkit4j.framework.spring.starter.minio;

import io.minio.MinioClient;

import java.io.File;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

public class AsyncMinioTemplate implements IMinioTemplate {
//    private final AsyncWorker asyncWorker;

    private final MinioTemplate template;

    public AsyncMinioTemplate(MinioClient minioClient, ThreadPoolExecutor threadPoolExecutor) {
        this.template = new MinioTemplate(minioClient);
//        this.asyncWorker = new AsyncWorker();
//        asyncWorker.setExecutor(threadPoolExecutor);
    }

    public CompletableFuture<String> upload(File file, String bucket) {
//        return asyncWorker.supply(() -> template.upload(file, bucket));
    }
}
