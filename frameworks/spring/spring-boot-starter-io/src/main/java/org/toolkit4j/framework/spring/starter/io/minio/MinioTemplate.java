package org.toolkit4j.framework.spring.starter.io.minio;

import cn.hutool.core.util.IdUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentParser;
import io.minio.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import net.jodah.expiringmap.ExpiringMap;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MinioTemplate implements IMinioTemplate{

    private final MinioClient minioClient;

    private final ExpiringMap<Integer, String> accessKeys = ExpiringMap.builder()
            .variableExpiration()
            .build();

    public MinioTemplate(MinioClient minioClient) {
        this.minioClient = minioClient;
    }

    @SneakyThrows
    public String upload(@NotNull MultipartFile multipartFile, String bucket) {
        return upload(multipartFile.getResource().getFile(), bucket);
    }

    @SneakyThrows
    public String upload(@NotNull Path path, String bucket) {
        val file = path.toFile();
        if (!file.exists()) throw new FileNotFoundException();
        return upload(file, bucket);
    }

    @SneakyThrows
    public String upload(String path, String bucket) {
        val file = new File(path);
        if (!file.exists()) throw new FileNotFoundException();
        return upload(file, bucket);
    }

    @SneakyThrows
    public String upload(File file, String bucket) {
        autoCreateBucket(bucket);
        try (val stream = new FileInputStream(file)) {
            val up = PutObjectArgs.builder().stream(stream, stream.available(), -1).build();
            val r = minioClient.putObject(up);
            return r.bucket();
        }
    }

    @SneakyThrows
    private void autoCreateBucket(String bucket) {
        if (minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build())) return;
        minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
    }
}
