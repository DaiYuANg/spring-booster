plugins { `spring-boot-project` }

dependencies {
  //  implementation(projects.kits.core.springBootToolkitUtils)
  compileOnly(libs.springBootWeb)
  //  implementation(projects.framework.springBoot.springBootScanner)
  //  implementation(projects.kits.core.springBootToolkitScanner)
  //  api(projects.framework.springBoot.springBootMappingBase)
}
