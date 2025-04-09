plugins {
  java
  application
}

group = "org.spring.boost.sample.rbac"

apply<SpringBootProject>()
dependencies {
  implementation(projects.libs.springBoostCore)
  implementation(projects.libs.springBoostAuthentication)
  implementation(projects.libs.springBoostAuthenticationJwt)
  implementation(projects.libs.springBoostRbac)
  implementation(projects.libs.springBoostWeb)
  implementation(libs.h2)
}
