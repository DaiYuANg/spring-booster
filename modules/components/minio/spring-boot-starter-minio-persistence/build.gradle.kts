group = "org.toolkit.spring.boot.starter.minio.persistence"
version = "1.0-SNAPSHOT"

dependencies {
    api(projects.modules.core.springBootStarterPersistence)
    api(projects.modules.springBootStaterUtils)
    api(projects.modules.components.minio.springBootStarterMinioShared)
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
