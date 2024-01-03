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
}

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

buildCache {
    local {
        isEnabled = true
        directory = File(rootProject.projectDir, ".gradle/build-cache")
    }
}

rootProject.name = "spring-boost"

include("spring-boost-persistence")

include("spring-boost-common")

include("spring-boost-authentication")

include("spring-boost-web-core")

include("spring-boost-verification")

include("spring-boost-office")

include("spring-boost-recorder")

include("spring-boost-mapping-core")

include("spring-boost-mapping-base")

include("spring-boost-web-annotation")

include("spring-boost-minio")

include("spring-boost-mapping-code-source")

include("spring-boost-mapping-database-source")

include("spring-boost-mapping-web")

include("spring-boost-dev-service")

include("spring-boost-dotenv")

include("spring-boost-scanner")

include("spring-boost-cache")

include("spring-boost-web-version")

include("spring-boost-cli")
