import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins { `spring-boot-project` }

tasks.withType<BootJar> { enabled = false }

subprojects {
  apply { plugin("java-library") }
  apply<SpringBootProjectPlugin>()
  tasks.withType<BootJar> { enabled = false }
  repositories {
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
  }
  dependencies {
    implementation(rootProject.libs.slf4j)
  }
}
