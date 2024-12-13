import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
  idea
  alias(libs.plugins.version.check)
  alias(libs.plugins.dotenv)
  alias(libs.plugins.spotless)
  alias(libs.plugins.semver)
}

idea {
  project {
    jdkName = libs.versions.jdkVersion.get()
    languageLevel = IdeaLanguageLevel(libs.versions.jdkVersion.get())
    vcs = "Git"
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

spotless{
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