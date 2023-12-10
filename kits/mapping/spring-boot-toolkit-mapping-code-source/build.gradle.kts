group = "org.toolkit.spring.boot.mapping.source.enum"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.kits.core.springBootToolkitScanner)
  implementation(projects.kits.mapping.springBootToolkitMappingCore)
  annotationProcessor("com.google.auto.service:auto-service:1.1.1")
  api(projects.kits.mapping.springBootMappingBase)
}
