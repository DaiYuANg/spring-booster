plugins {
    id("org.graalvm.buildtools.native") version "0.9.28"
}
group = "org.toolkit.cli"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("com.squareup:javapoet:1.13.0")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.google.inject:guice:7.0.0")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")
}
