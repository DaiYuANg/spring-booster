package org.toolkit.spring.boot.minio.service;

import lombok.SneakyThrows;
import org.toolkit.spring.boot.minio.vo.PreviewVo;

public interface IMinioPreviewService {
	@SneakyThrows
	PreviewVo previewObject(String clientInstance, String bucket, String objectId);
}
