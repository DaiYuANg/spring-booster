plugins { id("org.graalvm.buildtools.native") version "0.9.20" }

tasks { named("publish") { enabled = false } }

dependencies {
  implementation(projects.springBootStarterAuthentication)
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.baomidou:mybatis-plus:3.5.3.1")
  implementation("com.h2database:h2")
  implementation("org.ehcache:ehcache:3.10.8")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

tasks { named("bootJar") {} }

tasks { named("publish") { enabled = false } }
