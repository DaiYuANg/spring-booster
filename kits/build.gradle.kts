plugins { `spring-boot-project` }

tasks { bootJar { enabled = false } }

subprojects {
  apply { plugin("java-library") }
  apply<SpringBootProjectPlugin>()
  //  tasks { bootJar { enabled = false } }

  dependencies {
    val okhttpVersion: String by project

    testImplementation("net.datafaker:datafaker:2.0.2")
    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
  }
}
