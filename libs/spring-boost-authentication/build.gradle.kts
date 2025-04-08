dependencies {
  api(libs.spring.boot.starter.security)
  api(libs.spring.boot.starter.web)
  api(libs.spring.security.data)
  compileOnly(projects.libs.springBoostCore)
//  compileOnly(libs.spring.boot.admin.starter.server)
  compileOnly(libs.springdoc.openapi.starter.webmvc.ui)
  testImplementation(libs.spring.security.test)
}

