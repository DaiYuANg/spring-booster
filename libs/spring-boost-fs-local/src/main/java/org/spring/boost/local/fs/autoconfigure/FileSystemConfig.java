package org.spring.boost.local.fs.autoconfigure;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.spring.boost.local.fs.constant.FileSystemType;

import java.nio.file.Path;

@Getter
@Setter
@ToString
public class FileSystemConfig {
  private Path path;

  private FileSystemType type;
}
