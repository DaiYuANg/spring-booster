group = "org.toolkit.minio"

version = "1.0-SNAPSHOT"

dependencies {
  val minioClientVersion: String by project
  val tikaVersion: String by project
  api("org.apache.tika:tika-core:$tikaVersion")
  api("org.apache.tika:tika-parsers:$tikaVersion")
  api("io.minio:minio:$minioClientVersion")
  testImplementation(libs.testcontainersMinio)
}
