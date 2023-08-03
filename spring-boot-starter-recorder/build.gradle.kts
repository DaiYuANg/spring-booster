dependencies {
  api("org.springframework.boot:spring-boot-starter-logging")
  implementation(projects.eventDriven.springBootStarterEvent)
  implementation(projects.springBootStarterPersistence)
}
