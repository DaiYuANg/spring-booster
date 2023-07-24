dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.data:spring-data-jpa")
//    api(projects.frameworks.spring.springBootStarterAsync)
    api("org.springframework.boot:spring-boot-starter-cache")
    api(projects.modeling.persistence)
    api(projects.libs.helpers)
    api(projects.libs.restful)
    api(projects.libs.thready)
    implementation("org.reflections:reflections:0.10.2")
}

