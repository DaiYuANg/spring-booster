dependencies {
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.data:spring-data-jpa")
    api(project(":frameworks:spring:spring-boot-starter-async"))
    api("org.springframework.boot:spring-boot-starter-cache")
    api(project(":standard:persistence"))
    api(project(":libs:helpers"))
    api(project(":standard:restful"))
    implementation("org.reflections:reflections:0.10.2")

}

