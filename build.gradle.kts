import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
  idea
  alias(libs.plugins.version.check)
  alias(libs.plugins.dotenv)
  alias(libs.plugins.spotless)
  alias(libs.plugins.git)
}

idea {
  project {
    jdkName = libs.versions.jdkVersion.get()
    languageLevel = IdeaLanguageLevel(libs.versions.jdkVersion.get())
    vcs = "Git"
  }
}

subprojects {
  version = "0.1.3"
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
    endWithNewline()
  }
  java {
    target("**/*.java")
    importOrder()
    googleJavaFormat()
    removeUnusedImports("cleanthat-javaparser-unnecessaryimport")
    formatAnnotations()
      .addTypeAnnotation("Empty")
      .addTypeAnnotation("NonEmpty")
      .removeTypeAnnotation("Localized")
    licenseHeader("/* (C)\$YEAR*/")
  }
  kotlinGradle {
    target("**/*.gradle.kts")
    ktfmt()
  }
  kotlin {
    target("**/*.kt")
    ktfmt()
    ktlint()
  }
}