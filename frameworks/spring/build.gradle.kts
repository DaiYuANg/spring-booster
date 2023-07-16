import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.springframework.boot.gradle.tasks.bundling.BootJar

//import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management") apply false
}

//val springBootVersion:String by project
subprojects {
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

    the<DependencyManagementExtension>().apply {
        imports {
            mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
        }
    }

    dependencies {
        compileOnly("org.springframework.boot:spring-boot-starter")
        compileOnly("org.springframework.boot:spring-boot-starter-web")
        testImplementation("org.springframework.boot:spring-boot-starter-test")
        testImplementation("org.springframework.boot:spring-boot-starter-web")
        testImplementation("org.springframework.boot:spring-boot-starter")
        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    }

    tasks {
        withType<BootJar> {
            enabled = false
        }

        withType<Jar> {
            enabled = true
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }

        withType<JavaCompile> {
            dependsOn("processResources")
        }
    }
}