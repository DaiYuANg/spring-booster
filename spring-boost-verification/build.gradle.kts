//plugins { `spring-boot-project` }

dependencies {
  implementation(libs.jakartaValidation)
  api(libs.springBootValidation)
  api(libs.springBootJdbc)
  api(projects.springBoostCore)
  api(libs.hutoolCore)
  api(libs.hutoolExtra)
  api(libs.hutoolJSON)
}
