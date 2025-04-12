plugins {
  java
  application
  alias(libs.plugins.frontend)
}

val mainClassPath = "org.spring.boost.example.ExampleApplication"

apply<SpringBootProject>()

configurations.all {
  resolutionStrategy {
    eachDependency {
      if (requested.group == "org.eclipse.jetty") {
        useVersion("11.0.24")
      }
    }
  }
}

dependencies {
  implementation(enforcedPlatform(projects.bom.springBoostBom))
  implementation(projects.libs.springBoostMutiny)
  implementation(projects.libs.springBoostAuthentication)
  implementation(projects.libs.springBoostAuthenticationJwt)
  implementation(projects.libs.springBoostWeb)
  implementation(projects.libs.springBoostCaptcha)
  implementation(projects.libs.springBoostCore)
  implementation(projects.libs.springBoostJpa)
  implementation(projects.libs.springBoostRbac)
  implementation(projects.libs.springBoostAdmin)
  implementation(libs.spring.boot.starter.logging)
  implementation(libs.springdoc.openapi.starter.webmvc.ui)

  implementation(libs.h2)
  compileOnly(libs.spring.boot.devtools)
  implementation(libs.spring.boot.starter.web){
    exclude(group = "org.eclipse.jetty")
    exclude(group = "org.eclipse.jetty.websocket")
  }

  implementation(libs.mapstruct)
  annotationProcessor(libs.mapstruct.annotation.processor)

  compileOnly(libs.record.builder.core)
  annotationProcessor(libs.record.builder.processor)
}

frontend {
  nodeVersion.set("22.14.0")
  packageJsonDirectory.set(project.layout.projectDirectory.dir("src/main/webui"))
}