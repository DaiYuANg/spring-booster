package org.spring.boost.local.fs.service;

import org.spring.boost.filesystem.api.AsyncFileSystem;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public class AsyncLocalFileSystem implements AsyncFileSystem {
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
