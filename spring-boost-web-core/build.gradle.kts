val aspectjVersion: String by project

dependencies {
  api(libs.aspectjRt)
  api(projects.springBoostCommon)
  api(projects.springBoostWebAnnotation)
  api("org.springframework.boot:spring-boot-starter-web")
  api("org.springframework.hateoas:spring-hateoas")
}
