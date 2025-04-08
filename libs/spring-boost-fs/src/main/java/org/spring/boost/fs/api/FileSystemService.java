package org.spring.boost.fs.api;

import org.spring.boost.fs.model.FileMetadata;

import java.io.IOException;
import java.io.InputStream;

public interface FileSystemService {
  void uploadFile(String path, InputStream inputStream) throws IOException;

  InputStream downloadFile(String path) throws IOException;

  void deleteFile(String path) throws IOException;

  // 新增的去重检查方法
  boolean isFileExists(String hash) throws IOException;

  FileMetadata getFileMetadata(String path) throws IOException;
}