dependencies {
  implementation(projects.kits.minioWrapper)
  implementation(projects.framework.springBoot.springBootUtils)
  testImplementation("com.h2database:h2")
  testImplementation("org.springframework.boot:spring-boot-starter-web")
}
