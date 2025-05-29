package org.spring.boost.minio.service;

import io.minio.MinioClient;
import lombok.Builder;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.minio.autoconfigure.properties.MinioClientConfig;

@Slf4j
@Builder
public class MinioTemplate  {
  @NonNull
  private final MinioClient minioClient;

  @NonNull
  private final MinioClientConfig config;
}
