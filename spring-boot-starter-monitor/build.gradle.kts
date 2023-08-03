val oshiVersion = "6.4.4"
val okhttpVersion: String by project

dependencies {
  api("org.springframework.boot:spring-boot-starter-thymeleaf")
  api("org.springframework.boot:spring-boot-starter-websocket")
  implementation("org.springframework.boot:spring-boot-starter-web")
  api("com.h2database:h2")
  api("com.github.oshi:oshi-core:${oshiVersion}")
  api("org.buildobjects:jproc:2.8.2")
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.boot:spring-boot-starter-actuator")
  api("com.squareup.okhttp3:okhttp:${okhttpVersion}")
//  implementation(projects.springBootStarterMonitorUi)
  implementation(projects.springBootStarterPersistence)
  implementation(projects.springBootStarterRestful)
}
