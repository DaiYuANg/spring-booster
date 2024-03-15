//plugins { `spring-boot-project` }

dependencies {
  compileOnly(libs.springBootJPA)
  compileOnly(projects.springBoostMappingCore)
  compileOnly(projects.springBoostJpa)
  testImplementation(libs.h2Driver)
  testImplementation(libs.springBootJPA)
  testImplementation(projects.springBoostMappingCore)
}
