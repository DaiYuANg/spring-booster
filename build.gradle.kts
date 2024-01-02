import com.palantir.gradle.gitversion.GitVersionPlugin
import io.freefair.gradle.plugins.lombok.LombokPlugin
import io.gitlab.plunts.gradle.plantuml.plugin.ClassDiagramsExtension
import io.gitlab.plunts.gradle.plantuml.plugin.PlantUmlPlugin
import me.champeau.jmh.JMHPlugin
//import name.remal.gradle_plugins.lombok.LombokPlugin
//import net.ltgt.gradle.errorprone.ErrorPronePlugin
//import net.ltgt.gradle.errorprone.errorprone
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar


plugins {
    `java-library`
    `version-catalog`
    idea
    alias(libs.plugins.versionCheck)
    alias(libs.plugins.gitVersion)
    alias(libs.plugins.dependencycheck)
    alias(libs.plugins.jmh)
//    alias(libs.plugins.lombok) apply false
    alias(libs.plugins.jreleaser)
    id("io.freefair.lombok") version "8.4"
    alias(libs.plugins.plantuml)
//    alias(libs.plugins.errorprone)
    alias(libs.plugins.dokka)
    `maven-publish`
}

allprojects {
    repositories {
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }
        mavenLocal()
        mavenCentral()
        gradlePluginPortal()
        google()
    }
}

true.also { gradle.startParameter.isBuildCacheEnabled = it }

val jdkVersion = libs.versions.jdkVersion.get()

subprojects {
    apply<LombokPlugin>()
    apply<JMHPlugin>()
    apply<SpringBootProjectPlugin>()
    apply<JavaLibraryPlugin>()
    apply<LombokPlugin>()
    apply<GitVersionPlugin>()
    apply<FormatterPlugin>()
    apply<PlantUmlPlugin>()
    apply<MavenPublishPlugin>()
    apply<DokkaPlugin>()

    group = "org." + rootProject.name + "." + project.name
    val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
    val details = versionDetails()
    version = details.lastTag

    dependencies {
        compileOnly(rootProject.libs.jetbrainsAnnotation)
        implementation(rootProject.libs.guava)
//        errorprone(rootProject.libs.errorproneCore)
        testImplementation(platform(rootProject.libs.junitBom))
        testImplementation(rootProject.libs.junitJuiter)
        testImplementation(rootProject.libs.junitApi)
        testRuntimeOnly(rootProject.libs.junitEngine)
        testImplementation(platform(rootProject.libs.testcontainersBom))
        testImplementation(rootProject.libs.testcontainers)
        testImplementation(rootProject.libs.testcontainersJunit)
        testImplementation(rootProject.libs.mockitoCore)
        testImplementation(rootProject.libs.mockitoJunit)
        testImplementation(rootProject.libs.dataFaker)
        implementation(rootProject.libs.slf4j)
    }
    tasks.withType<BootJar> { enabled = false }

    tasks {
        withType<JavaCompile> {
            options.isIncremental = true
            options.encoding = "UTF-8"
            options.compilerArgs.add("-Xlint:all")
            options.compilerArgs.add("-g")
//            options.errorprone.isEnabled.set(true)
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
        minHeapSize = "4g"
        maxParallelForks = Runtime.getRuntime().availableProcessors() * 2
        maxHeapSize = "8g"
        systemProperties["junit.jupiter.execution.parallel.enabled"] = true
        systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
        jvmArgs("-XX:+EnableDynamicAgentLoading")
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