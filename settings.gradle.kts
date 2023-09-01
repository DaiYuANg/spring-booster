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

rootProject.name = "spring-boot-toolkit"

// ------------frameworks------------
include(":spring-boot-starter-authentication")

project(":spring-boot-starter-authentication").name = "spring-boot-starter-authentication"

include(":spring-boot-starter-minio")

project(":spring-boot-starter-minio").name = "spring-boot-starter-minio"

include(":event-driven:spring-boot-starter-event")

project(":event-driven:spring-boot-starter-event").name = "spring-boot-starter-event"

include(":spring-boot-starter-restful")

project(":spring-boot-starter-restful").name = "spring-boot-starter-restful"

include(":spring-boot-starter-recorder")

project(":spring-boot-starter-recorder").name = "spring-boot-starter-recorder"

include(":spring-boot-starter-dict")

project(":spring-boot-starter-dict").name = "spring-boot-starter-dict"

include(":spring-boot-starter-cached")

findProject(":spring-boot-starter-cached")?.name = "spring-boot-starter-cached"

include(":spring-boot-starter-office")

findProject(":spring-boot-starter-office")?.name = "spring-boot-starter-office"

include("spring-boot-starter-persistence")

findProject(":spring-boot-starter-persistence")?.name = "spring-boot-starter-persistence"

include("spring-boot-starter-ocr")

findProject("spring-boot-starter-ocr")?.name = "spring-boot-starter-ocr"

include("event-driven:spring-boot-starter-event-bus")

findProject(":event-driven:spring-boot-starter-event-bus")?.name = "spring-boot-starter-event-bus"
// ------------examples------------
include("examples:toolkit-example-all")

project(":examples:toolkit-example-all").name = "toolkit-example-all"
