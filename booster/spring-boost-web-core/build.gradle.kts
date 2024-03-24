dependencies {
  implementation(libs.aspectjRt)
  compileOnly(projects.booster.springBoostCore)
  compileOnly(libs.springBootWeb)
  compileOnly(libs.springBootHateoas)
  implementation(libs.apacheCommonIO)
  implementation(libs.hutoolHttp)
  implementation(libs.useragent)
  testImplementation(libs.springBootWeb)
}
