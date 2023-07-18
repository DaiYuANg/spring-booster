import org.beryx.jlink.JlinkZipTask

plugins {
    application
    id("org.openjfx.javafxplugin")
    id("org.javamodularity.moduleplugin") version "1.8.12"
    id("org.beryx.jlink") version "2.25.0"
    id("io.miret.etienne.sass") version "1.5.0"
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
    configuration = "implementation"
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
    implementation("com.h2database:h2:2.2.220")
    implementation("net.synedra:validatorfx:0.4.2")
    implementation("net.sourceforge.plantuml:plantuml-mit:1.2023.10")
    implementation("org.webjars.npm:fontsource-variable__jetbrains-mono:5.0.6")
//    implementation(projects.libs.io)
//    implementation(projects.libs.helpers)
//    implementation(projects.libs.thready)
    implementation("org.reflections:reflections:0.10.2")
}

application {
    mainModule.set("org.toolkit4J.tools.designer")
    mainClass.set("org.toolkit4J.tools.designer.DesignerApplication")
}

jlink {
    imageZip.set(project.file("${buildDir}/distributions/app-${javafx.platform.classifier}.zip"))
    options.set(listOf("--strip-debug", "--compress", "2", "--no-header-files", "--no-man-pages"))
    launcher {
        name = "designer"
    }
    addExtraDependencies("javafx")
}

tasks {
    withType<JavaCompile> {
    }

    withType<JlinkZipTask> {
        group = "distribution"
    }
}
