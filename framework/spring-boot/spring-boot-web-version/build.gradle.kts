group = "org.toolkit.spring.boot.web.version"

version = "1.0-SNAPSHOT"

dependencies {
  //  implementation(projects.kits.web.springBootToolkitWebAnnotation)
  api("org.springframework.boot:spring-boot-starter-web")
  implementation("org.semver4j:semver4j:5.2.2")
}
