package org.spring.boost.fs;

import java.io.IOException;

public interface FileExistenceChecker  {
  boolean isFileExists(String identifier) throws IOException;
}
