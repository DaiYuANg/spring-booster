subprojects {
    val minioClientVersion:String by project
    dependencies {
        api("io.minio:minio:$minioClientVersion")
        compileOnly("org.springframework.boot:spring-boot-starter-web")
    }
}