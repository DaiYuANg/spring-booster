import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
apply<SpringBootProject>()

group = "org.spring.boost.office"
val projectName = "spring-boost-office"

dependencies {
  compileOnly(libs.spring.boot.starter.web)
  implementation(libs.poi)
  implementation(libs.poi.ooxml.full)
  implementation(libs.poi.ooxml)
  testImplementation(libs.spring.boot.starter.web)
  implementation(libs.apache.common.pool)
  compileOnly(projects.libs.springBoostCore)
}

mavenPublishing {
  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

  signAllPublications()
  coordinates(mavenNamespace, projectName, version.toString())
  pom {
    name.set(projectName)
    description.set(projectName)
    inceptionYear.set(year(Date()).toString())
    url.set(githubUrl)
    licenses {
      license {
        name.set(license)
      }
    }
    developers {
      developer {
        id.set(author)
        name.set(author)
        url.set(developerGithub)
      }
    }
    scm {
      url.set(scmUrl)
      connection.set(scmConnectionUrl)
      developerConnection.set(developConnectionUrl)
    }
  }
}
