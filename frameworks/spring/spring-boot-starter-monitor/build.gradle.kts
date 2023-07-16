
val dockerSDKVersion = "3.3.1"
val openapiVersion = "2.0.2"
val oshiVersion = "6.4.4"
val mysqlVersion = "8.0.33"
val okhttpVersion: String by project

dependencies {
	api("com.github.docker-java:docker-java-transport-httpclient5:${dockerSDKVersion}")
	api("com.github.docker-java:docker-java-core:${dockerSDKVersion}")
	api("org.springframework.boot:spring-boot-starter-thymeleaf")
	api("org.springframework.boot:spring-boot-starter-websocket")
	api(project(":frameworks:spring:spring-boot-starter-async"))
	api(project(":standard:restful"))
	api(project(":standard:persistence"))
	api("com.h2database:h2")
	api(project(":frameworks:spring:spring-boot-starter-scheduled"))
	compileOnly("com.mysql:mysql-connector-j:${mysqlVersion}")
	api("org.springdoc:springdoc-openapi-starter-webmvc-ui:${openapiVersion}")
	api("com.github.oshi:oshi-core:${oshiVersion}")
	api("org.buildobjects:jproc:2.8.2")
	api("org.springframework.boot:spring-boot-starter-data-jpa")
	api("org.springframework.boot:spring-boot-starter-actuator")
	api("com.squareup.okhttp3:okhttp:${okhttpVersion}")
	implementation(project(":ui:monitor-ui"))
}
