pluginManagement {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }
}
plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
  id("org.danilopianini.gradle-pre-commit-git-hooks") version "2.0.2"
  id("com.gradle.enterprise") version "3.13.4"
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

buildCache {
  local {
    isEnabled = true
    directory = File(rootProject.projectDir, ".gradle/build-cache")
  }
}

gitHooks {
  commitMsg {
    conventionalCommits {
      defaultTypes()
    }
  }
  createHooks(true) // actual hooks creation
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

rootProject.name = "spring-booster"

include("libs:spring-boost-jpa")

include("libs:spring-boost-rbac")

include("libs:spring-boost-core")

include("libs:spring-boost-authentication")

include("libs:spring-boost-authentication-jwt")

include("libs:spring-boost-web")

include("libs:spring-boost-verification")

include("libs:spring-boost-office")


include("libs:spring-boost-web-version")

include("libs:spring-boost-captcha")

include("tools:spring-boost-cli")

include("libs:spring-boost-mutiny")

include("document")

include("bom:spring-boost-bom")

include("tools:spring-boost-annotation-codegen")
include("tools:spring-boost-annotation")
include("tools:spring-boost-gradle-plugin")
include("tools:spring-boost-maven-plugin")
include("libs:spring-boost-fs")
include("libs:spring-boost-fs-local")
include("libs:spring-boost-fs-minio")
include("libs:spring-boost-admin")
