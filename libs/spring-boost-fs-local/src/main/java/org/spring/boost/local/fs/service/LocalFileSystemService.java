package org.spring.boost.local.fs.service;

import org.spring.boost.fs.FileSystemService;

import java.io.IOException;
import java.io.InputStream;

public class LocalFileSystemService implements FileSystemService {
  @Override
  public void uploadFile(String path, InputStream inputStream) throws IOException {

  }

  @Override
  public InputStream downloadFile(String path) throws IOException {
    return null;
  }

  @Override
  public void deleteFile(String path) throws IOException {

  }

  @Override
  public boolean isFileExists(String hash) throws IOException {
    return false;
  }
}
