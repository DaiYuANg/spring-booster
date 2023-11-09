dependencies {
  api("org.apache.tika:tika-core:2.9.1")
  api("org.apache.tika:tika-parsers:2.9.1")
  implementation(projects.kits.minio.springBootToolkitMinioCore)
  implementation(projects.kits.web.springBootToolkitWebAnnotation)
  implementation(projects.kits.core.springBootToolkitUtils)
  testImplementation("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-web")
}
