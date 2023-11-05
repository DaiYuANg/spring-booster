package org.toolkit.spring.boot.starter.minio.service;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.toolkit.spring.boot.starter.minio.params.Base64UploadParam;
import org.toolkit.spring.boot.starter.minio.params.UploadParams;
import org.toolkit.spring.boot.starter.minio.vo.UploadResultVo;

public interface IMinioUploadService {
    @SneakyThrows
    @NotNull UploadResultVo upload(@NotNull UploadParams arguments);

    UploadResultVo upload(@NotNull Base64UploadParam base64UploadParam);
}
