package org.spring.boost.fs.api;

import java.io.IOException;

public interface FileExistenceChecker  {
  boolean isFileExists(String identifier) throws IOException;
}
