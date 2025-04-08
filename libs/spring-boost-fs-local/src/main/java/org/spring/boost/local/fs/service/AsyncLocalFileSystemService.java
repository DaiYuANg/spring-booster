package org.spring.boost.local.fs.service;

import org.spring.boost.fs.AsyncFileSystemService;
import org.spring.boost.fs.FileSystemService;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public class AsyncLocalFileSystemService implements AsyncFileSystemService {
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
