plugins { `spring-boot-project` }

dependencies {
  compileOnly(libs.springBootWeb)
  implementation(libs.semver4j)
  testImplementation(libs.springBootWeb)
}
