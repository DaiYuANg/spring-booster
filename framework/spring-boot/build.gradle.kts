import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins { `spring-boot-project` }

subprojects {
    apply { plugin("java-library") }
    apply<SpringBootProjectPlugin>()
    tasks.withType<BootJar> { enabled = false }
    //    tasks { bootJar { enabled = false } }
    repositories {
        maven { setUrl("https://repo.spring.io/snapshot") }
        maven { setUrl("https://repo.spring.io/milestone") }
    }
    dependencies {
        //    val okhttpVersion: String by project

        //    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
    }
}
