import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  `maven-publish`
  `java-library`
}

dependencies {
  api(projects.libs.springBoostJpa)
  api(projects.libs.springBoostCore)
//  api(projects.libs.springBoostMinio)
  api(projects.libs.springBoostOffice)
  api(projects.libs.springBoostVerification)
  api(projects.libs.springBoostAuthentication)
  api(projects.libs.springBoostAuthenticationJwt)
}

subprojects {
  apply<JavaLibraryPlugin>()
  apply<SpringBootProject>()
  dependencies {
    implementation(platform(rootProject.projects.bom.springBoostBom))
    api(platform(rootProject.projects.bom.springBoostBom))
    compileOnly(platform(rootProject.projects.bom.springBoostBom))
    annotationProcessor(platform(rootProject.projects.bom.springBoostBom))
    compileOnly(rootProject.libs.mica.auto)
    implementation(rootProject.libs.mapstruct)
    annotationProcessor(rootProject.libs.mapstruct.annotation.processor)
    annotationProcessor(rootProject.libs.mica.auto)
    compileOnly(rootProject.libs.record.builder.core)
    annotationProcessor(rootProject.libs.record.builder.processor)
  }
  val jar: Jar by tasks
  val bootJar: BootJar by tasks

  bootJar.enabled = false
  jar.enabled = true
}