package org.toolkit.spring.boot.starter.minio.functional;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;

public interface IMinioTemplate {
    @SneakyThrows
    String upload(@NotNull MultipartFile multipartFile, String bucket);

    @SneakyThrows
    String upload(@NotNull Path path, String bucket);

    @SneakyThrows
    String upload(String path, String bucket);

    @SneakyThrows
    String upload(File file, String bucket);

    @SneakyThrows
    void autoCreateBucket(String bucket);

    @SneakyThrows
    InputStream getObject(String object);

    @SneakyThrows
    File download(String object, String targetPath, String bucket);
}
