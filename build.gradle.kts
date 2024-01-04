import com.palantir.gradle.gitversion.GitVersionPlugin
import io.freefair.gradle.plugins.lombok.LombokPlugin
import io.gitlab.plunts.gradle.plantuml.plugin.ClassDiagramsExtension
import io.gitlab.plunts.gradle.plantuml.plugin.PlantUmlPlugin
import me.champeau.jmh.JMHPlugin
import net.ltgt.gradle.errorprone.CheckSeverity
import net.ltgt.gradle.errorprone.ErrorPronePlugin
import net.ltgt.gradle.errorprone.errorprone
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
    alias(libs.plugins.jreleaser)
    id("io.freefair.lombok") version "8.4"
    alias(libs.plugins.plantuml)
    alias(libs.plugins.errorprone)
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
val plantUMLSuffix = "puml"
subprojects {
    when {
        project.name != "website" -> {
            apply<LombokPlugin>()
            apply<JMHPlugin>()
            apply<JavaLibraryPlugin>()
            apply<LombokPlugin>()
            apply<GitVersionPlugin>()
            apply<FormatterPlugin>()
            apply<PlantUmlPlugin>()
            apply<MavenPublishPlugin>()
            apply<ErrorPronePlugin>()
            apply<DokkaPlugin>()
            apply<PmdPlugin>()

            group = "org." + rootProject.name + "." + project.name
            val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
            val details = versionDetails()
            version = details.lastTag

            dependencies {
                compileOnly(rootProject.libs.jetbrainsAnnotation)
                implementation(rootProject.libs.guava)
                implementation("org.mapstruct:mapstruct:1.5.5.Final")
                annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
                annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")
                errorprone("com.uber.nullaway:nullaway:0.10.19")
                errorprone("tech.picnic.error-prone-support:error-prone-contrib:0.14.0")
                errorprone("tech.picnic.error-prone-support:refaster-runner:0.14.0")
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
                testImplementation(rootProject.libs.dataFaker)
                testImplementation("com.github.noconnor:junitperf:1.35.0")
                testImplementation("com.github.noconnor:junitperf-junit5:1.35.0")
                implementation(rootProject.libs.slf4j)
            }
            tasks.withType<BootJar> { enabled = false }

            tasks {
                withType<JavaCompile> {
                    options.isIncremental = true
                    options.encoding = "UTF-8"
                    options.compilerArgs.add("-Xlint:all")
                    options.compilerArgs.add("-g")
                    options.errorprone.isEnabled.set(true)
                    options.errorprone.disableWarningsInGeneratedCode.set(true)
                    dependsOn(project.tasks.processResources)
                    if (!name.toLowerCase().contains("test")) {
                        options.errorprone {
                            check("NullAway", CheckSeverity.ERROR)
                            option("NullAway:AnnotatedPackages", "com.uber")
                        }
                    }
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

                java {
                    sourceCompatibility = JavaVersion.toVersion(jdkVersion)
                    targetCompatibility = JavaVersion.toVersion(jdkVersion)
                    toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion)) }
                }
            }

            java {
                withSourcesJar()
                withJavadocJar()
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
                diagram(
                    "classes",
                    closureOf<ClassDiagramsExtension.ClassDiagram> {
                        include(packages().withName("org.${rootProject.name.replace("-", ".")}"))
                        include(packages().recursive())
                        referencedClasses()
                        writeTo(file(project.layout.buildDirectory.file("${project.name}.$plantUMLSuffix")))
                    }
                            as groovy.lang.Closure<ClassDiagramsExtension.ClassDiagram>,
                )
            }
        }
    }
}