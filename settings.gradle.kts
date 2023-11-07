pluginManagement {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }

  plugins {
    val gitPluginVersion: String by settings
    val spotbugsBaseVersion: String by settings
    val spotlessPluginVersion: String by settings
    val dependencycheckVersion: String by settings
    val jmhPluginVersion: String by settings
    val jreleaserVersion: String by settings
    val lombokPluginVersion: String by settings
    val nodePluginVersion: String by settings
    val springBootVersion: String by settings
    val springDependencyManagementVersion: String by settings
    val gradlePreCommitGitGooksVersion: String by settings
    val webjarVersion: String by settings
    id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.9"
    id("com.gradle.enterprise") version "3.13.4"
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version springDependencyManagementVersion
    id("com.palantir.git-version") version gitPluginVersion
    id("com.github.spotbugs-base") version spotbugsBaseVersion
    id("com.diffplug.spotless") version spotlessPluginVersion
    id("org.owasp.dependencycheck") version dependencycheckVersion
    id("me.champeau.jmh") version jmhPluginVersion
    id("io.freefair.lombok") version lombokPluginVersion
    id("org.jreleaser") version jreleaserVersion
    id("com.github.node-gradle.node") version nodePluginVersion
    id("com.coditory.webjar") version webjarVersion
    id("com.github.ben-manes.versions") version "0.47.0"
    id("org.danilopianini.gradle-pre-commit-git-hooks") version gradlePreCommitGitGooksVersion
  }
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

plugins {
  id("com.gradle.enterprise")
  id("org.danilopianini.gradle-pre-commit-git-hooks")
}

buildCache {
  local {
    isEnabled = true
    directory = File(rootProject.projectDir, ".gradle/build-cache")
  }
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

gitHooks {
  //    preCommit {
  //        logger.log(LogLevel.INFO,"pre commit")
  //    }
  //    createHooks()
}

rootProject.name = "Toolkit"

// ------------frameworks------------

// ------------core----------
include("modules:core:spring-boot-starter-restful")

include("modules:core:spring-boot-starter-persistence")

include("modules:core:spring-boot-starter-i18n")

// ------------components ----------
include("modules:components:spring-boot-starter-minio")

include("modules:components:spring-boot-starter-office")

include("modules:components:spring-boot-starter-ocr")

include("modules:components:spring-boot-starter-recorder")

include("modules:components:spring-boot-starter-auth")

// ---------- helpful---------
include("modules:helpful:spring-boot-starter-cached")

include("modules:helpful:spring-boot-starter-verification")

// -----------examples-------------
include("modules:examples:backend-minimal-example")

include("modules:components:spring-boot-starter-mapped")

findProject(":modules:components:spring-boot-starter-mapped")?.name = "spring-boot-starter-mapped"
include("modules:components:spring-boot-starter-vertx")
findProject(":modules:components:spring-boot-starter-vertx")?.name = "spring-boot-starter-vertx"
include("modules:toolkit-cli")
findProject(":modules:toolkit-cli")?.name = "toolkit-cli"
include("modules:components:spring-boot-starter-minio-persistence")
findProject(":modules:components:spring-boot-starter-minio-persistence")?.name = "spring-boot-starter-minio-persistence"
include("modules:spring-boot-stater-utils")
findProject(":modules:spring-boot-stater-utils")?.name = "spring-boot-stater-utils"
