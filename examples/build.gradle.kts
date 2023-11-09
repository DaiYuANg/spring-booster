plugins {
  id("org.springframework.boot")
  id("io.spring.dependency-management")
}

subprojects {
  apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
  }
}
