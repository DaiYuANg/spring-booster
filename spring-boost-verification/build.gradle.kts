plugins { `spring-boot-project` }

dependencies {
  implementation(libs.jakartaValidation)
  api("org.springframework.boot:spring-boot-starter-jdbc")
  api(projects.springBoostCommon)
  api(libs.hutoolCore)
}
