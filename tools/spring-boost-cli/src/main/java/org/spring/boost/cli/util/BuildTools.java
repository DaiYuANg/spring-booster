package org.spring.boost.cli.util;

import lombok.experimental.UtilityClass;
import lombok.val;

import java.io.File;

@UtilityClass
public class BuildTools {
  private static boolean isMavenProject(String currentDir) {
    val pomFile = new File(currentDir, "pom.xml");
    return pomFile.exists() && pomFile.isFile();
  }

  // 检查项目是否为 Gradle 项目
  private static boolean isGradleProject(String currentDir) {
    val buildFile = new File(currentDir, "build.gradle");
    val settingsFile = new File(currentDir, "settings.gradle");
    return (buildFile.exists() && buildFile.isFile()) || (settingsFile.exists() && settingsFile.isFile());
  }
}
