dependencies {
  implementation(libs.jakartaValidation)
  compileOnly(libs.springBootValidation)
  compileOnly(libs.springBootJdbc)
  compileOnly(projects.booster.springBoostCore)
  implementation(libs.hutoolCore)
  implementation(libs.hutoolExtra)
  implementation(libs.hutoolJSON)
}
