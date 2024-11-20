dependencies {
  api(libs.springBootSecurity)
  api(libs.springBootWeb)
  api(libs.springSecurityData)
  compileOnly(projects.booster.springBoostCore)
  testImplementation(libs.springBootWeb)
  testImplementation(libs.springSecurityTest)
}
