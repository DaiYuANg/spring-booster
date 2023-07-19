package org.toolkit4j.framework.spring.starter.io.minio;

import io.minio.MinioClient;
import jakarta.annotation.Resource;
import org.toolkit4J.framework.spring.boot.starter.async.base.AsyncWorker;

import java.io.File;
import java.util.concurrent.CompletableFuture;

public class AsyncMinioTemplate implements IMinioTemplate{
    @Resource
    private AsyncWorker asyncWorker;

    private final MinioTemplate template;

    public AsyncMinioTemplate(MinioClient minioClient) {
        this.template = new MinioTemplate(minioClient);
    }

    public CompletableFuture<String> upload(File file, String bucket) {
        return asyncWorker.supply(() -> template.upload(file, bucket));
    }
}
