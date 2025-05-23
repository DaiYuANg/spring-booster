package org.spring.boost.local.fs.autoconfigure;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashSet;
import java.util.Set;

@ConfigurationProperties(prefix = "spring.boost.fs.local")
@Getter
@Setter
public class LocalFileSystemProperties {

  private Set<FileSystemConfig> configs = new HashSet<>();
}
