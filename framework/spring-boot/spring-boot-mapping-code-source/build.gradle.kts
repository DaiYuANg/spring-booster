group = "org.toolkit.spring.boot.mapping.source.enum"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.framework.springBoot.springBootScanner)
  //  implementation(projects.kits.core.springBootToolkitScanner)
  implementation(projects.framework.springBoot.springBootMappingCore)
  //  implementation(projects.kits.mapping.springBootToolkitMappingCore)
  annotationProcessor("com.google.auto.service:auto-service:1.1.1")
  //  api(projects.kits.mapping.springBootMappingBase)
}
