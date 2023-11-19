import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension

plugins{
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    java
}
the<DependencyManagementExtension>().apply {
    imports { mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) }
}

dependencies{
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks{
    withType<Jar> {
        enabled = true
        duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }
}