import com.vanniktech.maven.publish.SonatypeHost

plugins {
  alias(libs.plugins.maven.publish)
  signing
}
version = "0.1"

dependencies {
  api(libs.spring.boot.starter.security)
  api(libs.spring.boot.starter.web)
  api(libs.spring.security.data)
  compileOnly(projects.libs.springBoostCore)
  testImplementation(libs.spring.security.test)
}

mavenPublishing {
  publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

  signAllPublications()

  coordinates("io.github.daiyuang", "spring-boost-authentication", version.toString())
  pom {
    name.set("spring-boost-authentication")
    description.set("spring-boost-authentication")
    inceptionYear.set("2025")
    url.set("https://github.com/DaiYuANg/spring-booster")
    licenses {
      license {
        name.set("The Apache License, Version 2.0")
        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
        distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
      }
    }
    developers {
      developer {
        id.set("daiyuang")
        name.set("daiyuang")
        url.set("https://github.com/DaiYuANg")
      }
    }
    scm {
      url.set("https://github.com/DaiYuANg/spring-booster")
      connection.set("scm:git:git://github.com//DaiYuANg/spring-booster.git")
      developerConnection.set("scm:git:ssh://git@github.com//DaiYuANg/spring-booster.git")
    }
  }
}
