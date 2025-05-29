import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
apply<SpringBootProject>()

group = "org.spring.boost.filesystem.minio"
val projectName = "spring-boost-filesystem-minio"

dependencies {
  implementation(libs.minio)
  implementation(libs.minio.admin)
  implementation(libs.tika.core)
  implementation(libs.tika.parsers)
  implementation(libs.apache.common.io)
  implementation(libs.apache.common.codec)
  implementation(libs.okHttp)
  implementation(projects.libs.springBoostCore)
  implementation(libs.fastutil)
  testImplementation(libs.testcontainers.minio)
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
