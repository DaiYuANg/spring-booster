package org.spring.boost.fs;

import java.io.InputStream;
import java.util.concurrent.CompletableFuture;

public interface AsyncFileSystemService {

  CompletableFuture<Void> uploadFileAsync(String path, InputStream inputStream);

  CompletableFuture<InputStream> downloadFileAsync(String path);

  CompletableFuture<Void> deleteFileAsync(String path);
}
