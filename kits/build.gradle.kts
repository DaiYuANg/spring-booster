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

  dependencies {
    val okhttpVersion: String by project
    val hutoolVersion: String by project
    api("org.springframework.boot:spring-boot-starter-json")
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter")
    api("org.springframework.boot:spring-boot-starter-aop")
    implementation("cn.hutool:hutool-all:${hutoolVersion}")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("net.datafaker:datafaker:2.0.2")
    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
  }
}
