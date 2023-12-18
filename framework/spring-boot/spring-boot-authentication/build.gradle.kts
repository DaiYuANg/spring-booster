group = "org.toolkit.spring.boot.starter.auth"

version = "1.0-SNAPSHOT"

dependencies {
  api("org.springframework.boot:spring-boot-starter-security")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  api("io.jsonwebtoken:jjwt-api:0.12.3")
  api("org.springframework.security:spring-security-data")
  api("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
  api("io.jsonwebtoken:jjwt-impl:0.12.3")
  api("io.jsonwebtoken:jjwt-jackson:0.12.3")
  api(projects.framework.springBoot.springBootUtils)
  testImplementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.security:spring-security-test")
}
