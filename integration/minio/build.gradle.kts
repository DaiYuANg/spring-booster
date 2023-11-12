subprojects {
  val minioClientVersion: String by project
  val testContainerVersion: String by project
  dependencies {
    api("io.minio:minio:$minioClientVersion")
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.testcontainers:minio:1.19.1")
  }
}
