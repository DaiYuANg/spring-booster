val aspectjVersion: String by project

dependencies {
  implementation(libs.aspectjRt)
  compileOnly(projects.booster.springBoostCore)
  compileOnly(libs.springBootWeb)
  compileOnly(libs.springBootHateoas)
  implementation(libs.apacheCommonIO)
  implementation(libs.hutoolHttp)
  testImplementation(libs.springBootWeb)
}
