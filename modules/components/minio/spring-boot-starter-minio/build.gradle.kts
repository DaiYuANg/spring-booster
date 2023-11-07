dependencies {
    api(projects.modules.core.springBootStarterRestful)
    api(projects.modules.springBootStaterUtils)
    api("org.apache.tika:tika-core:2.9.1")
    api("org.apache.tika:tika-parsers:2.9.1")
    api(projects.modules.springBootStaterUtils)
    api(projects.modules.components.minio.springBootStarterMinioShared)
    testImplementation("io.minio:minio:8.5.6")
    testImplementation("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
}
