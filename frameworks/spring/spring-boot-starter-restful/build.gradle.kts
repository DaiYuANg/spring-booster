val aspectjVersion:String by project
dependencies {
    api(projects.standard.restful)
    api(projects.frameworks.spring.springBootStarterAsync)
    implementation("org.aspectj:aspectjrt:${aspectjVersion}")
}
