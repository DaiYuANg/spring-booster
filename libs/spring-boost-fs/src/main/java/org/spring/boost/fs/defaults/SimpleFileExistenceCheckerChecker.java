package org.spring.boost.fs.defaults;

import org.spring.boost.fs.api.FileExistenceChecker;

import java.io.IOException;

public class SimpleFileExistenceCheckerChecker implements FileExistenceChecker {
  @Override
  public boolean isFileExists(String identifier) throws IOException {
    return false;
  }
}
