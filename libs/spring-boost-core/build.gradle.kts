plugins {
  `java-library`
}

dependencies {
  api(libs.apache.common.lang3)
  api(libs.guava)
  api(libs.apache.common.text)
  api(libs.vavr)
  api(libs.hutool.extra)
  api(libs.mutiny)
  api(libs.eclipse.collections.api)
  api(libs.eclipse.collections)

  annotationProcessor(libs.spring.boot.configuration.processor)
}
