group = "org.toolkit.spring.boot.starter.minio.persistence"
version = "1.0-SNAPSHOT"

dependencies {
    api(projects.modules.core.springBootStarterPersistence)
    api(projects.modules.springBootStaterUtils)
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api(projects.modules.components.springBootStarterMinio)
    testImplementation("org.springframework.boot:spring-boot-starter-data-jpa")
}
