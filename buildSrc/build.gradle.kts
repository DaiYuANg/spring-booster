plugins {
  `kotlin-dsl`
}

repositories {
  mavenLocal()
  mavenCentral()
  gradlePluginPortal()
  google()
}

dependencies {
  implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
  implementation(libs.springBootGradlePlugin)
  implementation(libs.springBootDependencyManagementPlugin)
  implementation(libs.spotlessPlugin)
  implementation(libs.kotlinGradlePlugin)
  implementation(libs.kotlinGradleLombokPlugin)
  implementation(libs.kotlinGradleSerializationPlugin)
  implementation(libs.kotlinGradleNoArgPlugin)
  implementation(libs.kotlinGradleAllOpenPlugin)
  implementation(libs.kotlinGradleSpringPlugin)
  implementation(libs.manifestPlugin)
  implementation(libs.jmhPlugin)
  implementation(libs.plantumlPlugin)
  implementation(libs.dependencycheckPlugin)
  implementation(libs.semverPlugin)
  implementation(libs.spotbugsPlugin)
  implementation(libs.lombokPlugin)
  implementation(libs.dokkaPlugin)
  implementation(libs.spotbugs)
  implementation(libs.jreleaserPlugin)
}
