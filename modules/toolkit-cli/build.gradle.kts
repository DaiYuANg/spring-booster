plugins {
    id("org.graalvm.buildtools.native") version "0.9.28"
}
group = "org.toolkit.cli"
version = "1.0-SNAPSHOT"

dependencies {
    implementation("com.squareup:javapoet:1.13.0")
    implementation("info.picocli:picocli:4.7.5")
    implementation("com.google.inject:guice:7.0.0")
    implementation("org.freemarker:freemarker:2.3.32")
    annotationProcessor("info.picocli:picocli-codegen:4.7.5")
    implementation("io.smallrye.config:smallrye-config:3.4.2")
}

graalvmNative {
//    toolchainDetection.set(true)
    binaries {
        named("main") {
            imageName.set("toolkit-cli")
            mainClass.set("org.toolkit.cli.ToolkitCLIApplication")
//            buildArgs.add("-O4")
        }
//        named("test") {
//            buildArgs.add("-O0")
//        }
    }
//    binaries.all {
//        buildArgs.add("--verbose")
//    }
}