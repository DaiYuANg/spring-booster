plugins { `spring-boot-project` }

dependencies {
    implementation(libs.springBootJPA)
    compileOnly(projects.springBoostMappingCore)
    api(projects.springBoostJpa)
    testImplementation(libs.h2Driver)
    testImplementation(libs.springBootJPA)
    testImplementation(projects.springBoostMappingCore)
}
