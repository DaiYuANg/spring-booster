plugins { `spring-boot-project` }

dependencies {
  api(libs.jsonwebtokenApi)
  api(libs.jsonwebtokenImpl)
  api(libs.jsonwebtokenJackson)
  compileOnly(projects.springBoostAuthentication)
  testImplementation(projects.springBoostAuthentication)
}
