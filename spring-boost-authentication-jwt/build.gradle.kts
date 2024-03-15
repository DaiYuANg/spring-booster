//plugins { `spring-boot-project` }

dependencies {
  implementation(libs.jsonwebtokenApi)
  implementation(libs.jsonwebtokenImpl)
  implementation(libs.jsonwebtokenJackson)
  compileOnly(projects.springBoostAuthentication)
  testImplementation(projects.springBoostAuthentication)
}
