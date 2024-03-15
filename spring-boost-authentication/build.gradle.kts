//plugins { `spring-boot-project` }

dependencies {
  compileOnly(libs.springBootSecurity)
  compileOnly(libs.springBootWeb)
  compileOnly(libs.springSecurityData)
  compileOnly(libs.springBootOAuth2AuthorizationServer)
  compileOnly(projects.springBoostCore)
  testImplementation(libs.springBootWeb)
  testImplementation(libs.springSecurityTest)
}
