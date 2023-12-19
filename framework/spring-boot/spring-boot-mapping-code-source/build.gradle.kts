group = "org.toolkit.spring.boot.mapping.source.enum"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.framework.springBoot.springBootScanner)
  implementation(projects.framework.springBoot.springBootMappingCore)
  compileOnly(libs.autoFactory)
  annotationProcessor(libs.autoFactory)
  //  api(projects.kits.mapping.springBootMappingBase)
}
