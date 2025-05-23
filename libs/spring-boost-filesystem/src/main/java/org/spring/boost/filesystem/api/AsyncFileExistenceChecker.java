package org.spring.boost.filesystem.api;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public interface AsyncFileExistenceChecker {
  CompletableFuture<Boolean> isFileExists(String identifier) throws IOException;
}
