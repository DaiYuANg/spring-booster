plugins { `spring-boot-project` }

dependencies {
  compileOnly(projects.springBoostMappingCore)
  implementation(libs.bytebuddy)
  testImplementation(projects.springBoostMappingCore)
}
