pluginManagement {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }

    plugins {
        val kotlinxBenchmarkVersion: String by settings
        val kotlinVersion: String by settings
        val gitPluginVersion: String by settings
        val spotbugsBaseVersion: String by settings
        val spotlessPluginVersion: String by settings
        val dependencycheckVersion: String by settings
        val jmhPluginVersion: String by settings
        val jreleaserVersion: String by settings
        val lombokPluginVersion: String by settings
        val nodePluginVersion: String by settings
        val springBootVersion:String by settings
        val springDependencyManagementVersion:String by settings
        val gradlePreCommitGitGooksVersion:String by settings
        id("org.jetbrains.kotlinx.benchmark") version kotlinxBenchmarkVersion
        id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.9"
        id("com.gradle.enterprise") version "3.13.4"
        id("org.jetbrains.kotlinx.benchmark") version kotlinxBenchmarkVersion
        id("org.jetbrains.kotlin.plugin.lombok") version kotlinVersion
        id("org.jetbrains.kotlin.plugin.allopen") version kotlinVersion
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
        kotlin("plugin.spring") version kotlinVersion
        kotlin("noarg") version kotlinVersion
        kotlin("kapt") version kotlinVersion
        kotlin("plugin.jpa") version kotlinVersion
        id("com.palantir.git-version") version gitPluginVersion
        id("org.jetbrains.kotlin.jvm") version kotlinVersion
        id("com.github.spotbugs-base") version spotbugsBaseVersion
        id("com.diffplug.spotless") version spotlessPluginVersion
        id("org.owasp.dependencycheck") version dependencycheckVersion
        id("me.champeau.jmh") version jmhPluginVersion
        id("io.freefair.lombok") version lombokPluginVersion
        id("org.jreleaser") version jreleaserVersion
        id("com.github.node-gradle.node") version nodePluginVersion
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
    preCommit {
        logger.log(LogLevel.INFO,"pre commit")
    }
    createHooks()
}
// gitHooks {
//	preCommit {
//		 添加 pre-commit 钩子的逻辑
//	}
// }

rootProject.name = "toolkit4J"

// ------------libs------------
include("libs:helpers")
project(":libs:helpers").name = "helpers"

include("libs:thready")
project(":libs:thready").name = "thready"

include("libs:io")
project(":libs:io").name = "io"

include("libs:cache:cache-simple")
findProject(":libs:cache:cache-simple")?.name = "cache-simple"

include("libs:cache:cache-redis-lettuce")
findProject(":libs:cache:cache-redis-lettuce")?.name = "cache-redis-lettuce"

include("libs:constant")
findProject(":libs:constant")?.name = "constant"

// ------------frameworks------------
include("frameworks:spring:spring-boot-starter-authentication")
project(":frameworks:spring:spring-boot-starter-authentication").name =
    "spring-boot-starter-authentication"

include("frameworks:spring:spring-boot-starter-monitor")
project(":frameworks:spring:spring-boot-starter-monitor").name = "spring-boot-starter-monitor"

include("frameworks:spring:spring-boot-starter-io")
project(":frameworks:spring:spring-boot-starter-io").name = "spring-boot-starter-io"

include("frameworks:spring:spring-boot-starter-notifications")
project(":frameworks:spring:spring-boot-starter-notifications").name =
    "spring-boot-starter-notifications"

include("frameworks:spring:spring-boot-starter-async")
project(":frameworks:spring:spring-boot-starter-async").name = "spring-boot-starter-async"

include("frameworks:spring:spring-boot-starter-event")
project(":frameworks:spring:spring-boot-starter-event").name = "spring-boot-starter-event"

include("frameworks:spring:spring-boot-starter-scheduled")
project(":frameworks:spring:spring-boot-starter-scheduled").name = "spring-boot-starter-scheduled"

include("frameworks:spring:spring-boot-starter-locker")
project(":frameworks:spring:spring-boot-starter-locker").name = "spring-boot-starter-locker"

include("frameworks:spring:spring-boot-starter-restful")
project(":frameworks:spring:spring-boot-starter-restful").name = "spring-boot-starter-restful"

include("frameworks:spring:spring-boot-starter-recorder")
project(":frameworks:spring:spring-boot-starter-recorder").name = "spring-boot-starter-recorder"

include("frameworks:spring:spring-boot-starter-dict")
project(":frameworks:spring:spring-boot-starter-dict").name = "spring-boot-starter-dict"

include("frameworks:spring:spring-boot-starter-cached")
findProject(":frameworks:spring:spring-boot-starter-cached")?.name = "spring-boot-starter-cached"

include("frameworks:spring:spring-boot-starter-china-region")
findProject(":frameworks:spring:spring-boot-starter-china-region")?.name = "spring-boot-starter-china-region"

include("frameworks:spring:spring-boot-starter-office")
findProject(":frameworks:spring:spring-boot-starter-office")?.name = "spring-boot-starter-office"
// ------------examples------------
include("examples:frameworks:spring:spring-boot-curd-example")
project(":examples:frameworks:spring:spring-boot-curd-example").name = "spring-boot-curd-example"

// ------------standard------------
include("standard:rbac")
project(":standard:rbac").name = "rbac"

include("standard:persistence")
project(":standard:persistence").name = "persistence"

include("standard:communication")
project(":standard:communication").name = "communication"

include("standard:locker")
project(":standard:locker").name = "locker"

include("standard:restful")
project(":standard:restful").name = "restful"

include("docs")
project(":docs").name = "docs"

// ------------ui------------
include("ui:monitor-ui")
project(":ui:monitor-ui").name = "monitor-ui"

