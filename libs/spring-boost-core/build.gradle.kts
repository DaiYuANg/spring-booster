import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
group = "org.spring.boost.core"
val projectName = "spring-boost-core"

dependencies {
  api(libs.apache.common.lang3)
  api(libs.guava)
  api(libs.apache.common.text)
  api(libs.vavr)
  api(libs.hutool.extra)
  api(libs.mutiny)
  api(libs.eclipse.collections.api)
  api(libs.eclipse.collections)
  api(libs.prometheus)
  annotationProcessor(libs.spring.boot.configuration.processor)
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
