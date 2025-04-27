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
  apply<MavenPublishPlugin>()

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

    testImplementation(enforcedPlatform(rootProject.libs.junitBom))
    testImplementation(rootProject.libs.junitApi)
    testImplementation(rootProject.libs.junitEngine)
    testImplementation(rootProject.libs.junitJuiter)
    testImplementation(rootProject.projects.libs.springBoostCore)
  }
  val jar: Jar by tasks
  val bootJar: BootJar by tasks

  bootJar.enabled = false
  jar.enabled = true

  tasks.test {
    useJUnitPlatform()
  }
}