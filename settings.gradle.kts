pluginManagement {
    repositories {
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }
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
        id("com.palantir.git-version") version gitPluginVersion
        id("org.owasp.dependencycheck") version dependencycheckVersion
        id("me.champeau.jmh") version jmhPluginVersion
        id("io.freefair.lombok") version lombokPluginVersion
        id("org.jreleaser") version jreleaserVersion
        id("com.github.node-gradle.node") version nodePluginVersion
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

rootProject.name = "Nectar"

include("framework:spring-boot:spring-boot-persistence")

include("framework:spring-boot:spring-boot-utils")

include("framework:spring-boot:spring-boot-authentication")

include("framework:spring-boot:spring-boot-i18n")

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

include("framework:spring-boot:spring-boot-route")

include("framework:spring-boot:spring-boot-email")

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

include("kits:cache-api")

include("kits:cache-redis")

include("kits:cache-annotation")

include("kits:cache-hazelcast")

include("kits:cache-caffine")

include("kits:cache-immutable")

include("kits:codegen-annotation")

include("tools:toolkit-cli")

include("kits:minio-wrapper")

include("kits:collections")

include("kits:refined")

include("codegen:mapping-indexer-codegen")
