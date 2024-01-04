plugins {
  application
  alias(libs.plugins.graalvmNative)
  `spring-boot-project`
}

dependencyManagement { imports { mavenBom("${libs.springShellBom.get()}") } }

repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

val mainClassPath = "org.spring.boost.SpringBoostCLI"

dependencies {
  implementation(libs.mysql)
  implementation(libs.javapoet)
  implementation(libs.jakartaPersistence)
  implementation(libs.commonsDBUtil)
  implementation(libs.jansi)
  implementation(libs.jlineNative)
  implementation(libs.springShellStarter)
  implementation(libs.springBootJdbc)
}

application { mainClass = mainClassPath }

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
