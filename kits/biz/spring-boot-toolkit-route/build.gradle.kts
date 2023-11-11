group = "org.toolkit.spring.boot.menu"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation(projects.kits.core.springBootToolkitPersistence)
}
