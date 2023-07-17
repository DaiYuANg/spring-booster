import org.beryx.jlink.JlinkZipTask

plugins {
    application
    id("org.openjfx.javafxplugin")
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.beryx.jlink") version "2.25.0"
    id ("io.miret.etienne.sass") version "1.5.0"
}

javafx {
    modules(
        "javafx.controls",
        "javafx.fxml",
        "javafx.graphics",
        "javafx.web",
        "javafx.media",
        "javafx.swing"
    )
    version = "20.0.1"
}

dependencies {
    implementation("com.dlsc.formsfx:formsfx-core:11.3.2")
    implementation("io.github.palexdev:materialfx:11.16.1")
    implementation("com.squareup:javapoet:1.13.0")
    implementation("org.fxyz3d:fxyz3d:0.5.4")
    implementation("org.jfxtras:jmetro:11.6.15")
    testImplementation("org.testfx:testfx-core:4.0.16-alpha")
    testImplementation("org.testfx:testfx-junit5:4.0.16-alpha")
    implementation("ch.qos.logback:logback-classic:1.4.8")
}

application {
    mainModule.set("org.toolkit4J.tools.designer")
    mainClass.set("org.toolkit4J.tools.designer.DesignerApplication")
}

jlink {
    imageZip.set(project.file("${buildDir}/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "5", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "app"
    }
}

tasks.withType<JlinkZipTask> {
    group = "distribution"
}
