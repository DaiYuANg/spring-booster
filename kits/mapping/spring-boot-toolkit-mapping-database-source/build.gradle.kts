group = "org.toolkit.spring.boot.mapping.source.database"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.kits.mapping.springBootToolkitMappingCore)
  implementation(projects.kits.core.springBootToolkitUtils)
  api("org.springframework.boot:spring-boot-starter-data-jdbc")
}