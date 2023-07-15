plugins {
    id("org.graalvm.buildtools.native") version "0.9.20"
}

tasks {
    named("publish") {
        enabled = false
    }
}

//configurations {
//	create("developmentOnly")
//	named("runtimeClasspath") {
//		extendsFrom("developmentOnly")
//	}
//}

dependencies {
    implementation(project(":frameworks:spring:spring-boot-starter-async"))
    implementation(project(":frameworks:spring:spring-boot-starter-event"))
    implementation(project(":frameworks:spring:spring-boot-starter-cached"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    // implementation(project(":frameworks:spring:spring-boot-starter-monitor"))
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation(project(":frameworks:spring:spring-boot-starter-authentication"))
    implementation(project(":frameworks:spring:spring-boot-starter-dict"))
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    // implementation("org.xerial:sqlite-jdbc:3.42.0.0")
    implementation("org.hibernate.orm:hibernate-community-dialects")
    implementation("com.baomidou:mybatis-plus:3.5.3.1")
    implementation("com.h2database:h2")
    implementation("org.ehcache:ehcache:3.10.8")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

//val springBoot by tasks.getting(org.springframework.boot.gradle.tasks.bundling.BootJar::class) {
//	mainClass = "org.toolkit4j.examples.frameworks.spring.curd.example.SpringBootCurdExample"
//}

tasks {
    named("bootJar") {
//		duplicatesStrategy = org.gradle.api.tasks.duplicates.DuplicatesStrategy.EXCLUDE
    }
}

//val nativeBuild by tasks.creating(org.graalvm.buildtools.gradle.NativeBuild::class) {
//	mainClass = "org.toolkit4j.examples.frameworks.spring.curd.example.SpringBootCurdExample"
//}

tasks {
    named("publish") {
        enabled = false
    }
}
