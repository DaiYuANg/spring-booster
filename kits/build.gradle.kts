import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

subprojects {
  apply {
    plugin("java-library")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
  }

  the<DependencyManagementExtension>().apply {
    imports { mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) }
  }

  dependencies{
    api("org.springframework.boot:spring-boot-starter-json")
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-aop")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("com.h2database:h2")
  }
}
