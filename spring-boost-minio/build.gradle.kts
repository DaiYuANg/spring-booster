plugins { `kotlin-support` }

dependencies {
  api(libs.minio)
  api(libs.minioAdmin)
  api(libs.tikaCore)
  api(libs.tikaParsers)
  api("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
  api("commons-io:commons-io:2.15.1")
  api("commons-codec:commons-codec:1.16.0")
  api("com.squareup.okhttp3:okhttp:5.0.0-alpha.12")
  api(projects.springBoostCommon)
  testImplementation(libs.testcontainersMinio)
}

tasks.bootJar { enabled = false }
