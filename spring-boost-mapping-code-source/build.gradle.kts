plugins { `spring-boot-project` }

dependencies {
  compileOnly(projects.springBoostMappingCore)
  compileOnly(libs.autoFactory)
  compileOnly(projects.springBoostCore)
  annotationProcessor(libs.autoFactory)
  testImplementation(projects.springBoostMappingCore)
}
