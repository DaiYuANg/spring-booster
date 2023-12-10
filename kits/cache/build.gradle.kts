plugins {
    `spring-boot-project` apply false
}
subprojects {
    apply<SpringBootProjectPlugin>()
    dependencies { }
}
