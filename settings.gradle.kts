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

include("booster:spring-boost-jpa")

include("booster:spring-boost-core")

include("booster:spring-boost-authentication")

include("booster:spring-boost-authentication-jwt")

include("booster:spring-boost-web-core")

include("booster:spring-boost-verification")

include("booster:spring-boost-office")

include("booster:spring-boost-mapping-core")

include("booster:spring-boost-minio")

include("booster:spring-boost-mapping-code-source")

include("booster:spring-boost-mapping-web")

include("booster:spring-boost-mapping-database")

include("booster:spring-boost-dev-service")

include("booster:spring-boost-dotenv")

include("booster:spring-boost-web-version")

include("booster:spring-boost-captcha")

include("apps:spring-boost-cli")

include("apps:spring-boost-application-example")

include("website")
