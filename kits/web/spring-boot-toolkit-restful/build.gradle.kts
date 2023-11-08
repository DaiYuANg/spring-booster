val aspectjVersion: String by project

dependencies {
  implementation("jakarta.validation:jakarta.validation-api:3.0.2")
  implementation("org.aspectj:aspectjrt:${aspectjVersion}")
  api("org.springframework.boot:spring-boot-starter-web")
//  api(projects.modules.core.springBootStarterI18n)
}
