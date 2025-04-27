import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}

group = "org.spring.boost.verification"
val projectName = "spring-boost-verification"

dependencies {
  implementation(libs.jakarta.validation)
  api(libs.spring.boot.starter.validation)
  api(libs.spring.boot.starter.jdbc)
  compileOnly(projects.libs.springBoostCore)
  api(libs.hutool.core)
  api(libs.hutool.extra)
  api(libs.hutool.json)
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
