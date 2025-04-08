
dependencies {
  implementation(libs.minio)
  implementation(libs.minio.admin)
  implementation(libs.tika.core)
  implementation(libs.tika.parsers)
  implementation(libs.apache.common.io)
  implementation(libs.apache.common.codec)
  implementation(libs.okHttp)
  implementation(projects.libs.springBoostCore)
  implementation(libs.fastutil)
  testImplementation(libs.testcontainers.minio)
}

