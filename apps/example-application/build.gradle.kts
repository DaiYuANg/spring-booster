plugins{
}

group = "org.toolkit.example.backend.minimal.example"

version = "1.0-SNAPSHOT"

dependencies {
    implementation(projects.kits.web.springBootToolkitAuthentication)
    implementation(projects.kits.core.springBootToolkitPersistence)
    implementation(projects.kits.web.springBootToolkitWebCore)
    implementation(projects.kits.biz.springBootToolkitRoute)
    implementation("me.paulschwarz:spring-dotenv:4.0.0")
    implementation("org.springframework.data:spring-data-rest-hal-explorer")
    implementation(projects.integration.minio.springBootToolkitMinio)
    implementation("net.datafaker:datafaker:2.0.2")
    implementation(projects.kits.core.springBootToolkitDevService)
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.mysql:mysql-connector-j")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation(projects.codegen.springBootToolkitCodegenAnnotation)
    annotationProcessor(projects.codegen.springBootToolkitCodegen)
}

tasks.withType<JavaCompile>{
    doFirst{
        options.annotationProcessorPath?.files?.stream()?.forEach { println(it) }
    }
}