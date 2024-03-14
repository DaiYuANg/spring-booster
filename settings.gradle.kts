pluginManagement {
  repositories {
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
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

include("spring-boost-jpa")

include("spring-boost-core")

include("spring-boost-authentication")

include("spring-boost-authentication-jwt")

include("spring-boost-web-core")

include("spring-boost-verification")

include("spring-boost-office")

include("spring-boost-mapping-core")

include("spring-boost-minio")

include("spring-boost-mapping-code-source")

include("spring-boost-mapping-database-source")

include("spring-boost-mapping-web")

include("spring-boost-dev-service")

include("spring-boost-dotenv")

include("spring-boost-web-version")

include("spring-boost-cli")

include("spring-boost-application-example")

include("website")