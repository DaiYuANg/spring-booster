dependencies {
  api(libs.spring.boot.starter.security)
  api(libs.spring.boot.starter.web)
  api(libs.spring.security.data)
  compileOnly(projects.libs.springBoostCore)
  testImplementation(libs.spring.security.test)
}
