package org.spring.boost.filesystem.api;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public interface AsyncFileSystem {

  CompletableFuture<Void> uploadFileAsync(String path, InputStream inputStream);

  CompletableFuture<InputStream> downloadFileAsync(String path);

  CompletableFuture<Void> deleteFileAsync(String path);
}
