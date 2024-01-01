group = "org.toolkit.spring.boot.mapping.source.enum"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.springBoostMappingCore)
  compileOnly(libs.autoFactory)
  annotationProcessor(libs.autoFactory)
}
