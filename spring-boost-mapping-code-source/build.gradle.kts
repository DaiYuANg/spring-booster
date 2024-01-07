plugins { `spring-boot-project` }

dependencies {
  compileOnly(projects.springBoostMappingCore)
  compileOnly(libs.autoFactory)
  annotationProcessor(libs.autoFactory)
  testImplementation(projects.springBoostMappingCore)
}
