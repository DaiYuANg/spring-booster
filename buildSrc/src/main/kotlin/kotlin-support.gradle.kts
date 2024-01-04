import org.gradle.kotlin.dsl.kotlin

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.lombok")
    kotlin("plugin.allopen")
    kotlin("kapt")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(jdkVersion = 21)
    compilerOptions {
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }
}

kapt {
    keepJavacAnnotationProcessors = true
}


