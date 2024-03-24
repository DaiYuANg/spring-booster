dependencies {
  compileOnly(projects.booster.springBoostMappingCore)
  compileOnly(libs.springBootWeb)
  implementation(libs.bytebuddy)
  implementation(libs.fastutil)
  testImplementation(projects.booster.springBoostMappingCore)
}

