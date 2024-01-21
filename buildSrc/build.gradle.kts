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
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
    implementation(libs.springBootGradlePlugin)
    implementation(libs.springBootDependencyManagementPlugin)
    implementation(libs.spotlessPlugin)
    implementation(libs.kotlinGradlePlugin)
    implementation(libs.kotlinGradleLombokPlugin)
    implementation(libs.kotlinGradleSerializationPlugin)
    implementation(libs.kotlinGradleNoArgPlugin)
    implementation(libs.kotlinGradleAllOpenPlugin)
    implementation(libs.kotlinGradleSpringPlugin)
    implementation(libs.spotbugs)
}
