group = "org.toolkit.spring.boot.starter.auth"

version = "1.0-SNAPSHOT"

dependencies {
  api("org.springframework.boot:spring-boot-starter-security")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  implementation("io.jsonwebtoken:jjwt-api:0.12.3")
  implementation("org.springframework.security:spring-security-data")
  runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.3")
  runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.3")
  implementation(projects.kits.core.springBootToolkitUtils)
  testImplementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.security:spring-security-test")
}
