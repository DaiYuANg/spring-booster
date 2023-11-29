group = "org.toolkit.spring.boot.starter.persistence"

version = "1.0-SNAPSHOT"

dependencies {
  val jakartaPersistenceVersion: String by project
  api("jakarta.persistence:jakarta.persistence-api:$jakartaPersistenceVersion")
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.data:spring-data-envers")

}
