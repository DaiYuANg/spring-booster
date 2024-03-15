plugins {
//  `spring-boot-project`
  java
  application
}

val mainClassPath = "org.spring.boost.example.ExampleApplication"

dependencies {
  implementation(projects.springBoostCore)
  implementation(projects.springBoostWebCore)
  implementation(libs.springBootJPA)
  implementation(libs.h2Driver)
//  developmentOnly(libs.springBootDevtools)
}
