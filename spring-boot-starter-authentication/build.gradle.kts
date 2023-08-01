val jwtVersion = "4.4.0"

dependencies {
  api("org.springframework.data:spring-data-redis")
  api(projects.modeling.rbac)
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.data:spring-data-jpa")
  api("org.springframework.boot:spring-boot-starter-validation")
  api("org.springframework.boot:spring-boot-starter-thymeleaf")
  //    api(projects.frameworks.spring.springBootStarterEvent)
  compileOnly("org.keycloak:keycloak-spring-boot-starter:21.1.1")
  api("org.springframework.boot:spring-boot-starter-security")
  api("org.springframework.session:spring-session-data-redis")
  compileOnly("org.springframework.security.oauth:spring-security-oauth2:2.5.2.RELEASE")
  api("com.auth0:java-jwt:${jwtVersion}")
}
