plugins {
  java
  application
}

val mainClassPath = "org.spring.boost.example.ExampleApplication"

dependencies {
  implementation(projects.booster.springBoostMutiny)

//  implementation(projects.booster.springBoostCaptcha)
  implementation(projects.booster.springBoostCore)
  implementation(libs.springBootLogging)
//  implementation(projects.booster.springBoostAuthentication)
//  implementation(projects.booster.springBoostAuthenticationJwt)
  implementation(libs.springBootSwaggerUI)
  implementation(projects.booster.springBoostJpa)
  implementation(libs.h2Driver)
//  developmentOnly(libs.springBootDevtools)
  implementation(libs.springBootWeb)
  implementation(libs.springBootAdminServer)
  implementation(projects.booster.springBoostRbac)
  implementation(libs.springBootAdminClient)

  implementation(libs.mapstruct)
  annotationProcessor(libs.mapstructAnnotationProcessor)
}
