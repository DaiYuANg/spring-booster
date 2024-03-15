dependencies {
  compileOnly(projects.booster.springBoostMappingCore)
  compileOnly(libs.autoFactory)
  compileOnly(projects.booster.springBoostCore)
  annotationProcessor(libs.autoFactory)
  implementation(libs.fastutil)
  implementation(libs.classGraph)
  testImplementation(projects.booster.springBoostMappingCore)
}
