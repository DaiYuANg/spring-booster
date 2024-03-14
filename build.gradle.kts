import com.palantir.gradle.gitversion.GitVersionPlugin
import io.freefair.gradle.plugins.lombok.LombokPlugin
import io.gitlab.plunts.gradle.plantuml.plugin.ClassDiagramsExtension
import io.gitlab.plunts.gradle.plantuml.plugin.PlantUmlPlugin
import me.champeau.jmh.JMHPlugin
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar
import java.nio.charset.StandardCharsets


plugins {
    `java-library`
    `version-catalog`
    idea
    alias(libs.plugins.versionCheck)
    alias(libs.plugins.gitVersion)
    alias(libs.plugins.dependencycheck) apply false
    alias(libs.plugins.jmh) apply false
    alias(libs.plugins.jreleaser) apply false
    alias(libs.plugins.lombok) apply false
    alias(libs.plugins.plantuml)
    alias(libs.plugins.dokka)
    `maven-publish`
}

idea {

}

allprojects {
    repositories {
//        maven { setUrl("https://repo.spring.io/snapshot") }
//        maven { setUrl("https://repo.spring.io/milestone") }
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
//            apply<FormatterPlugin>()
            apply<PlantUmlPlugin>()
            apply<MavenPublishPlugin>()
            apply<PmdPlugin>()
            apply<DokkaPlugin>()

            group = "org." + rootProject.name + "." + project.name
            val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
            val details = versionDetails()
            version = details.lastTag

            dependencies {
                compileOnly(rootProject.libs.jetbrainsAnnotation)
                implementation(rootProject.libs.guava)
                implementation(rootProject.libs.mapstruct)
                annotationProcessor(rootProject.libs.mapstructAnnotationProcessor)
                annotationProcessor(rootProject.libs.lombokMapstructBinding)
                testImplementation(platform(rootProject.libs.junitBom))
                testImplementation(rootProject.libs.junitJuiter)
                testImplementation(rootProject.libs.junitApi)
                testImplementation(rootProject.libs.junitEngine)
                testImplementation(rootProject.libs.junitPlatformSuite)
                testImplementation(platform(rootProject.libs.testcontainersBom))
                testImplementation(rootProject.libs.testcontainers)
                testImplementation(rootProject.libs.testcontainersJunit)
                testImplementation(rootProject.libs.mockitoCore)
                testImplementation(rootProject.libs.mockitoJunit)
                testImplementation(rootProject.libs.dataFaker)
                testImplementation(rootProject.libs.junitperf)
                testImplementation(rootProject.libs.junitperfJunit5)
                testImplementation("io.rest-assured:rest-assured")
                implementation(rootProject.libs.slf4j)
            }
            tasks.withType<BootJar> { enabled = false }

            tasks {
                withType<JavaCompile> {
                    options.isIncremental = true
                    options.encoding = StandardCharsets.UTF_8.name()
                    options.compilerArgs.add("-Xlint:all")
                    options.compilerArgs.add("-g")
                    dependsOn(project.tasks.processResources)
                    options.isFork = true
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
                maxHeapSize = "8g"
                systemProperties["junit.jupiter.execution.parallel.enabled"] = true
                systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
                jvmArgs("-XX:+EnableDynamicAgentLoading")
                maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
                forkEvery = 100
            }

            classDiagrams {
                val glob = "org.${rootProject.name.replace("-", ".")}.**"
                val internal = "internal_class_diagram"
                val full = "full_class_diagram"
                @Suppress("UNCHECKED_CAST")
                diagram(
                    internal,
                    closureOf<ClassDiagramsExtension.ClassDiagram> {
                        include(packages().withNameLike(glob))
                        writeTo(file(project.layout.buildDirectory.file("$internal.${project.name}.$plantUMLSuffix")))
                    }
                            as groovy.lang.Closure<ClassDiagramsExtension.ClassDiagram>,
                )

                @Suppress("UNCHECKED_CAST")
                diagram(
                    full,
                    closureOf<ClassDiagramsExtension.ClassDiagram> {
                        include(packages().withNameLike(glob))
                        include(packages().recursive())
                        writeTo(file(project.layout.buildDirectory.file("$full.${project.name}.$plantUMLSuffix")))
                    }
                            as groovy.lang.Closure<ClassDiagramsExtension.ClassDiagram>,
                )
            }
        }
    }
}