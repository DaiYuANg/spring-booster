package org.spring.boost.local.fs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tika.Tika;
import org.spring.boost.filesystem.api.FileSystemService;
import org.spring.boost.filesystem.api.FileUploadHooks;
import org.spring.boost.filesystem.model.FileMetadata;

import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
@Slf4j
public class LocalFileSystemService implements FileSystemService {

//  private final FileSystem fileSystem;

  private final Tika tika;

//  private final FileUploadHooks hooks;

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
