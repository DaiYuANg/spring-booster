tasks { bootJar { enabled = false } }

subprojects {
  apply { plugin("java-library") }

//  tasks { bootJar { enabled = false } }

  dependencies {
    val okhttpVersion: String by project
    api("org.springframework.boot:spring-boot-starter-json")
    api("org.springframework.boot:spring-boot-starter-aop")
    testImplementation("net.datafaker:datafaker:2.0.2")
    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
  }
}
