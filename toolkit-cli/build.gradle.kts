plugins {
  application
  id("com.github.johnrengelman.shadow") version "8.1.1"
  id("org.beryx.jlink") version "3.0.1"
}

group = "org.toolkit.cli"

version = "1.0"

dependencies {
  implementation("ch.qos.logback:logback-core:1.4.11")
  implementation("ch.qos.logback:logback-classic:1.4.11")
  implementation("com.squareup:javapoet:1.13.0")
  implementation("info.picocli:picocli:4.7.5")
  implementation("com.google.inject:guice:7.0.0")
  implementation("org.freemarker:freemarker:2.3.32")
  implementation("com.squareup:javapoet:1.13.0")
  implementation("org.fusesource.jansi:jansi:2.4.1")
  implementation("commons-dbutils:commons-dbutils:1.8.1")
  implementation("com.mysql:mysql-connector-j:8.2.0")
  implementation("com.github.gestalt-config:gestalt-core:0.23.3")
  implementation("com.github.gestalt-config:gestalt-toml:0.23.3")
  implementation("com.github.gestalt-config:gestalt-yaml:0.23.3")
  implementation("com.github.gestalt-config:gestalt-json:0.23.3")
  implementation("com.github.gestalt-config:gestalt-git:0.23.3")
  annotationProcessor("info.picocli:picocli-codegen:4.7.5")
}

run {}

tasks {
  compileJava { options.compilerArgs.add("-Aproject=${project.group}/${project.name}") }
  jar {
    manifest {
      attributes["Main-Class"] = "org.toolkit.cli.ToolkitCLIApplication"
      manifest.attributes["Class-Path"] =
          configurations.runtimeClasspath.get().joinToString(separator = " ") { file ->
            "libs/${file.name}"
          }
    }
  }
}

application {
  mainModule = "org.toolkit.cli"
  mainClass = "org.toolkit.cli.ToolkitCLIApplication"
  applicationDefaultJvmArgs = listOf("-Dsmallrye.config.locations=test.yaml")
}

jlink {
  launcher { name = "toolkit-cli" }
  forceMerge("slf4j")
  imageZip.set(project.file("${layout.buildDirectory}/image-zip/toolkit-cli.zip"))
}
