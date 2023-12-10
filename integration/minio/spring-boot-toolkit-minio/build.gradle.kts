dependencies {
  val tikaVersion: String by project
  implementation(projects.kits.web.springBootToolkitWebAnnotation)
  implementation(projects.kits.core.springBootToolkitUtils)
  testImplementation("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-web")
  api("org.apache.tika:tika-core:$tikaVersion")
  api("org.apache.tika:tika-parsers:$tikaVersion")
}
