import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

subprojects {
  apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
  }

  the<DependencyManagementExtension>().apply {
    imports { mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) }
  }

  dependencies{
    testImplementation("com.h2database:h2")
  }
}
