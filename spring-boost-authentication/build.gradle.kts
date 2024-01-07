plugins { `spring-boot-project` }

dependencies {
  api(libs.springBootSecurity)
  compileOnly(libs.springBootWeb)
  api(libs.springSecurityData)
  api(libs.springBootOAuth2AuthorizationServer)
  api(projects.springBoostCore)
  testImplementation(libs.springBootWeb)
  testImplementation(libs.springSecurityTest)
}
