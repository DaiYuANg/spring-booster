plugins {
  `java-library`
}

group = "org.spring.boost.codegen"

dependencies {
  implementation(platform(projects.libs.springBoostBom))
  implementation(projects.libs.springBoostAnnotation)
  implementation(libs.javapoet)
  implementation(libs.javaparser.core)
  compileOnly(libs.prisms)
  annotationProcessor(libs.prisms)
}

tasks.test {
  useJUnitPlatform()
}