plugins { `spring-boot-project` }

dependencies {
  implementation(projects.springBoostMappingCore)
  compileOnly(libs.autoFactory)
  annotationProcessor(libs.autoFactory)
}
