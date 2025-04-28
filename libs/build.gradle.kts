import org.gradle.kotlin.dsl.withType
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTaskPartial
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  `maven-publish`
  `java-library`
  alias(libs.plugins.dokka)
}

dependencies {
  api(projects.libs.springBoostJpa)
  api(projects.libs.springBoostCore)
//  api(projects.libs.springBoostMinio)
  api(projects.libs.springBoostOffice)
  api(projects.libs.springBoostVerification)
  api(projects.libs.springBoostAuthentication)
  api(projects.libs.springBoostAuthenticationJwt)
}

subprojects {
  apply<MavenPublishPlugin>()
  apply<DokkaPlugin>()
  tasks.dokkaHtml {
    outputDirectory.set(layout.buildDirectory.dir("docs/partial"))
  }
  // configure all format tasks at once
  tasks.withType<DokkaTaskPartial>().configureEach {
    dokkaSourceSets.configureEach {
      includes.from("README.md")
    }
  }
  if (!project.name.contains("bom")){
    apply<JavaLibraryPlugin>()
    dependencies {
      implementation(platform(rootProject.projects.libs.springBoostBom))
      api(platform(rootProject.projects.libs.springBoostBom))
      compileOnly(platform(rootProject.projects.libs.springBoostBom))
      annotationProcessor(platform(rootProject.projects.libs.springBoostBom))
      compileOnly(rootProject.libs.mica.auto)
      implementation(rootProject.libs.mapstruct)
      annotationProcessor(rootProject.libs.mapstruct.annotation.processor)
      annotationProcessor(rootProject.libs.mica.auto)
      compileOnly(rootProject.libs.record.builder.core)
      annotationProcessor(rootProject.libs.record.builder.processor)

      testImplementation(enforcedPlatform(rootProject.libs.junitBom))
      testImplementation(rootProject.libs.junitApi)
      testImplementation(rootProject.libs.junitEngine)
      testImplementation(rootProject.libs.junitJuiter)
      testImplementation(rootProject.projects.libs.springBoostCore)
    }

    tasks.test {
      useJUnitPlatform()
    }
  }

}