plugins { `spring-boot-project` }

val aspectjVersion: String by project

dependencies {
  api(libs.aspectjRt)
  api(projects.springBoostCommon)
  api(projects.springBoostWebAnnotation)
  api(libs.springBootWeb)
  api("org.springframework.hateoas:spring-hateoas")
}
