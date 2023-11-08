import java.net.URI
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    pmd
    idea
    tasks
    jacoco
    checkstyle
    commonProject
    id("com.github.ben-manes.versions")
    id("com.palantir.git-version")
    id("com.github.spotbugs-base")
    id("com.diffplug.spotless")
    id("org.owasp.dependencycheck")
    id("me.champeau.jmh") apply false
    id("io.freefair.lombok") apply false
    id("org.jreleaser")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
}

allprojects {
    repositories {
        maven { url = URI("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
        maven { url = URI("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
        maven { url = URI("https://maven.aliyun.com/repository/public") }
        maven { url = URI("https://maven.aliyun.com/repository/spring/") }
        maven { url = URI("https://repo.huaweicloud.com/repository/maven/") }
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

group = "org.toolkit"

version = "1.0-SNAPSHOT"

spotless {
    format("misc") {
        target("*.md", ".gitignore", "**/*.java")
        indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
        endWithNewline()
    }
    java {
        target("**/*.java")
        importOrder()
        palantirJavaFormat()
        indentWithTabs()
        removeUnusedImports()
        formatAnnotations()
    }

    kotlinGradle {
        target("**/*.gradle.kts") // default target for kotlinGradle
        ktfmt() // or ktfmt() or prettier()
    }
}

true.also { gradle.startParameter.isBuildCacheEnabled = it }

subprojects {
    val jdkVersion: String by project

    apply {
        plugin("java")
        plugin("java-library")
        plugin("me.champeau.jmh")
        plugin("io.freefair.lombok")
        plugin("maven-publish")
        plugin("com.palantir.git-version")

    }

    group = "org." + rootProject.name + "." + project.name
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    val details = versionDetails()
    version = details.lastTag

    dependencies {
//        val gsonVersion: String by project
        val mapstructVersion: String by project
        val guavaVersion: String by project
        val slf4jVersion: String by project
        val rxjavaVersion: String by project
        val commonIOVersion: String by project
        val jetbrainsAnnotationsVersion: String by project
        val immutablesVersion: String by project
        val okhttpVersion: String by project
        val hutoolVersion: String by project
        val jakartaJsonVersion: String by project
        val junitVersion: String by project
        val testContainersVersion: String by project
//        api("com.google.code.gson:gson:${gsonVersion}")
        implementation("org.mapstruct:mapstruct:${mapstructVersion}")
        implementation("com.google.guava:guava:${guavaVersion}")
        implementation("org.slf4j:slf4j-api:${slf4jVersion}")
        implementation("io.reactivex.rxjava3:rxjava:${rxjavaVersion}")
        implementation("commons-io:commons-io:${commonIOVersion}")
        implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
        implementation("org.immutables:value:${immutablesVersion}")
        implementation("cn.hutool:hutool-all:${hutoolVersion}")
        implementation("net.bytebuddy:byte-buddy:1.14.5")
        annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
        testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
        testImplementation("net.datafaker:datafaker:2.0.1")
        testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
        testImplementation("org.testcontainers:testcontainers:1.19.0")
        testImplementation("org.testcontainers:junit-jupiter:1.19.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
        testImplementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
    }

    tasks {
        withType<JavaCompile> {
            options.isIncremental = true
            options.encoding = "UTF-8"
        }
        withType<Test> { useJUnitPlatform() }
        withType<BootJar> { enabled = false }

        withType<Jar> {
            enabled = true
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }

        withType<JavaCompile> { dependsOn("processResources") }
        java {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
            toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion)) }
        }
    }
}
