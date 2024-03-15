import org.springframework.boot.gradle.tasks.bundling.BootJar

dependencies {
  implementation(libs.jsonwebtokenApi)
  implementation(libs.jsonwebtokenImpl)
  implementation(libs.jsonwebtokenJackson)
  compileOnly(libs.springBootSecurity)
  compileOnly(projects.booster.springBoostAuthentication)
  compileOnly(libs.springBootWeb)
  compileOnly(projects.booster.springBoostCore)
  testImplementation(projects.booster.springBoostAuthentication)
}
