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
        val springBootVersion:String by settings
        val springDependencyManagementVersion:String by settings
        val gradlePreCommitGitGooksVersion:String by settings
        val webjarVersion:String by settings
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
        id ("com.coditory.webjar") version webjarVersion
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

rootProject.name = "toolkit4J"

// ------------libs------------
include("libs:helpers")
project(":libs:helpers").name = "helpers"

include("libs:thready")
project(":libs:thready").name = "thready"

include("libs:cache:cache-simple")
findProject(":libs:cache:cache-simple")?.name = "cache-simple"

include("libs:cache:cache-redis-lettuce")
findProject(":libs:cache:cache-redis-lettuce")?.name = "cache-redis-lettuce"

include("libs:restful")
project(":libs:restful").name = "restful"

// ------------frameworks------------
include("frameworks:spring:spring-boot-starter-authentication")
project(":frameworks:spring:spring-boot-starter-authentication").name =
    "spring-boot-starter-authentication"

include("frameworks:spring:spring-boot-starter-monitor")
project(":frameworks:spring:spring-boot-starter-monitor").name = "spring-boot-starter-monitor"

include("frameworks:spring:spring-boot-starter-monitor-ui")
project(":frameworks:spring:spring-boot-starter-monitor-ui").name = "spring-boot-starter-monitor-ui"

include("frameworks:spring:spring-boot-starter-minio")
project(":frameworks:spring:spring-boot-starter-minio").name = "spring-boot-starter-minio"

include("frameworks:spring:spring-boot-starter-event")
project(":frameworks:spring:spring-boot-starter-event").name = "spring-boot-starter-event"

include("frameworks:spring:spring-boot-starter-scheduled")
project(":frameworks:spring:spring-boot-starter-scheduled").name = "spring-boot-starter-scheduled"

include("frameworks:spring:spring-boot-starter-restful")
project(":frameworks:spring:spring-boot-starter-restful").name = "spring-boot-starter-restful"

include("frameworks:spring:spring-boot-starter-recorder")
project(":frameworks:spring:spring-boot-starter-recorder").name = "spring-boot-starter-recorder"

include("frameworks:spring:spring-boot-starter-dict")
project(":frameworks:spring:spring-boot-starter-dict").name = "spring-boot-starter-dict"

include("frameworks:spring:spring-boot-starter-cached")
findProject(":frameworks:spring:spring-boot-starter-cached")?.name = "spring-boot-starter-cached"

include("frameworks:spring:spring-boot-starter-office")
findProject(":frameworks:spring:spring-boot-starter-office")?.name = "spring-boot-starter-office"
// ------------examples------------
include("examples:frameworks:spring:spring-boot-curd-example")
project(":examples:frameworks:spring:spring-boot-curd-example").name = "spring-boot-curd-example"


include("docs")
project(":docs").name = "docs"

// ------------modeling------------
include("modeling:rbac")
project(":modeling:rbac").name = "rbac"

include("modeling:persistence")
project(":modeling:persistence").name = "persistence"
include("libs:office")
findProject(":libs:office")?.name = "office"
