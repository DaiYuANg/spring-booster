dependencies {
  val expiringmapVersion: String by project
  val testContainersVersion: String by project
  api("io.minio:minio:8.5.4")
  implementation("net.jodah:expiringmap:$expiringmapVersion")
  testImplementation("io.minio:minio:8.5.4")
  testImplementation("net.jodah:expiringmap:$expiringmapVersion")
}
