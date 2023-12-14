//import io.freefair.gradle.plugins.lombok.LombokPlugin
import com.palantir.gradle.gitversion.GitVersionPlugin
import me.champeau.jmh.JMHPlugin
import name.remal.gradle_plugins.lombok.LombokPlugin
import net.ltgt.gradle.errorprone.ErrorPronePlugin
import org.gradle.api.publish.maven.internal.publisher.MavenLocalPublisher
import org.jetbrains.dokka.gradle.DokkaPlugin

plugins {
    `java-library`
    pmd
    idea
    id("com.github.ben-manes.versions")
    id("com.palantir.git-version")
    id("org.owasp.dependencycheck")
    id("me.champeau.jmh") apply false
    id("name.remal.lombok") version "2.2.4" apply false
    id("org.jreleaser")
    id("net.ltgt.errorprone") version "3.1.0"
    id("org.jetbrains.dokka") version "1.9.10"
    `maven-publish`
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

group = "org.toolkit"

version = "1.0-SNAPSHOT"

true.also { gradle.startParameter.isBuildCacheEnabled = it }

val jdkVersion = libs.versions.jdkVersion.get()

subprojects {
    val jdkVersion: String by project
//    apply<JavaLibraryPlugin>()
    apply<JMHPlugin>()
    apply<LombokPlugin>()
    apply<GitVersionPlugin>()
    apply<FormatterPlugin>()
    apply<ErrorPronePlugin>()
    apply<JMHPlugin>()
    apply<MavenPublishPlugin>()
    apply<DokkaPlugin>()

    group = "org." + rootProject.name + "." + project.name
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    val details = versionDetails()
    version = details.lastTag

    dependencies {
        val gsonVersion: String by project
        val mapstructVersion: String by project
        val guavaVersion: String by project
        val slf4jVersion: String by project
        val commonIOVersion: String by project
        val jetbrainsAnnotationsVersion: String by project
        val immutablesVersion: String by project
        val jakartaJsonVersion: String by project
        val junitVersion: String by project
        val testContainersVersion: String by project
//        implementation("org.mapstruct:mapstruct:${mapstructVersion}")
//        implementation("com.google.guava:guava:${guavaVersion}")
        implementation("org.slf4j:slf4j-api:${slf4jVersion}")
//        implementation("commons-io:commons-io:${commonIOVersion}")
//        implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
//        implementation("org.immutables:value:$immutablesVersion")
//        annotationProcessor("org.immutables:value:$immutablesVersion")
        // https://mvnrepository.com/artifact/jakarta.annotation/jakarta.annotation-api
//        implementation("jakarta.annotation:jakarta.annotation-api:3.0.0-M1")
        errorprone("com.google.errorprone:error_prone_core:2.23.0")
        errorprone("tech.picnic.error-prone-support:error-prone-contrib:0.14.0")
        errorprone("tech.picnic.error-prone-support:refaster-runner:0.14.0")
//        annotationProcessor("com.google.auto.factory:auto-factory:1.1.0")
//        annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
        testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
        testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
        testImplementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
        testImplementation("org.testcontainers:testcontainers:$testContainersVersion")
        testImplementation("org.testcontainers:testcontainers")
        testImplementation("org.testcontainers:junit-jupiter")
        testImplementation("org.mockito:mockito-core:5.8.0")
        testImplementation("org.mockito:mockito-junit-jupiter:5.8.0")
    }

    tasks {
        withType<JavaCompile> {
            options.isIncremental = true
            options.encoding = "UTF-8"
            options.compilerArgs.add("-Xlint:all")
            options.compilerArgs.add("-g")
        }
        withType<Test> { useJUnitPlatform() }

        withType<Test>().configureEach {
            maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
        }

        withType<Jar> {
            enabled = true
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
            manifest {
                attributes(
                    "Git-Hash" to details.gitHash
                )
            }
        }

        withType<JavaCompile> {
            dependsOn(project.tasks.processResources)
        }
        java {
            sourceCompatibility = JavaVersion.toVersion(jdkVersion)
            targetCompatibility = JavaVersion.toVersion(jdkVersion)
            toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion)) }
        }
    }

    tasks.test {
        useJUnitPlatform()
        systemProperties["junit.jupiter.execution.parallel.enabled"] = true
        systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
        maxParallelForks = Runtime.getRuntime().availableProcessors() * 2
    }
}