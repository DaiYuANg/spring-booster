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

include("framework:spring-boot:spring-boot-persistence")

include("framework:spring-boot:spring-boot-utils")

include("framework:spring-boot:spring-boot-authentication")

include("framework:spring-boot:spring-boot-web-core")

include("framework:spring-boot:spring-boot-verification")

include("framework:spring-boot:spring-boot-office")

include("framework:spring-boot:spring-boot-recorder")

include("framework:spring-boot:spring-boot-mapping-core")

include("framework:spring-boot:spring-boot-mapping-base")

include("apps:springboot-application")

include("framework:spring-boot:spring-boot-web-annotation")

include("framework:spring-boot:spring-boot-vertx-web")

include("framework:spring-boot:spring-boot-vertx-clustering")

include("framework:spring-boot:spring-boot-minio")

include("framework:spring-boot:spring-boot-vertx-core")

include("framework:spring-boot:spring-boot-vertx-event-bus")

include("framework:spring-boot:spring-boot-mapping-code-source")

include("framework:spring-boot:spring-boot-mapping-database-source")

include("framework:spring-boot:spring-boot-mapping-web")

include("framework:spring-boot:spring-boot-dev-service")

include("framework:spring-boot:spring-boot-dotenv")

include("framework:spring-boot:spring-boot-scanner")

include("framework:spring-boot:spring-boot-cache")

include("framework:spring-boot:spring-boot-web-version")

//include("kits:cache-api")
//
//include("kits:cache-redis")
//
//include("kits:cache-annotation")
//
//include("kits:cache-hazelcast")
//
//include("kits:cache-caffine")
//
//include("kits:cache-immutable")
//
//include("kits:codegen-annotation")
//
include("tools:toolkit-cli")
//
//include("kits:minio-wrapper")
//
//include("kits:collection")
//
//include("kits:refined")

include("codegen:mapping-indexer-codegen")
//include("kits:qrcode")
//findProject(":kits:qrcode")?.name = "qrcode"
//include("kits:dispatcher")
//findProject(":kits:dispatcher")?.name = "dispatcher"
