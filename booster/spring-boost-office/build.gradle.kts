dependencies {
  compileOnly(libs.springBootWeb)
  implementation(libs.apachePoi)
  implementation(libs.apachePoiOOxmlFull)
  implementation(libs.apachePoiOOxml)
  implementation(libs.classGraph)
  testImplementation(libs.springBootWeb)
  implementation(libs.apacheCommonPool)
  compileOnly(projects.booster.springBoostCore)
}
