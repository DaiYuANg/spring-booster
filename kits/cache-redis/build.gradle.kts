group = "org.toolkit.spring.boot.cache.redis"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("jakarta.inject:jakarta.inject-api:2.0.1")
  implementation("com.google.auto.factory:auto-factory:1.1.0")
  annotationProcessor("com.google.auto.factory:auto-factory:1.1.0")
  implementation("io.lettuce:lettuce-core:6.3.0.RELEASE")
}
