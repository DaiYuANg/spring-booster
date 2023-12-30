val aspectjVersion: String by project

dependencies {
  implementation(libs.aspectjRt)
  api("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.hateoas:spring-hateoas")
}
