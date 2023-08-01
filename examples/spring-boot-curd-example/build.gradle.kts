plugins { id("org.graalvm.buildtools.native") version "0.9.20" }

tasks { named("publish") { enabled = false } }

dependencies {
  implementation(projects.springBootStarterAuthentication)
  //    implementation(projects.frameworks.spring.springBootStarterEvent)
  //    implementation(projects.frameworks.spring.springBootStarterCached)
  //    implementation(projects.frameworks.spring.springBootStarterAuthentication)
  //    implementation(projects.frameworks.spring.springBootStarterDict)
  implementation("org.springframework.boot:spring-boot-starter-web")
  //    developmentOnly("org.springframework.boot:spring-boot-devtools")
  //    implementation(project(":frameworks:spring:spring-boot-starter-monitor"))
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.baomidou:mybatis-plus:3.5.3.1")
  implementation("com.h2database:h2")
  implementation("org.ehcache:ehcache:3.10.8")
  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}

// val springBoot by tasks.getting(org.springframework.boot.gradle.tasks.bundling.BootJar::class) {
//	mainClass = "org.toolkit4j.examples.frameworks.spring.curd.example.SpringBootCurdExample"
// }

tasks {
  named("bootJar") {
    //		duplicatesStrategy = org.gradle.api.tasks.duplicates.DuplicatesStrategy.EXCLUDE
  }
}

// val nativeBuild by tasks.creating(org.graalvm.buildtools.gradle.NativeBuild::class) {
//	mainClass = "org.toolkit4j.examples.frameworks.spring.curd.example.SpringBootCurdExample"
// }

tasks { named("publish") { enabled = false } }
