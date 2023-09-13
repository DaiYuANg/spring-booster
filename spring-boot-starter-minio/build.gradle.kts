dependencies {
  val expiringmapVersion: String by project
  val testContainersVersion: String by project
  api("io.minio:minio:8.5.5")
  implementation("net.jodah:expiringmap:$expiringmapVersion")
  testImplementation("io.minio:minio:8.5.5")
  testImplementation("net.jodah:expiringmap:$expiringmapVersion")
  // https://mvnrepository.com/artifact/jakarta.servlet/jakarta.servlet-api
  compileOnly("jakarta.servlet:jakarta.servlet-api:6.0.0")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
}
