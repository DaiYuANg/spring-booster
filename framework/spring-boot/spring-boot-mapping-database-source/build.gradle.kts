group = "org.toolkit.spring.boot.mapping.source.database"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.framework.springBoot.springBootMappingCore)
  implementation(projects.framework.springBoot.springBootPersistence)
  testImplementation(libs.testcontainersMysql)
  testImplementation("net.datafaker:datafaker:2.0.2")
  testImplementation("com.mysql:mysql-connector-j")
  testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
