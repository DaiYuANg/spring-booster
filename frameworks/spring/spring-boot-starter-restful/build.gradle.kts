val aspectjVersion:String by project
dependencies {
    api(projects.libs.restful)
    api(projects.libs.helpers)
    implementation("jakarta.validation:jakarta.validation-api:3.0.2")
    implementation("org.aspectj:aspectjrt:${aspectjVersion}")
}
