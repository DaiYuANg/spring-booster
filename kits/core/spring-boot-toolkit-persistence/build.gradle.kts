group = "org.toolkit.spring.boot.starter.persistence"

version = "1.0-SNAPSHOT"

dependencies {
  val jakartaPersistenceVersion: String by project
  implementation("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
  compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
}
