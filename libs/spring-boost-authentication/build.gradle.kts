import org.jreleaser.model.Active

version = "0.1"

dependencies {
  api(libs.spring.boot.starter.security)
  api(libs.spring.boot.starter.web)
  api(libs.spring.security.data)
  compileOnly(projects.libs.springBoostCore)
  testImplementation(libs.spring.security.test)
}

publishing {
  publications {
    create<MavenPublication>("maven") {
      groupId = project.group.toString()
      artifactId = project.name
      version = project.version.toString()
      from(components["java"])
      pom {
        name.set(project.name)
        description.set(project.description)
        url.set("https://github.com/ministryofjustice/spring-boot-boost")
        licenses {
          license {
            name.set("MIT License")
          }
        }
        developers {
          developer {
            id.set("ministryofjustice")
            name.set("Ministryofjustice")
          }
        }
        scm { url.set("https://github.com/ministryofjustice/spring-boot-boost") }
      }
    }
  }
  repositories {
    maven {
      name = "LocalRepo"
      url = uri(layout.buildDirectory.dir("staging-deploy"))
    }
  }
}

jreleaser {
  signing {
    active.set(Active.ALWAYS)
    armored.set(true)
  }
  deploy {
    maven {
      mavenCentral {
        create("sonatype") {
          active.set(Active.ALWAYS)
          url.set("https://central.sonatype.com/api/v1/publisher")
          stagingRepository(layout.buildDirectory.dir("staging-deploy").get().asFile.absolutePath)
        }
      }
    }
  }
}