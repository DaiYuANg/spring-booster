dependencies {
  val expiringmapVersion: String by project
  val testContainersVersion: String by project
  api("io.minio:minio:8.5.5")
  implementation("net.jodah:expiringmap:$expiringmapVersion")
  implementation(projects.modules.core.springBootStarterPersistence)
  testImplementation("io.minio:minio:8.5.5")
  implementation("com.github.ben-manes.caffeine:caffeine")
  testImplementation("net.jodah:expiringmap:$expiringmapVersion")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
}
