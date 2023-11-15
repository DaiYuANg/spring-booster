pluginManagement {
  repositories {
    maven { setUrl("https://maven.aliyun.com/repository/gradle-plugin") }
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
    maven { setUrl("https://jitpack.io") }
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
    val kotlinVersion: String by settings
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
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.7.0"
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

include("kits:core:spring-boot-toolkit-persistence")

include("kits:core:spring-boot-toolkit-utils")

include("kits:web:spring-boot-toolkit-authentication")

include("kits:web:spring-boot-toolkit-i18n")

include("kits:web:spring-boot-toolkit-web-core")

include("kits:web:spring-boot-toolkit-verification")

include("kits:cache:spring-boot-toolkit-cache")

include("kits:biz:spring-boot-toolkit-ocr")

include("kits:biz:spring-boot-toolkit-office")

include("kits:biz:spring-boot-toolkit-recorder")

include("kits:mapping:spring-boot-toolkit-mapping-core")

include("apps:cli-application")

include("apps:example-application")

include("kits:web:spring-boot-toolkit-web-annotation")

include("integration:vertx:spring-boot-toolkit-vertx-web")

include("integration:vertx:spring-boot-toolkit-vertx-clustering")

include("kits:biz:spring-boot-toolkit-route")

include("kits:biz:spring-boot-toolkit-email")

include("integration:spring-boot-toolkit-tika")

include("integration:minio:spring-boot-toolkit-minio-core")

include("integration:minio:spring-boot-toolkit-minio")

include("integration:minio:spring-boot-toolkit-minio-persistence")

include("integration:vertx:spring-boot-toolkit-vertx-core")

include("integration:vertx:spring-boot-toolkit-vertx-event-bus")

include("kits:mapping:spring-boot-toolkit-mapping-code-source")

include("kits:mapping:spring-boot-toolkit-mapping-database-source")

include("kits:mapping:spring-boot-toolkit-mapping-web")

include("website")
