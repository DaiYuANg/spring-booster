group = "org.toolkit.spring.boot.mapping.source.enum"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("io.github.classgraph:classgraph:4.8.164")
  implementation(projects.kits.mapping.springBootToolkitMappingCore)
}
