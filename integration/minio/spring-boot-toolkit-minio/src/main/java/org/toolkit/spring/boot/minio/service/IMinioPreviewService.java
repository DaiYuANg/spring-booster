package org.toolkit.spring.boot.minio.service;

import org.toolkit.spring.boot.minio.vo.PreviewVo;

public interface IMinioPreviewService {
	PreviewVo previewObject(String clientInstance, String bucket, String objectId);
}
