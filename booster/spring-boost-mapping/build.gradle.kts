dependencies {
  implementation(libs.springBootJSON)
  implementation(libs.fastutil)
  compileOnly(libs.springBootJSON)
  compileOnly(projects.booster.springBoostCore)
  implementation(libs.bytebuddy)
  compileOnly(libs.autoServiceAnnotations)
  annotationProcessor(libs.autoService)
  implementation(libs.guava)
}
