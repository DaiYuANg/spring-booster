dependencies {
//  implementation(libs.aspectjRt)
  compileOnly(projects.libs.springBoostCore)
  api(libs.spring.boot.starter.web)
  api(libs.spring.hateoas)
  api(libs.apache.common.io)
  api(libs.hutool.http)
  api(libs.useragent)
  implementation(libs.springdoc.openapi.starter.webmvc.ui)
  testImplementation(libs.spring.boot.starter.web)
}
