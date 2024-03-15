import io.spring.gradle.dependencymanagement.DependencyManagementPlugin
import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.jvm.tasks.Jar
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.the
import org.springframework.boot.gradle.plugin.SpringBootPlugin

class SpringBootProject : Plugin<Project> {
  override fun apply(target: Project) {
    val rootLib = rootLibs(target)
    applyPlugins(target)
    configure(target)
    applyDependencies(target, rootLib)
  }

  private fun configure(target: Project) {
    target.the<DependencyManagementExtension>().apply {
      imports { mavenBom(SpringBootPlugin.BOM_COORDINATES) }
    }
//    target.configurations.create(COMPILE_ONLY) {
//      extendsFrom(target.configurations.getByName(ANNOTATION_PROCESSOR))
//    }
    target.tasks.withType(Jar::class.java){
      enabled = true
      duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
  }

  private fun applyPlugins(target: Project) {
    target.apply<SpringBootPlugin>()
    target.apply<DependencyManagementPlugin>()
  }

  private fun applyDependencies(target: Project, libs: LibrariesForLibs) {
    target.dependencies {
//      add(COMPILE_ONLY, libs.springBootStarter)
//      add(COMPILE_ONLY, libs.springBootAop)
//      add(COMPILE_ONLY, libs.springBootActuator)
//      add(COMPILE_ONLY, libs.springBootJSON)
      add(ANNOTATION_PROCESSOR, libs.springBootConfigurationProcessor)
      add(TEST_IMPLEMENTATION, libs.springBootTest)
    }
  }
}