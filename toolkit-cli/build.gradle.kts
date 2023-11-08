plugins {
    application
}
group = "org.toolkit.cli"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("ch.qos.logback:logback-core:1.4.11")
    implementation("ch.qos.logback:logback-classic:1.4.11")
    implementation("com.squareup:javapoet:1.13.0")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.google.inject:guice:7.0.0")
    implementation("org.freemarker:freemarker:2.3.32")
    implementation("com.squareup:javapoet:1.13.0")
    implementation("org.fusesource.jansi:jansi:2.4.1")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")
}

run {
}

tasks{
    compileJava{
        options.compilerArgs.add("-Aproject=${project.group}/${project.name}")
    }
    jar{
        manifest{
            attributes["Main-Class"] = "org.toolkit.cli.ToolkitCLIApplication"
            manifest.attributes["Class-Path"] = configurations
                .runtimeClasspath
                .get()
                .joinToString(separator = " ") { file ->
                    "libs/${file.name}"
                }
        }
    }
}

application{
    mainModule="org.toolkit.cli"
    mainClass="org.toolkit.cli.ToolkitCLIApplication"
    applicationDefaultJvmArgs = listOf("-Dsmallrye.config.locations=test.yaml")
}
