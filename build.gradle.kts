import com.palantir.gradle.gitversion.GitVersionPlugin
//import io.freefair.gradle.plugins.lombok.LombokPlugin
import me.champeau.jmh.JMHPlugin
import name.remal.gradle_plugins.lombok.LombokPlugin
//import net.ltgt.gradle.errorprone.CheckSeverity
//import net.ltgt.gradle.errorprone.ErrorPronePlugin
//import net.ltgt.gradle.errorprone.errorprone
import java.util.*

plugins {
    java
    pmd
    idea
    id("com.github.ben-manes.versions")
    id("com.palantir.git-version")
    id("org.owasp.dependencycheck")
    id("me.champeau.jmh") apply false
    id("name.remal.lombok") version "2.2.4" apply false
    id("org.jreleaser")
//    id("net.ltgt.errorprone") version "3.1.0"
}

allprojects {
    apply<TreePlugin>()
    repositories {
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

group = "org.toolkit"

version = "1.0-SNAPSHOT"

true.also { gradle.startParameter.isBuildCacheEnabled = it }

subprojects {
    val jdkVersion: String by project
    apply<JavaPlugin>()
    apply<JavaLibraryPlugin>()
    apply<JMHPlugin>()
    apply<LombokPlugin>()
    apply<GitVersionPlugin>()
    apply<FormatPlugin>()
//    apply<ErrorPronePlugin>()

    group = "org." + rootProject.name + "." + project.name
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    val details = versionDetails()
    version = details.lastTag

    dependencies {
        val gsonVersion: String by project
        val mapstructVersion: String by project
        val guavaVersion: String by project
        val slf4jVersion: String by project
        val rxjavaVersion: String by project
        val commonIOVersion: String by project
        val jetbrainsAnnotationsVersion: String by project
        val immutablesVersion: String by project
        val jakartaJsonVersion: String by project
        val junitVersion: String by project
        val testContainersVersion: String by project
        val hutoolVersion: String by project
        implementation("com.google.code.gson:gson:${gsonVersion}")
        implementation("org.mapstruct:mapstruct:${mapstructVersion}")
        implementation("com.google.guava:guava:${guavaVersion}")
        implementation("org.slf4j:slf4j-api:${slf4jVersion}")
        implementation("io.reactivex.rxjava3:rxjava:${rxjavaVersion}")
        implementation("commons-io:commons-io:${commonIOVersion}")
        implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
        implementation("io.soabase.record-builder:record-builder-core:37")
        implementation("org.inferred:freebuilder:2.8.0")
        implementation("cn.hutool:hutool-all:${hutoolVersion}")
        implementation("org.eclipse.collections:eclipse-collections-api:11.1.0")
        implementation("org.eclipse.collections:eclipse-collections:11.1.0")
        implementation("org.agrona:Agrona:0.9.1")
//        errorprone("com.uber.nullaway:nullaway:0.10.17")
//        errorprone("com.google.errorprone:error_prone_core:2.23.0")
//        errorprone("tech.picnic.error-prone-support:error-prone-contrib:0.14.0")
//        errorprone("tech.picnic.error-prone-support:refaster-runner:0.14.0")
        annotationProcessor("io.soabase.record-builder:record-builder-processor:37")
        annotationProcessor("com.google.auto.factory:auto-factory:1.1.0")
        annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
        annotationProcessor("org.inferred:freebuilder:2.8.0")
        testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
        testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
        testImplementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
        testImplementation("org.testcontainers:testcontainers:$testContainersVersion")
        testImplementation("org.testcontainers:testcontainers")
        testImplementation("org.testcontainers:junit-jupiter")
    }

    tasks {
        withType<JavaCompile> {
            options.isIncremental = true
            options.encoding = "UTF-8"
            options.compilerArgs.add("-Xlint:all")
        }
        withType<Test> { useJUnitPlatform() }

        withType<Jar> {
            enabled = true
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }

        withType<JavaCompile> {
            dependsOn(project.tasks.processResources)
            if (!name.lowercase(Locale.getDefault()).contains("test")) {
//                options.errorprone {
//                    check("NullAway", CheckSeverity.ERROR)
//                    option("NullAway:AnnotatedPackages", "com.uber")
//                }
            }
        }
        java {
            sourceCompatibility = JavaVersion.toVersion(jdkVersion)
            targetCompatibility = JavaVersion.toVersion(jdkVersion)
            toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion)) }
        }
    }
    tasks.test { useJUnitPlatform() }
}
