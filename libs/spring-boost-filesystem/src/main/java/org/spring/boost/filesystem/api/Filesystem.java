package org.spring.boost.filesystem.api;

import org.spring.boost.filesystem.model.FileMetadata;

import java.io.IOException;
import java.io.InputStream;

public interface Filesystem {
  void uploadFile(String path, InputStream inputStream) throws IOException;

  InputStream downloadFile(String path) throws IOException;

  void deleteFile(String path) throws IOException;

  boolean isFileExists(String hash) throws IOException;

  FileMetadata getFileMetadata(String path) throws IOException;
}