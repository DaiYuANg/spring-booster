plugins {
  application
  alias(libs.plugins.graalvm.native)
}

apply<SpringBootProject>()


repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

val mainClassPath = "org.spring.boost.cli.SpringBoostCLI"

dependencies {
  implementation(enforcedPlatform(projects.bom.springBoostBom))
  implementation(projects.libs.springBoostMutiny)
  implementation(libs.mysql)
  implementation(libs.javapoet)
  implementation(libs.jakarta.persistence)
  implementation(libs.apache.common.dbutil)
  implementation(libs.apache.common.io)
  implementation(libs.spring.shell.starter)
  implementation(libs.spring.shell.starter.jna)
  implementation(libs.spring.shell.starter.jansi)
  implementation(libs.spring.boot.starter.jdbc)
  implementation(libs.sqlite)
  implementation(libs.postgresql)
  implementation(libs.spring.boot.starter.freemarker)
  compileOnly(libs.spring.boot.devtools)
  implementation(libs.spring.boot.starter.logging)
  testImplementation(libs.testcontainers.mysql)
  compileOnly(libs.spring.boot.docker.compose)
  implementation(libs.schemacrawler)
  implementation(libs.schemacrawler.mysql)
  implementation(libs.schemacrawler.sqlite)
  implementation(libs.schemacrawler.sqlserver)
  implementation(libs.schemacrawler.postgres)
  implementation(libs.logback.core)
  implementation(libs.logback.classic)
  implementation(projects.libs.springBoostMutiny)
  implementation(libs.mutiny)
  implementation(libs.javaparser.core)

  implementation(libs.record.builder.core)
  annotationProcessor(libs.record.builder.processor)

  implementation(libs.maven.model)
  implementation(libs.maven.embeder)
  implementation(libs.gradle.tooling.api)

  compileOnly(libs.immutables.value)
  annotationProcessor(libs.immutables.value)
}

application {
  mainClass = mainClassPath
  applicationDefaultJvmArgs = listOf(
    "-XX:+UseZGC",
    "-XX:+ZGenerational",
    "-XX:+AlwaysPreTouch"
  )
}

graalvmNative {
  metadataRepository { enabled = true }
  binaries {
    named("main") {
      mainClass.set(mainClassPath)
      sharedLibrary.set(false)
      quickBuild.set(false)
      buildArgs.add("-H:+UnlockExperimentalVMOptions")
    }
  }
}