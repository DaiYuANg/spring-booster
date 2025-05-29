pluginManagement {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }
}
plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
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

include("libs:spring-boost-captcha")


include("document")

include("libs:spring-boost-bom")

include("libs:spring-boost-annotation-codegen")
include("libs:spring-boost-annotation")

include("libs:spring-boost-minio")
include("libs:spring-boost-authentication-token-redis")