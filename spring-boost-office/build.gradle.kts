plugins { `spring-boot-project` }

dependencies {
  compileOnly(libs.springBootWeb)
  api(libs.apachePoi)
  api(libs.apachePoiOOxmlFull)
  api(libs.apachePoiOOxml)
  testImplementation(libs.springBootWeb)
  api(libs.apacheCommonPool)
  api(projects.springBoostCore)
}
