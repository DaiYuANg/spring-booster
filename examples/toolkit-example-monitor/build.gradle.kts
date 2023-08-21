group = "org.toolkit.example.monitor"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation(projects.springBootStarterRestful)
  implementation(projects.springBootStarterMonitor)
}
