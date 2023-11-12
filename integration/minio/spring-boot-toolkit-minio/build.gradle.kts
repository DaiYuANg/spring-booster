dependencies {
  implementation(projects.integration.minio.springBootToolkitMinioCore)
  implementation(projects.kits.web.springBootToolkitWebAnnotation)
  implementation(projects.kits.core.springBootToolkitUtils)
  testImplementation("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-web")
}
