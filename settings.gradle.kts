pluginManagement {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }
}

buildCache {
  local {
    isEnabled = true
    directory = File(rootProject.projectDir, ".gradle/build-cache")
  }
}

plugins {
  //		id("org.jetbrains.kotlinx.benchmark")
  // version(org.toolkit4j.versions.VersionOfPlugins.kotlinxBenchmarkVersion)
  id("org.danilopianini.gradle-pre-commit-git-hooks") version "1.1.9"
  id("com.gradle.enterprise") version "3.13.4"
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
  }
}

// gitHooks {
//	preCommit {
//		 添加 pre-commit 钩子的逻辑
//	}
// }

rootProject.name = "toolkit4j"

// ------------libs------------
include("libs:helpers")
project(":libs:helpers").name = "helpers"

include("libs:thready")
project(":libs:thready").name = "thready"

include("libs:io")
project(":libs:io").name = "io"

// ------------frameworks------------
include("frameworks:spring:spring-boot-starter-authentication")
project(":frameworks:spring:spring-boot-starter-authentication").name =
    "spring-boot-starter-authentication"

include("frameworks:spring:spring-boot-starter-message")
project(":frameworks:spring:spring-boot-starter-message").name = "spring-boot-starter-message"

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

include("frameworks:spring:spring-boot-starter-devtools")
project(":frameworks:spring:spring-boot-starter-devtools").name = "spring-boot-starter-devtools"

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

include("ui:monitor-ui")

project(":ui:monitor-ui").name = "monitor-ui"
include("libs:cache:cache-ehcache")
findProject(":libs:cache:cache-ehcache")?.name = "cache-ehcache"
include("standard:cache")
findProject(":standard:cache")?.name = "cache"
include("libs:cache:cache-simple")
findProject(":libs:cache:cache-simple")?.name = "cache-simple"
