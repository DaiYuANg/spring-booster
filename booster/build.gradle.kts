import org.jreleaser.gradle.plugin.JReleaserPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  `maven-publish`
}

dependencies {
  implementation(projects.booster.springBoostJpa)
  implementation(projects.booster.springBoostCore)
  implementation(projects.booster.springBoostMinio)
  implementation(projects.booster.springBoostOffice)
  implementation(projects.booster.springBoostVerification)
  implementation(projects.booster.springBoostAuthentication)
  implementation(projects.booster.springBoostAuthenticationJwt)
}

allprojects {
  val jar: Jar by tasks
  val bootJar: BootJar by tasks

  bootJar.enabled = false
  jar.enabled = true

  tasks.processAot {
    enabled = false
  }
}

subprojects {
  apply<MavenPublishPlugin>()
  apply<JReleaserPlugin>()

  dependencies {
    implementation(rootProject.libs.recordBuilderCore)
    annotationProcessor(rootProject.libs.recordBuilderProcessor)
    implementation(rootProject.libs.mapstruct)
    annotationProcessor(rootProject.libs.mapstructAnnotationProcessor)
    compileOnly(rootProject.libs.micaAuto)
    annotationProcessor(rootProject.libs.micaAuto)
  }

  publishing {
    publications {

      create<MavenPublication>("local") {
        pom {
          groupId = project.group.toString()
          artifactId = project.name
          version = project.version.toString()

          distributionManagement {
            relocation {
              groupId = project.group.toString()
              artifactId = project.name
              version = project.version.toString()
            }
          }
        }
      }
    }
  }
}