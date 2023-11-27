group = "org.toolkit.spring.boot.mapping.source.database"

version = "1.0-SNAPSHOT"

dependencies {
  val testContainersVersion: String by project
  implementation(projects.kits.mapping.springBootToolkitMappingCore)
  implementation(projects.kits.core.springBootToolkitUtils)
  implementation(projects.kits.core.springBootToolkitPersistence)
  testImplementation("org.testcontainers:mysql:$testContainersVersion")
  testImplementation("net.datafaker:datafaker:2.0.2")
  testImplementation("com.mysql:mysql-connector-j")
  testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
