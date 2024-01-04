plugins { `spring-boot-project` }

dependencies {
  api(libs.springBootSecurity)
  compileOnly(libs.springBootWeb)
  api(libs.jsonwebtokenApi)
  api(libs.jsonwebtokenImpl)
  api(libs.jsonwebtokenJackson)
  api(libs.springSecurityData)
  api(libs.springBootOAuth2AuthorizationServer)
  api(projects.springBoostCommon)
  testImplementation(libs.springBootWeb)
  testImplementation(libs.springSecurityTest)
}
