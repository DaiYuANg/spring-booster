plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
    `embedded-kotlin`
}

repositories {
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-gradle-plugin:${libs.versions.springBoot.get()}")
    implementation("io.spring.gradle:dependency-management-plugin:${libs.versions.springDependencyManagement.get()}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.23.3")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${libs.versions.kotlin.get()}")
    implementation("org.jetbrains.kotlin:kotlin-lombok:${libs.versions.kotlin.get()}")
    implementation("org.jetbrains.kotlin:kotlin-serialization:${libs.versions.kotlin.get()}")
    implementation("org.jetbrains.kotlin:kotlin-noarg:${libs.versions.kotlin.get()}")
    implementation("org.jetbrains.kotlin:kotlin-allopen:${libs.versions.kotlin.get()}")
    implementation("com.github.spotbugs.snom:spotbugs-gradle-plugin:6.0.2")
}
