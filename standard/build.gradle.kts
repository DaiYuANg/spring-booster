tasks.jar {
    enabled = false
}

tasks.publish {
    enabled = false
}
subprojects {
    dependencies {
        implementation("jakarta.annotation:jakarta.annotation-api:2.1.1")
    }
}