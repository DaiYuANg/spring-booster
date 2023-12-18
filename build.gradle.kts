import com.palantir.gradle.gitversion.GitVersionPlugin
import io.gitlab.plunts.gradle.plantuml.plugin.ClassDiagramsExtension
import io.gitlab.plunts.gradle.plantuml.plugin.PlantUmlPlugin
import me.champeau.jmh.JMHPlugin
import name.remal.gradle_plugins.lombok.LombokPlugin
import net.ltgt.gradle.errorprone.ErrorPronePlugin
import org.jetbrains.dokka.gradle.DokkaPlugin

plugins {
    `java-library`
    `version-catalog`
    idea
    id("com.github.ben-manes.versions")
    id("com.palantir.git-version")
    id("org.owasp.dependencycheck")
    id("me.champeau.jmh") apply false
    alias(libs.plugins.lombok) apply false
    id("org.jreleaser")
    alias(libs.plugins.plantuml)
    alias(libs.plugins.errorprone)
    alias(libs.plugins.dokka)
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

true.also { gradle.startParameter.isBuildCacheEnabled = it }

val jdkVersion = libs.versions.jdkVersion.get()

subprojects {
    apply<JMHPlugin>()
    apply<LombokPlugin>()
    apply<GitVersionPlugin>()
    apply<FormatterPlugin>()
    apply<ErrorPronePlugin>()
    apply<PlantUmlPlugin>()
    apply<JMHPlugin>()
    apply<MavenPublishPlugin>()
    apply<DokkaPlugin>()

    group = "org." + rootProject.name + "." + project.name
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    val details = versionDetails()
    version = details.lastTag

    dependencies {
        compileOnly(rootProject.libs.jetbrainsAnnotation)
        errorprone(rootProject.libs.errorproneCore)
        testImplementation(platform(rootProject.libs.junitBom))
        testImplementation(rootProject.libs.junitJuiter)
        testImplementation(rootProject.libs.junitApi)
        testRuntimeOnly(rootProject.libs.junitEngine)
        testImplementation(platform(rootProject.libs.testcontainersBom))
        testImplementation(rootProject.libs.testcontainers)
        testImplementation(rootProject.libs.testcontainersJunit)
        testImplementation(rootProject.libs.mockitoCore)
        testImplementation(rootProject.libs.mockitoJunit)
    }

    tasks {
        withType<JavaCompile> {
            options.isIncremental = true
            options.encoding = "UTF-8"
            options.compilerArgs.add("-Xlint:all")
            options.compilerArgs.add("-g")
        }
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


    classDiagrams {
        @Suppress("UNCHECKED_CAST")
        diagram("default", closureOf<ClassDiagramsExtension.ClassDiagram> {
            include(packages().recursive())
            writeTo(file(project.layout.buildDirectory.file("cli.puml")))
        } as groovy.lang.Closure<ClassDiagramsExtension.ClassDiagram>)
    }
}