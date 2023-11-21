group = "org.toolkit.spring.boot.codegen"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("com.squareup:javapoet:1.13.0")
  compileOnly("com.google.auto.service:auto-service:1.1.1")
  compileOnly("net.ltgt.gradle.incap:incap-processor:1.0.0")
  annotationProcessor("com.google.auto.service:auto-service:1.1.1")
  annotationProcessor("com.google.auto.service:auto-common:1.1.1")
  annotationProcessor("net.ltgt.gradle.incap:incap-processor:1.0.0")
  testImplementation("net.ltgt.gradle.incap:incap:1.0.0")
}
