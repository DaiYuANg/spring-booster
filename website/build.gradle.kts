import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  `spring-boot-project`
  `kotlin-support`
  application
}

val mainClass = "org.toolkit.spring.boot.website.WebsiteApplication"

group = "org.toolkit.spring.boot.website"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation(projects.kits.core.springBootToolkitUtils)
  implementation(projects.kits.core.springBootToolkitPersistence)
  implementation("me.paulschwarz:spring-dotenv:4.0.0")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("org.springframework.boot:spring-boot-starter-mail")
  developmentOnly("org.springframework.boot:spring-boot-docker-compose")
  implementation("com.h2database:h2")
}

resources.delegateClosureOf<CopySpec> {
  from("src/resources/images") {
    include("images/**/*.png")
    exclude("images/**/notThisOne.png")
  }

  from("${layout.buildDirectory}/downloads") { include("deck.js/**") }

  into("./images")
}

tasks.getByName<BootJar>("bootJar") { doFirst { copyDocs } }

tasks.getByName<Jar>("jar") {
  dependsOn("buildMkdocs")
  from("build/docs") { into("static") }
}

tasks.withType<JavaCompile> {
  dependsOn("poetryInstall")
  options.encoding = Charsets.UTF_8.name()
  dependsOn("copyDocs")
}

val copyDocs =
    tasks.register("copyDocs", Copy::class) {
      dependsOn(tasks.spotlessJava)
      dependsOn(tasks.processResources.name)
      dependsOn(buildDocs)
      from("build/docs")
      into("src/main/resources/static")
    }

val poetryInstall = task<Exec>("poetryInstall") { commandLine("poetry", "lock") }
val serveDocs =
    task<Exec>("serveMkdocs") {
      commandLine("poetry", "run", "mkdocs", "serve", "-a", "localhost:9000")
    }

val buildDocs =
    task<Exec>("buildMkdocs") {
      commandLine("poetry", "run", "mkdocs", "build", "-d", "build/docs")
    }
