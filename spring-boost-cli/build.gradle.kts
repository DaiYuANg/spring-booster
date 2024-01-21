import org.springframework.boot.gradle.plugin.SpringBootAotPlugin

plugins {
    application
    alias(libs.plugins.graalvmNative)
    `spring-boot-project`
    `kotlin-support`
}

dependencyManagement { imports { mavenBom("${libs.springShellBom.get()}") } }

repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

version = "1.0"

val mainClassPath = "org.spring.boost.cli.SpringBoostCLI"

dependencies {
    implementation(libs.mysql)
    implementation(libs.javapoet)
    implementation(libs.jakartaPersistence)
    implementation(libs.commonsDBUtil)
    implementation(libs.jansi)
    implementation(libs.jlineNative)
    implementation(libs.springShellStarter)
    implementation(libs.springBootJdbc)
    implementation(libs.sqliteDriver)
    implementation(libs.postgresqlDriver)
    implementation(libs.mavenModel)
    implementation(libs.springBootFreemarker)
    implementation(libs.gradleToolingAPI)
    testImplementation(libs.springBootJdbc)
    testImplementation(libs.mysql)
    developmentOnly(libs.springBootDevtools)
    testImplementation(libs.testcontainersMysql)
    developmentOnly(libs.springBootDockerCompose)
}

application {
    mainClass = mainClassPath
    applicationDefaultJvmArgs = listOf(
        "-XX:+UseZGC",
        "-XX:+ZGenerational",
        "-XX:+AlwaysPreTouch"
    )
}

graalvmNative {
    metadataRepository { enabled = true }
    binaries {
        named("main") {
            mainClass.set(mainClassPath)
            sharedLibrary.set(false)
            quickBuild.set(true)
            buildArgs.add("-H:+UnlockExperimentalVMOptions")
        }
    }
}

task("copyDependencies", Copy::class) {
    from(configurations.runtimeClasspath).into("${layout.buildDirectory}/jars")
}

task("copyJar", Copy::class) { from(tasks.jar).into("${layout.buildDirectory}/jars") }
