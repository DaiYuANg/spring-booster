import org.springframework.boot.gradle.tasks.bundling.BootJar

val mainClass = "org.toolkit.spring.boot.website.WebsiteApplication"

group = "org.toolkit.spring.boot.website"

version = "1.0-SNAPSHOT"

dependencies { implementation("org.springframework.boot:spring-boot-starter-web") }

resources.delegateClosureOf<CopySpec> {
  from("src/resources/images") {
    include("images/**/*.png")
    exclude("images/**/notThisOne.png")
  }

  from("${layout.buildDirectory}/downloads") { include("deck.js/**") }

  into("./images")
}

tasks.getByName<BootJar>("bootJar") { from("build/docs") { into("static") } }

tasks.getByName<Jar>("jar") { from("build/docs") { into("static") } }

tasks.withType<JavaCompile> {
  options.encoding = Charsets.UTF_8.name()
  dependsOn("copyDocs")
}

tasks.register("copyDocs", Copy::class) {
  from("build/docs")
  into("static")
}

task<Exec>("serveMkdocs") {
  commandLine("poetry", "run", "mkdocs", "serve", "-a", "localhost:9000")
}

task<Exec>("buildMkdocs") {
  commandLine("poetry", "run", "mkdocs", "build")
  //    copy {
  //        workingDir(projectDir)
  //        from({
  //            "site"
  //        })
  //        to("docs")
  //    }
}
