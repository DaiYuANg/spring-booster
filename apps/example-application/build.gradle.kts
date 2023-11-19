group = "org.toolkit.example.backend.minimal.example"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.kits.web.springBootToolkitAuthentication)
  implementation(projects.kits.core.springBootToolkitPersistence)
  implementation(projects.kits.web.springBootToolkitWebCore)
  implementation(projects.kits.biz.springBootToolkitRoute)
  implementation("me.paulschwarz:spring-dotenv:4.0.0")
  implementation("org.springframework.data:spring-data-rest-hal-explorer")
  //    implementation(projects.integration.minio.springBootToolkitMinio)
  implementation("com.h2database:h2")
  implementation(projects.kits.core.springBootToolkitDevservice)
  //    implementation("org.springframework.boot:spring-boot-docker-compose")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.mysql:mysql-connector-j")
  implementation("org.springframework.boot:spring-boot-starter-web")
}
