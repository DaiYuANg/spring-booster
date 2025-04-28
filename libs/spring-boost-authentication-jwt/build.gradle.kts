import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
apply<SpringBootProject>()

group = "org.spring.boost.authentication.jwt"
val projectName = "spring-boost-authentication-jwt"


dependencies {
  api(libs.jsonwebtoken.api)
  api(libs.jsonwebtoken.impl)
  api(libs.jsonwebtoken.jackson)
  compileOnly(libs.spring.boot.starter.security)
  compileOnly(projects.libs.springBoostAuthentication)
  compileOnly(libs.spring.boot.starter.web)
  compileOnly(projects.libs.springBoostCore)
  testImplementation(projects.libs.springBoostAuthentication)
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
