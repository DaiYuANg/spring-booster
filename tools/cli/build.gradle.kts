plugins {
  application
  id("org.graalvm.buildtools.native") version "0.9.27"
  id("org.panteleyev.jpackageplugin") version "1.5.2"
}

group = "org.toolkit.cli"

version = "1.0"

val toolingApiVersion = "8.5"

repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

val mainClass = "org.toolkit.cli.ToolkitCLIApplication"

dependencies {
  val picocliVersion: String by project
  val slf4jVersion: String by project
  implementation("info.picocli:picocli:$picocliVersion")
  implementation("info.picocli:picocli-shell-jline3:$picocliVersion")
  implementation("com.google.inject:guice:7.0.0")
  implementation("com.mysql:mysql-connector-j:8.2.0")
  implementation("com.squareup:javapoet:1.13.0")
  implementation("org.gradle:gradle-tooling-api:$toolingApiVersion")
  implementation("org.apache.maven:maven-embedder:3.9.6")
  implementation("jakarta.persistence:jakarta.persistence-api:3.2.0-M1")
  implementation("commons-dbutils:commons-dbutils:1.8.1")
  implementation("org.slf4j:slf4j-simple:$slf4jVersion")
  implementation("org.fusesource.jansi:jansi:2.4.1")
  implementation("org.apache.commons:commons-dbcp2:2.11.0")
  implementation("io.smallrye.config:smallrye-config:3.4.2-SNAPSHOT")
  annotationProcessor("info.picocli:picocli-codegen:$picocliVersion")
}

application {
  mainModule = "org.toolkit.cli"
  mainClass = "org.toolkit.cli.ToolkitCLIApplication"
}

graalvmNative {
  metadataRepository { enabled = true }
  binaries {
    named("main") {
      mainClass.set(mainClass)
      sharedLibrary.set(false)
    }
  }
}

// tasks.bootBuildImage { builder.set("paketobuildpacks/builder-jammy-tiny:latest") }

task("copyDependencies", Copy::class) {
  from(configurations.runtimeClasspath).into("${layout.buildDirectory}/jars")
}

task("copyJar", Copy::class) { from(tasks.jar).into("${layout.buildDirectory}/jars") }

tasks.jpackage {
  dependsOn("build", "copyDependencies", "copyJar")

  input = "${layout.buildDirectory}/jars"
  destination = "${layout.buildDirectory}/dist"

  appName = "Non-Modular Application"
  vendor = "app.org"

  mainJar = tasks.jar.get().archiveFileName.get()
  mainClass = mainClass

  javaOptions = listOf("-Dfile.encoding=UTF-8")

  windows { winConsole = true }
}
