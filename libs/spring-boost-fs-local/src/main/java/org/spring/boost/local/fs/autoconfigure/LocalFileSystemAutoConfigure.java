package org.spring.boost.local.fs.autoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@AutoConfiguration
@Slf4j
@RequiredArgsConstructor
@EnableConfigurationProperties(LocalFileSystemProperties.class)
public class LocalFileSystemAutoConfigure {
  private final LocalFileSystemProperties properties;
}
