val oshiVersion = "6.4.4"
val mysqlVersion = "8.0.33"
val okhttpVersion: String by project

dependencies {
    api("org.springframework.boot:spring-boot-starter-thymeleaf")
    api("org.springframework.boot:spring-boot-starter-websocket")
    api(projects.libs.restful)
    api(projects.modeling.persistence)
    api("com.h2database:h2")
    compileOnly("com.mysql:mysql-connector-j:${mysqlVersion}")
    api("com.github.oshi:oshi-core:${oshiVersion}")
    api("org.buildobjects:jproc:2.8.2")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
    api("org.springframework.boot:spring-boot-starter-actuator")
    api("com.squareup.okhttp3:okhttp:${okhttpVersion}")
    api(projects.libs.thready)
    implementation(projects.frameworks.spring.springBootStarterMonitorUi)
}
