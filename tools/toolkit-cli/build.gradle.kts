plugins {
  application
  id("org.graalvm.buildtools.native") version "0.9.28"
  id("org.panteleyev.jpackageplugin") version "1.6.0"
}

apply<PicoCliProjectPlugin>()

group = "org.toolkit.cli"

version = "1.0"

val toolingApiVersion = "8.5"

repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

val mainClass = "org.toolkit.cli.ToolkitCLIApplication"

dependencies {
  val slf4jVersion: String by project
  val gestaltVersion = "0.24.1"
  implementation("com.google.inject:guice:7.0.0")
  implementation("com.mysql:mysql-connector-j:8.2.0")
  implementation("com.squareup:javapoet:1.13.0")
  implementation("org.gradle:gradle-tooling-api:$toolingApiVersion")
  implementation("org.apache.maven:maven-embedder:3.9.6")
  implementation("jakarta.persistence:jakarta.persistence-api:3.2.0-M1")
  implementation("commons-dbutils:commons-dbutils:1.8.1")
  implementation("org.slf4j:slf4j-simple:$slf4jVersion")
  implementation("org.fusesource.jansi:jansi:2.4.1")
  implementation("com.github.gestalt-config:gestalt-core:$gestaltVersion")
  implementation("com.github.gestalt-config:gestalt-guice:$gestaltVersion")
  implementation("com.github.gestalt-config:gestalt-yaml:$gestaltVersion")
  implementation("com.github.gestalt-config:gestalt-json:$gestaltVersion")
  implementation("com.github.gestalt-config:gestalt-toml:$gestaltVersion")
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

sourceSets { create("java9") { java.srcDirs("java9") } }

// tasks.bootBuildImage { builder.set("paketobuildpacks/builder-jammy-tiny:latest") }

task("copyDependencies", Copy::class) {
  from(configurations.runtimeClasspath).into("${layout.buildDirectory}/jars")
}

task("copyJar", Copy::class) { from(tasks.jar).into("${layout.buildDirectory}/jars") }

tasks.jpackage {
  dependsOn("build", "copyDependencies", "copyJar")

  input = "${layout.buildDirectory}/jars"
  destination = "${layout.buildDirectory}/dist"

  appName = "ToolkitCLI"
  vendor = "app.org"

  mainJar = tasks.jar.get().archiveFileName.get()
  mainClass = mainClass

  javaOptions = listOf("-Dfile.encoding=UTF-8")

  windows { winConsole = true }
}
