package org.spring.boost.cli.service.impl;

import org.spring.boost.cli.service.BuildToolService;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service

public class MavenService implements BuildToolService {
  private final Path workingDirectory;

  public MavenService(Path workingDirectory) {
    this.workingDirectory = workingDirectory;
  }
}
