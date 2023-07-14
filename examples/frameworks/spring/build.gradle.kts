plugins {
    id("org.springframework.boot") version "3.1.1" apply (false)
    id("io.spring.dependency-management") version "1.1.0"
}

tasks.publish {
    enabled = false
}

tasks.jar {
    enabled = false
}

subprojects {
    apply {
        plugin("org.springframework.boot")
        plugin("io.spring.dependency-management")
    }

//    configurations {
//        compileOnly {
//            extendsFrom annotationProcessor
//        }
//    }

    dependencies {
        implementation("org.springframework.boot:spring-boot-starter-actuator")
        //        implementation "org.springframework.boot:spring-boot-starter-web"
        //        annotationProcessor "org.springframework.boot:spring-boot-configuration-processor"
        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}