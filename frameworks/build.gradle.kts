tasks.jar {
	enabled = false
}

tasks.publish {
	enabled = false
}


subprojects {
	dependencies{
		val restAssuredVersion: String by project
		val assertjVersion: String by project
		val mockitoVersion: String by project
		testImplementation("org.testcontainers:postgresql")
		testImplementation("org.testcontainers:mysql")
		testImplementation("org.testcontainers:rabbitmq")
		testImplementation("org.testcontainers:elasticsearch")
		testImplementation("org.testcontainers:mssqlserver")
		testImplementation("org.testcontainers:mockserver")
		testImplementation("org.testcontainers:selenium")
		testImplementation("com.github.dasniko:testcontainers-keycloak:2.5.0")
		testImplementation("com.redis.testcontainers:testcontainers-redis-junit:1.6.4")
		testImplementation("org.seleniumhq.selenium:selenium-remote-driver:3.141.59")
		testImplementation("net.datafaker:datafaker:2.0.1")
		testImplementation("io.rest-assured:rest-assured:${restAssuredVersion}")
		testImplementation("org.assertj:assertj-core:${assertjVersion}")
		testImplementation("org.mockito:mockito-core:${mockitoVersion}")
	}
}