package org.spring.boost.cli.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.model.Dependency;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
@Slf4j
public class GradleService implements BuildToolService {
  private final Path workingDirectory;

  private final ProjectConnection projectConnection;

  public GradleService(Path workingDirectory) {
    this.workingDirectory = workingDirectory;
    val connector = GradleConnector
      .newConnector()
      .forProjectDirectory(workingDirectory.toFile());
    this.projectConnection = connector.connect();
  }
}
