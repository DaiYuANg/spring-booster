package org.spring.boost.filesystem.defaults;

import org.spring.boost.filesystem.api.FileExistenceChecker;

import java.io.IOException;

public class SimpleFileExistenceCheckerChecker implements FileExistenceChecker {
  @Override
  public boolean isFileExists(String identifier) throws IOException {
    return false;
  }
}
