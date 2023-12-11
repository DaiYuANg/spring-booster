import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins { `spring-boot-project` }

subprojects {
  apply { plugin("java-library") }
  apply<SpringBootProjectPlugin>()
  tasks.withType<BootJar> { enabled = false }
  //    tasks { bootJar { enabled = false } }

  dependencies {
    //    val okhttpVersion: String by project

    //    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
  }
}
