package org.spring.boost.cli.service.impl;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.gradle.api.plugins.JavaPluginConvention;
import org.gradle.api.tasks.SourceSet;
import org.gradle.api.tasks.SourceSetContainer;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.gradle.tooling.model.GradleProject;
import org.gradle.tooling.model.idea.IdeaModule;
import org.gradle.tooling.model.idea.IdeaProject;
import org.spring.boost.cli.service.BuildToolService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.util.Set;

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

  public void attach() {
    val project = projectConnection.getModel(GradleProject.class);
    val modules = project.getProjectIdentifier();
    project.getTasks().stream().filter(task -> {
      return task instanceof SourceSetContainer;
    }).findFirst().ifPresent(task -> {
      val sourceSets = (SourceSetContainer) task;
      for (SourceSet sourceSet : sourceSets) {
        System.out.println("Source Set: " + sourceSet.getName());
        Set<File> sourceDirs = sourceSet.getAllJava().getSrcDirs();
        sourceDirs.forEach(dir -> System.out.println("  - " + dir));
      }
    });
//    val javaPlugin = project.getConvention().getPlugin(JavaPluginConvention.class);
//    modules.forEach(module -> {
//      log.atInfo().log("Attaching module '{}'", module.getName());
//      module.getGradleProject()
//    });
  }
}
