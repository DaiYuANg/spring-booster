package org.spring.boost.minio.service;

import io.minio.MinioAsyncClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.fs.api.AsyncFileSystemService;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

@RequiredArgsConstructor
@Slf4j
public class MinioAsyncFileSystemService implements AsyncFileSystemService {

  private final MinioAsyncClient minioAsyncClient;

  @Override
  public CompletableFuture<Void> uploadFileAsync(String path, InputStream inputStream) {
    return null;
  }

  @Override
  public CompletableFuture<InputStream> downloadFileAsync(String path) {
    return null;
  }

  @Override
  public CompletableFuture<Void> deleteFileAsync(String path) {
    return null;
  }
}
