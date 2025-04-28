import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
apply<SpringBootProject>()

group = "org.spring.boost.fs"
val projectName = "spring-boost-fs"

dependencies {
  api(libs.apache.common.io)
  api(libs.apache.common.codec)
  api(libs.tika.core)
  api(libs.tika.parsers)
  implementation(libs.vavr)
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
