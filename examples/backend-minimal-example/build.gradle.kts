plugins{
  id("org.springframework.boot")
  id("io.spring.dependency-management")
}
group = "org.toolkit.example.backend.minimal.example"

version = "1.0-SNAPSHOT"

dependencies {
//  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
//  implementation(projects.modules.core.springBootStarterPersistence)
//  implementation(projects.modules.components.springBootStarterMinio)
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.mysql:mysql-connector-j")
//  developmentOnly("org.springframework.boot:spring-boot-devtools")
  implementation("org.springframework.boot:spring-boot-starter-web")
}
