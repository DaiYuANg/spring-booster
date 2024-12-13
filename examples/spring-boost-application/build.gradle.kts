plugins {
  java
  application
}

val mainClassPath = "org.spring.boost.example.ExampleApplication"

apply<SpringBootProject>()

dependencies {
  implementation(enforcedPlatform(projects.bom.springBoostBom))
  implementation(projects.libs.springBoostMutiny)

  implementation(projects.libs.springBoostCaptcha)
  implementation(projects.libs.springBoostCore)
  implementation(libs.spring.boot.starter.logging)
  implementation(projects.libs.springBoostAuthentication)
  implementation(projects.libs.springBoostAuthenticationJwt)
  implementation(projects.libs.springBoostRbac)

  implementation(projects.libs.springBoostJpa)
  implementation(libs.h2)
  compileOnly(libs.spring.boot.devtools)
  implementation(libs.spring.boot.starter.web)
  implementation(libs.spring.boot.admin.starter.server)
  implementation(libs.spring.boot.admin.starter.client)

  implementation(libs.mapstruct)
  annotationProcessor(libs.mapstruct.annotation.processor)

  compileOnly(libs.record.builder.core)
  annotationProcessor(libs.record.builder.processor)
}
