plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    val springBootVersion:String by project
    implementation("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
}
