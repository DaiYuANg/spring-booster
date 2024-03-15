import org.jreleaser.gradle.plugin.JReleaserPlugin
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  `maven-publish`
}

dependencies {
  implementation(projects.booster.springBoostMappingCore)
  implementation(projects.booster.springBoostJpa)
  implementation(projects.booster.springBoostCore)
  implementation(projects.booster.springBoostMinio)
  implementation(projects.booster.springBoostDotenv)
  implementation(projects.booster.springBoostOffice)
  implementation(projects.booster.springBoostVerification)
  implementation(projects.booster.springBoostAuthentication)
  implementation(projects.booster.springBoostAuthenticationJwt)
  implementation(projects.booster.springBoostMappingWeb)
  implementation(projects.booster.springBoostMappingCodeSource)
}

allprojects {
  val jar: Jar by tasks
  val bootJar: BootJar by tasks

  bootJar.enabled = false
  jar.enabled = true
}

subprojects {
  apply<MavenPublishPlugin>()
  apply<JReleaserPlugin>()

  dependencies{
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