plugins { `spring-boot-project` }

dependencies {
  compileOnly(libs.springBootWeb)
  api(libs.apachePoi)
  api(libs.apachePoiOOxmlFull)
  api(libs.apachePoiOOxml)
}
