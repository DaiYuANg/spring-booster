plugins {
  `kotlin-support`
  `spring-boot-project`
}

dependencies {
  api(libs.minio)
  api(libs.minioAdmin)
  api(libs.tikaCore)
  api(libs.tikaParsers)
  api(libs.apacheCommonIO)
  api(libs.apacheCommonCodeC)
  api(libs.okHttp)
  api(projects.springBoostCore)
  testImplementation(libs.testcontainersMinio)
}
