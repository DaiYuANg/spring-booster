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

include("kits:core:spring-boot-toolkit-persistence")
include("kits:core:spring-boot-toolkit-utils")

include("kits:vertx:spring-boot-toolkit-vertx-core")
include("kits:vertx:spring-boot-toolkit-vertx-event-bus")

include("kits:minio:spring-boot-toolkit-minio-core")
include("kits:minio:spring-boot-toolkit-minio")
include("kits:minio:spring-boot-toolkit-minio-persistence")

include("kits:web:spring-boot-toolkit-auth")
include("kits:web:spring-boot-toolkit-i18n")
include("kits:web:spring-boot-toolkit-restful")
include("kits:web:spring-boot-toolkit-verification")

include("kits:cache:spring-boot-toolkit-cache")

include("kits:biz:spring-boot-toolkit-ocr")
include("kits:biz:spring-boot-toolkit-office")
include("kits:biz:spring-boot-toolkit-recorder")

include("kits:mapping:spring-boot-toolkit-mapped")
include("toolkit-cli")

include("examples:backend-minimal-example")
include("kits:vertx:spring-boot-toolkit-vertx-base")
findProject(":kits:vertx:spring-boot-toolkit-vertx-base")?.name = "spring-boot-toolkit-vertx-base"
