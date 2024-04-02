plugins {
  java
  application
}

val mainClassPath = "org.spring.boost.example.ExampleApplication"

dependencies {
//  implementation(projects.booster.springBoostCaptcha)
  implementation(projects.booster.springBoostCore)
  implementation(projects.booster.springBoostMapping)
  implementation(libs.springBootLogging)
//  implementation(projects.booster.springBoostAuthentication)
//  implementation(projects.booster.springBoostAuthenticationJwt)
//  implementation(libs.springBootSecurity)
//  implementation(libs.springBootJPA)
//  implementation(libs.h2Driver)
  developmentOnly(libs.springBootDevtools)
  implementation(libs.springBootWeb)
}
