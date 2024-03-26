dependencies {
  implementation(libs.springBootJSON)
  implementation(libs.fastutil)
  compileOnly(libs.springBootJSON)
  compileOnly(projects.booster.springBoostCore)
  implementation(libs.bytebuddy)
  testImplementation(projects.booster.springBoostMappingCore)
}
