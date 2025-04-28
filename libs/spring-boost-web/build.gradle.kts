import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
apply<SpringBootProject>()


group = "org.spring.boost.web"
val projectName = "spring-boost-web"

dependencies {
  compileOnly(projects.libs.springBoostCore)
  api(libs.spring.boot.starter.web)
  api(libs.apache.common.io)
  api(libs.hutool.http)
  api(libs.useragent)
  testImplementation(libs.spring.boot.starter.web)
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
