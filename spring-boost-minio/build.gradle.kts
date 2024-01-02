dependencies {
  api(libs.minio)
  api(libs.minioAdmin)
  api(libs.tikaCore)
  api(libs.tikaParsers)
  api("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
  api("commons-io:commons-io:2.15.1")
  testImplementation(libs.testcontainersMinio)
}
