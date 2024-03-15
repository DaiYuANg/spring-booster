import org.springframework.boot.gradle.tasks.bundling.BootJar

apply<KotlinProject>()

dependencies {
  implementation(libs.minio)
  implementation(libs.minioAdmin)
  implementation(libs.tikaCore)
  implementation(libs.tikaParsers)
  implementation(libs.apacheCommonIO)
  implementation(libs.apacheCommonCodeC)
  implementation(libs.okHttp)
  implementation(projects.booster.springBoostCore)
  implementation(libs.fastutil)
  testImplementation(libs.testcontainersMinio)
}

