dependencies {
  api(libs.jsonwebtoken.api)
  api(libs.jsonwebtoken.impl)
  api(libs.jsonwebtoken.jackson)
  compileOnly(libs.spring.boot.starter.security)
  compileOnly(projects.libs.springBoostAuthentication)
  compileOnly(libs.spring.boot.starter.web)
  compileOnly(projects.libs.springBoostCore)
  testImplementation(projects.libs.springBoostAuthentication)
}
