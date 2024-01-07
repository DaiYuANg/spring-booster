plugins { `spring-boot-project` }

val aspectjVersion: String by project

dependencies {
    api(libs.aspectjRt)
    api(projects.springBoostCore)
    compileOnly(libs.springBootWeb)
    implementation("com.github.ua-parser:uap-java:1.6.1")
    api("org.springframework.hateoas:spring-hateoas")
    testImplementation(libs.springBootWeb)
}
