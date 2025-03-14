//import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
//import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import name.remal.gradle_plugins.lombok.LombokPlugin
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.api.plugins.JavaLibraryPlugin
import org.gradle.api.plugins.JavaPlugin
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.*
import org.springframework.boot.gradle.plugin.SpringBootAotPlugin
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar

class SpringBootProject : Plugin<Project> {
  override fun apply(target: Project) {
    val rootLib = rootLibs(target)
    applyPlugins(target)
    configure(target)
    applyDependencies(target, rootLib)
    val jar: Jar by target.tasks
    val bootJar: BootJar by target.tasks
    bootJar.enabled = false
    jar.enabled = true
  }

  private fun configure(target: Project) {
//    target.the<DependencyManagementExtension>().apply {
//      imports { mavenBom(SpringBootPlugin.BOM_COORDINATES) }
//    }
    target.tasks.withType(Jar::class.java) {
      enabled = true
      duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
  }

  private fun applyPlugins(target: Project) {
    target.apply<LombokPlugin>()
    target.apply<SpringBootPlugin>()
//    target.apply<DependencyManagementPlugin>()
    target.apply<SpringBootAotPlugin>()
  }

  private fun applyDependencies(target: Project, libs: LibrariesForLibs) {
    target.dependencies {
      add(COMPILE_ONLY, libs.spring.boot.starter)
      add(COMPILE_ONLY, libs.spring.boot.starter.aop)
      add(COMPILE_ONLY, libs.spring.boot.starter.actuator)
      add(COMPILE_ONLY, libs.spring.boot.starter.json)
      add(COMPILE_ONLY, libs.jetbrains.annotation)
//      add(ANNOTATION_PROCESSOR, libs.spring.boot.configuration.processor)
      add(TEST_IMPLEMENTATION, libs.spring.boot.starter.test)
    }
  }
}