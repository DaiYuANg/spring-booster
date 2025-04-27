import com.vanniktech.maven.publish.SonatypeHost
import org.springframework.boot.gradle.plugin.SpringBootPlugin
import java.util.Date

plugins {
  `java-platform`
  alias(libs.plugins.maven.publish)
  signing
}

group = "org.spring.boost.bom"
val projectName = "spring-boost-bom"

javaPlatform {
  allowDependencies()
}

dependencies {
  api(platform(SpringBootPlugin.BOM_COORDINATES))
  api(platform(libs.hutool.bom))
  api(platform(libs.mutiny.bom))
  api(platform(libs.spring.shell.bom))
  constraints {
    api(libs.springdoc.openapi.starter.webmvc.ui)
    api("org.apache.httpcomponents.client5:httpclient5:5.4.2")
//    utils
    api(libs.apache.common.io)
    api(libs.apache.common.codec)
    api(libs.apache.common.lang3)
    api(libs.apache.common.pool)
    api(libs.apache.common.dbutil)
    api(libs.guava)
    api(libs.vavr)
    api(libs.useragent)
    api(libs.fastutil)
    api(libs.eclipse.collections.api)
    api(libs.eclipse.collections)
    api(libs.eclipse.collections.forkjoin)
    api(libs.eclipse.collections.test.util)
    api(libs.semver4j)
    api(libs.agrona)
    api(libs.apache.http.client)

//    code generator
    api(libs.mapstruct)
    api(libs.mapstruct.annotation.processor)
    api(libs.lombok.mapstruct.binding)
    api(libs.record.builder.core)
    api(libs.record.builder.processor)
    api(libs.immutables.value)

//    lint
    api(libs.jetbrains.annotation)

//    querydsl
    api(libs.querydsl.core)
    api(libs.querydsl.apt)
    api(libs.querydsl.guava)
    api(libs.querydsl.spatial)
    api(libs.querydsl.jpa)
    api(libs.querydsl.collection)

//    third-part
    api(libs.minio)
    api(libs.minio.admin)
    api(libs.jsonwebtoken.api)
    api(libs.jsonwebtoken.impl)
    api(libs.jsonwebtoken.jackson)
    api(libs.tika.core)
    api(libs.tika.parsers)

//    office
    api(libs.poi)
    api(libs.poi.ooxml.full)
    api(libs.poi.ooxml)
    api(libs.fastExcel)

//    test
    api(libs.data.faker)
    api(libs.rest.assured)

//    spring
    api(libs.spring.boot.admin.starter.client)
    api(libs.spring.boot.admin.starter.server)

    rootProject.subprojects
      .filter { subproject ->
        subproject.path.startsWith(":libs:spring-boost-")
      }
      .forEach { subproject ->
        api("${mavenNamespace}:${subproject.name}:${subproject.version}")
      }
  }
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
