plugins {
  java
  application
}

val mainClassPath = "org.spring.boost.example.ExampleApplication"

dependencies {
  implementation(projects.booster.springBoostCaptcha)
  implementation(projects.booster.springBoostCore)
  implementation(projects.booster.springBoostMinio)
  implementation(libs.springBootJPA)
  implementation(libs.h2Driver)
  developmentOnly(libs.springBootDevtools)
}
