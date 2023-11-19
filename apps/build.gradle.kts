plugins { `spring-boot-project` }

tasks { bootJar { enabled = false } }

subprojects { apply<SpringBootProjectPlugin>() }
