dependencies {
	api(project(":frameworks:spring:spring-boot-starter-async"))
	api(project(":frameworks:spring:spring-boot-starter-scheduled"))
	api(project(":libs:constant"))
	implementation("org.ehcache:ehcache:3.10.8")
}
