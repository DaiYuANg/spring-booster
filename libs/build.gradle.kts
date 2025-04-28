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
  apply<MavenPublishPlugin>()

  if (!project.name.contains("bom")){
    apply<JavaLibraryPlugin>()
    dependencies {
      implementation(enforcedPlatform(rootProject.projects.libs.springBoostBom))
      api(enforcedPlatform(rootProject.projects.libs.springBoostBom))
      compileOnly(enforcedPlatform(rootProject.projects.libs.springBoostBom))
      annotationProcessor(enforcedPlatform(rootProject.projects.libs.springBoostBom))
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

    tasks.test {
      useJUnitPlatform()
    }
  }

}