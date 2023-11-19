plugins{
    id("com.diffplug.spotless")
    jacoco
    checkstyle
    id("com.github.spotbugs-base")
}

spotless {
    format("misc") {
        target("*.md", ".gitignore", "**/*.java")
        indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
        endWithNewline()
    }
    java {
        target("**/*.java")
        importOrder()
        palantirJavaFormat()
        indentWithTabs()
        removeUnusedImports()
        formatAnnotations()
    }

    kotlinGradle {
        target("**/*.gradle.kts") // default target for kotlinGradle
        ktfmt() // or ktfmt() or prettier()
    }
    kotlin {
        // by default the target is every '.kt' and '.kts` file in the java sourcesets
        ktfmt()    // has its own section below
        ktlint()   // has its own section below
//        diktat()   // has its own section below
//        prettier() // has its own section below

//        licenseHeader("/* (C)$YEAR */")
//        licenseHeader.set("/* (C)$YEAR */") // or licenseHeaderFile
    }
}

tasks.withType<Checkstyle>().configureEach {
    minHeapSize = "2048m"
    maxHeapSize = "4g"
}

tasks.withType<JacocoReport>{
    reports{
        xml.required = false
        csv.required = false
        html.outputLocation = layout.buildDirectory.dir("jacocoHtml")
    }
}