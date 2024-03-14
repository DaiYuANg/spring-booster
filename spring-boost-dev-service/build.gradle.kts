plugins { `spring-boot-project` }

dependencies {
  implementation(libs.progressbar)
  implementation(libs.javaDockerClientCore)
  implementation(libs.javaDockerClientHttpClient)
  implementation(libs.apacheHttpClient)
  testImplementation(libs.mysqlDriver)
}
