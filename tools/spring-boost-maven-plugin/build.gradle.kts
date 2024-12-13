plugins {
  java
}

group = "org.spring.boost.gradle.plugin"

dependencies {
  implementation(libs.maven.core)
  implementation(libs.maven.plugin.api)
  implementation(libs.maven.plugin.annotations)
}

tasks.test {
    useJUnitPlatform()
}