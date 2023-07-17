dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.data:spring-data-jpa")
    api(projects.frameworks.spring.springBootStarterAsync)
    api("org.springframework.boot:spring-boot-starter-cache")
    api(projects.standard.persistence)
    api(projects.libs.helpers)
    api(projects.standard.restful)
    implementation("org.reflections:reflections:0.10.2")

}

