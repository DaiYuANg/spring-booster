plugins {
  id("org.springframework.boot")
  id("io.spring.dependency-management")
}

tasks { bootJar { enabled = false } }

subprojects {
  apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
  }
}
