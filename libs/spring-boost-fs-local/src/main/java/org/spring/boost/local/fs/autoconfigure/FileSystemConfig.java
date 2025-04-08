package org.spring.boost.local.fs.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.local.fs.constant.FileSystemType;

import java.nio.file.Path;

@Getter
@Setter
@ToString
public class FileSystemConfig {
  private String qualifier;

  private String path;

  private FileSystemType type;
}
