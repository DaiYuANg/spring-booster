//import com.xenoterracide.gradle.semver.SemverExtension
//import com.xenoterracide.gradle.semver.SemverPlugin
//import io.gitlab.plunts.gradle.plantuml.plugin.ClassDiagramsExtension
//import io.gitlab.plunts.gradle.plantuml.plugin.PlantUmlPlugin
//import me.champeau.jmh.JMHPlugin
//import name.remal.gradle_plugins.lombok.LombokPlugin
//import org.gradle.api.JavaVersion
//import org.gradle.api.Plugin
//import org.gradle.api.Project
//import org.gradle.api.file.DuplicatesStrategy
//import org.gradle.api.plugins.JavaLibraryPlugin
//import org.gradle.api.plugins.JavaPluginExtension
//import org.gradle.api.tasks.compile.JavaCompile
//import org.gradle.api.tasks.javadoc.Javadoc
//import org.gradle.api.tasks.testing.Test
//import org.gradle.jvm.tasks.Jar
//import org.gradle.jvm.toolchain.JavaLanguageVersion
//import org.gradle.kotlin.dsl.apply
//import org.gradle.kotlin.dsl.closureOf
//import org.gradle.kotlin.dsl.configure
//import org.gradle.kotlin.dsl.dependencies
//import java.nio.charset.StandardCharsets
//
//class RootProjectSetting : Plugin<Project> {
//  override fun apply(target: Project) {
//    val rootLib = rootLibs(target)
//    val rootProject = rootProject(target)
//    val jdkVersion = rootLib.versions.jdkVersion
//
//    rootProject.apply<SemverPlugin>()
//
//    val semver = target.extensions.getByType(SemverExtension::class.java)
//    val git = semver.git
//
//    rootProject.allprojects {
//      project.version = "${git.branch}-${git.commitShort}"
//    }
//
//    rootProject.subprojects {
//      if (project.name != "website") {
////        apply<JavaLibraryPlugin>()
//
////        apply<JMHPlugin>()
////        apply<LombokPlugin>()
////        apply<PlantUmlPlugin>()
////        apply<ManifestPlugin>()
//
//        group = "org." + rootProject.name + "." + project.name
//
//        dependencies {
//          add(COMPILE_ONLY, rootLib.jetbrainsAnnotation)
//          add(IMPLEMENTATION, rootLib.slf4j)
//          add(IMPLEMENTATION, rootLib.mapstruct)
////          add(ANNOTATION_PROCESSOR, rootLib.mapstructAnnotationProcessor)
//          add(TEST_IMPLEMENTATION, platform(rootLib.junitBom))
//          add(TEST_IMPLEMENTATION, rootLib.junitApi)
//          add(TEST_IMPLEMENTATION, rootLib.junitPlatformSuite)
//          add(TEST_IMPLEMENTATION, rootLib.junitEngine)
//          add(TEST_IMPLEMENTATION, platform(rootLib.testcontainersBom))
//          add(TEST_IMPLEMENTATION, rootLib.testcontainers)
//          add(TEST_IMPLEMENTATION, rootLib.testcontainersJunit)
////          add(TEST_IMPLEMENTATION, rootLib.mockitoCore)
////          add(TEST_IMPLEMENTATION, rootLib.mockitoJunit)
////          add(TEST_IMPLEMENTATION, rootLib.dataFaker)
////          add(TEST_IMPLEMENTATION, rootLib.junitperf)
////          add(TEST_IMPLEMENTATION, rootLib.junitperfJunit5)
//        }
//
//        tasks.withType(JavaCompile::class.java) {
//          options.isIncremental = true
//          options.encoding = StandardCharsets.UTF_8.name()
//          options.compilerArgs.add("-Xlint:divzero,empty,fallthrough")
//          options.compilerArgs.add("-g")
//          options.isFork = true
//        }
//
//        tasks.withType(Javadoc::class.java) {
//          source = source.filter { it.extension != "kt" }.asFileTree
//        }
//
//        tasks.withType(Jar::class.java) {
//          enabled = true
//          duplicatesStrategy = DuplicatesStrategy.INCLUDE
//        }
//
//        configure<JavaPluginExtension> {
//          sourceCompatibility = JavaVersion.toVersion(jdkVersion.get())
//          targetCompatibility = JavaVersion.toVersion(jdkVersion.get())
//          toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion.get())) }
//          withJavadocJar()
//          withSourcesJar()
//        }
//
//        tasks.withType(Javadoc::class.java) {
//          isFailOnError = false
//        }
//
//        tasks.withType(Test::class.java) {
//          useJUnitPlatform()
//          systemProperties["junit.jupiter.execution.parallel.enabled"] = true
//          systemProperties["junit.jupiter.execution.parallel.mode.default"] = "concurrent"
//          jvmArgs("-XX:+EnableDynamicAgentLoading")
//          maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
//          forkEvery = 100
//        }
//
//        configure<ClassDiagramsExtension> {
//          val glob = "org.${rootProject.name.replace("-", ".")}.**"
//          val internal = "internal_class_diagram"
//          val full = "full_class_diagram"
//          @Suppress("UNCHECKED_CAST")
//          diagram(
//            internal,
//            closureOf<ClassDiagramsExtension.ClassDiagram> {
//              include(packages().withNameLike(glob))
//              writeTo(file(project.layout.buildDirectory.file("$internal.${project.name}.$plantUMLSuffix")))
//            }
//              as groovy.lang.Closure<ClassDiagramsExtension.ClassDiagram>,
//          )
//          @Suppress("UNCHECKED_CAST")
//          diagram(
//            full,
//            closureOf<ClassDiagramsExtension.ClassDiagram> {
//              include(packages().withNameLike(glob))
//              include(packages().recursive())
//              writeTo(file(project.layout.buildDirectory.file("$full.${project.name}.$plantUMLSuffix")))
//            }
//              as groovy.lang.Closure<ClassDiagramsExtension.ClassDiagram>,
//          )
//        }
//
////        project.configure<ManifestPluginExtension> {
////          buildAttributes = true
////          implementationAttributes = true
////          scmAttributes = true
////        }
//      }
//    }
//  }
//}