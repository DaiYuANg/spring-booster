group = "org.toolkit.example.backend.minimal.example"

version = "1.0-SNAPSHOT"

dependencies {
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  //    implementation(projects.core.springBootStarterPersistence)
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.mysql:mysql-connector-j")
  developmentOnly("org.springframework.boot:spring-boot-devtools:3.1.4")
  implementation("org.springframework.boot:spring-boot-starter-web")
}
