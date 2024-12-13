plugins {
  `java-library`
}

group = "org.spring.boost.codegen"

dependencies {
  implementation(platform(rootProject.projects.bom.springBoostBom))
  implementation(projects.tools.springBoostAnnotation)
  implementation(libs.javapoet)
  implementation(libs.javaparser.core)
  compileOnly(libs.prisms)
  annotationProcessor(libs.prisms)
//  compileOnly(libs.auto.service.annotations)
//  annotationProcessor(libs.auto.service)
}

tasks.test {
  useJUnitPlatform()
}