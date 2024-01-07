plugins { `spring-boot-project` }

dependencies {
  compileOnly(libs.springBootWeb)
  testImplementation(libs.springBootWeb)
}
