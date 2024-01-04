plugins { `spring-boot-project` }

dependencies {
  implementation(libs.springBootJPA)
  //  implementation(projects.framework.springBoot.springBootMappingCore)
  //  implementation(projects.framework.springBoot.springBootPersistence)
  testImplementation(libs.testcontainersMysql)
  testImplementation(libs.mysql)
  testImplementation(libs.springBootJPA)
}
