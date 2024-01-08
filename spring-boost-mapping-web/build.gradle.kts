plugins { `spring-boot-project` }

dependencies {
  compileOnly(projects.springBoostMappingCore)
  api(libs.bytebuddy)
  testImplementation(projects.springBoostMappingCore)
}
