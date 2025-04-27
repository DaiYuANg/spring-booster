import com.vanniktech.maven.publish.SonatypeHost
import java.util.Date

plugins {
  alias(libs.plugins.maven.publish)
  signing
}

group = "org.spring.boost.jpa"
val projectName = "spring-boost-jpa"

dependencies {
  implementation(libs.hutool.core)
  implementation(libs.agrona)
  compileOnly(libs.jakarta.persistence)
  compileOnly(projects.libs.springBoostCore)
  api(libs.spring.boot.starter.jdbc)
  api(libs.spring.data.envers)
  api(libs.spring.boot.starter.data.jpa)
  annotationProcessor(libs.hibernate.jpamodelgen)

  val queryDSLApt = variantOf(libs.querydsl.apt) { classifier(JAKARTA) }
  compileOnly(queryDSLApt)
  annotationProcessor(queryDSLApt)
  implementation(libs.querydsl.jpa)
  implementation(libs.querydsl.core)
  annotationProcessor(libs.jakarta.persistence)
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
