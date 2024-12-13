plugins {
  `java-library`
}

dependencies {
  api(libs.apache.common.lang3)
  api(libs.guava)
//  implementation(libs.slf4jJulBridge)
  api(libs.vavr)
  api(libs.hutool.extra)
  api(libs.mutiny)
  api(libs.classgraph)

  annotationProcessor(libs.spring.boot.configuration.processor)
}
