plugins {
  `spring-boot-project`
  `kotlin-support`
}

group = "org.toolkit.spring.boot.devservice"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("com.github.docker-java:docker-java:3.3.4")
  implementation("com.github.docker-java:docker-java-transport-httpclient5:3.3.4")
  implementation("org.apache.httpcomponents.client5:httpclient5:5.2.1")
}
