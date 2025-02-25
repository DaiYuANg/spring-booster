import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTaskPartial

plugins {
  idea
  alias(libs.plugins.version.check)
  alias(libs.plugins.dotenv)
  alias(libs.plugins.spotless)
  alias(libs.plugins.semver)
  alias(libs.plugins.dokka)
}

idea {
  project {
    jdkName = libs.versions.jdkVersion.get()
    languageLevel = IdeaLanguageLevel(libs.versions.jdkVersion.get())
    vcs = "Git"
  }
}

subprojects {
  apply(plugin = "org.jetbrains.dokka")
  tasks.dokkaHtml {
    outputDirectory.set(layout.buildDirectory.dir("docs/partial"))
  }

  // configure all format tasks at once
  tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets.configureEach {
      includes.from("README.md")
    }
  }
}

allprojects {
  repositories {
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }
}

true.also { gradle.startParameter.isBuildCacheEnabled = it }

spotless {
  format("misc") {
    target("*.md", ".gitignore", "**/*.java")
    indentWithSpaces(2)
    endWithNewline()
  }
  java {
    target("**/*.java")
    importOrder()
    googleJavaFormat()
    indentWithSpaces(2)
    removeUnusedImports("cleanthat-javaparser-unnecessaryimport")
    formatAnnotations()
      .addTypeAnnotation("Empty")
      .addTypeAnnotation("NonEmpty")
      .removeTypeAnnotation("Localized")
    licenseHeader("/* (C)\$YEAR*/")
  }
  kotlinGradle {
    target("**/*.gradle.kts") // default target for kotlinGradle
    ktfmt() // or ktfmt() or prettier()
    indentWithSpaces(2)
  }
  kotlin {
    target("**/*.kt")
    ktfmt()
    ktlint()
    indentWithSpaces(2)
  }
}