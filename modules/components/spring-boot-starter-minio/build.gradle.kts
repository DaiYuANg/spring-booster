dependencies {
    val expiringmapVersion: String by project
    val testContainersVersion: String by project
    api("io.minio:minio:8.5.6")
    implementation(projects.modules.core.springBootStarterPersistence)
    implementation(projects.modules.core.springBootStarterRestful)
    api("org.apache.tika:tika-core:2.9.1")
    api("org.apache.tika:tika-parsers:2.9.1")
    testImplementation("io.minio:minio:8.5.6")
    testImplementation("com.h2database:h2")
    compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
    compileOnly("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
