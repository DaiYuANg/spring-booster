package org.toolkit.spring.boot.starter.minio.service;

import org.springframework.core.io.InputStreamResource;

public interface IMinioDownloadService {
	InputStreamResource downloadObject(String clientInstance, String bucket, String objectName);
}
