//plugins { `spring-boot-project` }

val aspectjVersion: String by project

dependencies {
  api(libs.aspectjRt)
  api(projects.springBoostCore)
  api(libs.springBootWeb)
  api("org.springframework.hateoas:spring-hateoas")
  api(libs.apacheCommonIO)
  api(libs.hutoolHttp)
  testImplementation(libs.springBootWeb)
}
