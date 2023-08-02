val jwtVersion = "4.4.0"

dependencies {
  val expiringmapVersion: String by project

  api("org.springframework.boot:spring-boot-starter-validation")
  api("org.springframework.boot:spring-boot-starter-thymeleaf")
  compileOnly("org.keycloak:keycloak-spring-boot-starter:21.1.1")
  api("org.springframework.boot:spring-boot-starter-security")
  implementation("net.jodah:expiringmap:$expiringmapVersion")
  api(projects.springBootStarterPersistence)
  api(projects.eventDriven.springBootStarterEvent)
  compileOnly("org.springframework.security.oauth:spring-security-oauth2:2.5.2.RELEASE")
  api("com.auth0:java-jwt:${jwtVersion}")
}
