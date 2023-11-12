group = "org.toolkit.example.backend.minimal.example"

version = "1.0-SNAPSHOT"

dependencies {
  //  implementation(projects.kits.web.springBootToolkitAuthentication)
  //  implementation(projects.kits.minio.springBootToolkitMinioPersistence)
  //  implementation(projects.kits.minio.springBootToolkitMinio)
  implementation("org.springframework.boot:spring-boot-docker-compose")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.mysql:mysql-connector-j")
  implementation("org.springframework.boot:spring-boot-starter-web")
}
