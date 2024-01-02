plugins {
  application
  id("org.graalvm.buildtools.native") version "0.9.28"
  id("org.panteleyev.jpackageplugin") version "1.6.0"
  `spring-boot-project`
}

group = "org.toolkit.cli"

version = "1.0"

dependencyManagement {
  imports { mavenBom("org.springframework.shell:spring-shell-dependencies:3.2.0-RC1") }
}

val toolingApiVersion = "8.5"

repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

val mainClass = "org.toolkit.cli.ToolkitCLIApplication"

dependencies {
  implementation("com.mysql:mysql-connector-j")
  implementation("com.squareup:javapoet:1.13.0")
  implementation("jakarta.persistence:jakarta.persistence-api:3.2.0-M1")
  implementation("commons-dbutils:commons-dbutils:1.8.1")
  implementation("org.fusesource.jansi:jansi:2.4.1")
  implementation("org.jline:jline-native:3.25.0")
  implementation("org.springframework.shell:spring-shell-starter")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
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
