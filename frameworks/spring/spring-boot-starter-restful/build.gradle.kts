val aspectjVersion:String by project
dependencies {
    api(projects.standard.restful)
    api(projects.libs.helpers)
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    api(projects.frameworks.spring.springBootStarterAsync)
    implementation("org.aspectj:aspectjrt:${aspectjVersion}")
}
