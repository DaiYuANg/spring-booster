val oshiVersion = "6.4.5"
val okhttpVersion: String by project

dependencies {
  api("org.springframework.boot:spring-boot-starter-thymeleaf")
  api("org.springframework.boot:spring-boot-starter-websocket")
  //  api("org.springframework.boot:spring-shell-starter:3.1.3")
  implementation("org.springframework.boot:spring-boot-starter-web")
  api("com.h2database:h2")
  api("com.github.oshi:oshi-core-java11:${oshiVersion}")
  api("org.buildobjects:jproc:2.8.2")
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.boot:spring-boot-starter-actuator")
  api("com.squareup.okhttp3:okhttp:${okhttpVersion}")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.2.0")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-api:2.2.0")
  //  implementation(projects.springBootStarterMonitorUi)
  implementation(projects.springBootStarterPersistence)
  implementation(projects.springBootStarterRestful)
}
