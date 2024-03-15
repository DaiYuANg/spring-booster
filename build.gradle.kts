import org.gradle.plugins.ide.idea.model.IdeaLanguageLevel

plugins {
  idea
  alias(libs.plugins.versionCheck)
  alias(libs.plugins.dotenv)
}

apply<RootProjectSetting>()
apply<FormatterPlugin>()

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
