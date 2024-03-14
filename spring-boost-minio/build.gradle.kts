plugins {
  `kotlin-support`
  `spring-boot-project`
}

dependencies {
  api(libs.minio)
  api(libs.minioAdmin)
  implementation(libs.tikaCore)
  implementation(libs.tikaParsers)
  implementation(libs.apacheCommonIO)
  implementation(libs.apacheCommonCodeC)
  implementation(libs.okHttp)
  implementation(projects.springBoostCore)
  testImplementation(libs.testcontainersMinio)
}
