package org.spring.boost.filesystem.api;

import java.io.IOException;

public interface FileExistenceChecker  {
  boolean isFileExists(String identifier) throws IOException;
}
