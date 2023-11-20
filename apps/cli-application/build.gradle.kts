plugins {
  application
  id("org.graalvm.buildtools.native") version "0.9.27"
  id("org.panteleyev.jpackageplugin") version "1.5.2"
}

group = "org.toolkit.cli"

version = "1.0"

val toolingApiVersion = "8.4"

repositories{
  maven { url = uri("https://repo.gradle.org/gradle/libs-releases") }
}

val mainClass = "org.toolkit.cli.ToolkitCLIApplication"

dependencyManagement {
  val springShellVersion: String by project
  imports { mavenBom("org.springframework.shell:spring-shell-dependencies:$springShellVersion") }
  imports { mavenBom("org.springframework.modulith:spring-modulith-bom:1.0.2") }
}

dependencies {
  implementation("org.springframework.shell:spring-shell-starter")
  implementation("me.paulschwarz:spring-dotenv:4.0.0")
  implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
  implementation("com.mysql:mysql-connector-j")
  implementation("com.squareup:javapoet:1.13.0")
  implementation("jakarta.persistence:jakarta.persistence-api")
  implementation("org.springframework.boot:spring-boot-starter-validation")
  developmentOnly("org.springframework.boot:spring-boot-devtools")
  implementation("org.gradle:gradle-tooling-api:$toolingApiVersion")
  implementation("org.apache.maven:maven-embedder:4.0.0-alpha-8")
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

tasks.bootBuildImage { builder.set("paketobuildpacks/builder-jammy-tiny:latest") }

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
