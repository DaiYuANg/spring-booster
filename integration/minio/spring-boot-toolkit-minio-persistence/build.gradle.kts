group = "org.toolkit.spring.boot.starter.minio.persistence"

version = "1.0-SNAPSHOT"

dependencies {
  api(projects.kits.core.springBootToolkitPersistence)
  api(projects.kits.core.springBootToolkitUtils)
  api(projects.integration.minio.springBootToolkitMinioCore)
  api("org.springframework.boot:spring-boot-starter-data-rest")
  api("org.springframework.data:spring-data-rest-webmvc")
  api("org.springframework.data:spring-data-rest-hal-explorer")
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
  testImplementation("org.testcontainers:mysql:1.19.1")
}
