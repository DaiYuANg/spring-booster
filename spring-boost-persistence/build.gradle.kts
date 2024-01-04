plugins { `spring-boot-project` }

dependencies {
  api(libs.jakartaPersistence)
  api("org.springframework.boot:spring-boot-starter-data-jpa")
  api("org.springframework.data:spring-data-envers")
}
