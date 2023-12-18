group = "org.toolkit.spring.boot.menu"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-validation")
  implementation("org.springframework.boot:spring-boot-starter-data-rest")
  implementation(projects.framework.springBoot.springBootPersistence)
  implementation(projects.framework.springBoot.springBootWebAnnotation)
}
