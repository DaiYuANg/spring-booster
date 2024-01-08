plugins { `spring-boot-project` }

val aspectjVersion: String by project

dependencies {
    api(libs.aspectjRt)
    api(projects.springBoostCore)
    compileOnly(libs.springBootWeb)
    api("org.springframework.hateoas:spring-hateoas")
    api(libs.apacheCommonIO)
    api("cn.hutool:hutool-http:5.8.24")
    testImplementation(libs.springBootWeb)
}
