subprojects {
  val minioClientVersion: String by project
  val testContainerVersion: String by project
  dependencies {
    api("io.minio:minio:$minioClientVersion")
    api("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.testcontainers:minio:1.19.1")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
  }
}
