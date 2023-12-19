dependencies {
  api("org.springframework.boot:spring-boot-starter-security")
  compileOnly("org.springframework.boot:spring-boot-starter-web")
  api(libs.jsonwebtokenApi)
  api(libs.jsonwebtokenImpl)
  api(libs.jsonwebtokenJackson)
  api("org.springframework.security:spring-security-data")
  api("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
  api(projects.framework.springBoot.springBootUtils)
  testImplementation("org.springframework.boot:spring-boot-starter-web")
  testImplementation("org.springframework.security:spring-security-test")
}
