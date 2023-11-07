package org.toolkit.spring.boot.starter.minio.service;

import lombok.SneakyThrows;
import org.toolkit.spring.boot.starter.minio.vo.PreviewVo;

public interface IMinioPreviewService {
    @SneakyThrows
    PreviewVo previewObject(String clientInstance, String bucket, String objectId);
}
