import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins { `spring-boot-project` }

subprojects {
  apply { plugin("java-library") }
  apply<SpringBootProjectPlugin>()

  tasks.withType<BootJar> { enabled = false }
  dependencies {
    val okhttpVersion: String by project

    testImplementation("net.datafaker:datafaker:2.0.2")
    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
  }
}
