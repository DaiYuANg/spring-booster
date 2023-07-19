tasks.jar {
    enabled = false
}

tasks.publish {
    enabled = false
}

subprojects {
    dependencies {
        api("jakarta.annotation:jakarta.annotation-api:2.1.1")
    }
}