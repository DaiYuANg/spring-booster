package org.spring.boost.minio.service;

import io.minio.MinioClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.spring.boost.fs.api.FileSystemService;
import org.spring.boost.fs.model.FileMetadata;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
@RequiredArgsConstructor
public class MinioFileSystemService implements FileSystemService {

  private final MinioClient minioClient;

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

  @Override
  public FileMetadata getFileMetadata(String path) throws IOException {
    return null;
  }
}
