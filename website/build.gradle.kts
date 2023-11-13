import kotlin.io.path.Path
import org.asciidoctor.gradle.jvm.AsciidoctorTask
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  val asciidoctorVersion = "3.3.2"
  id("org.asciidoctor.jvm.convert") version asciidoctorVersion
  id("org.asciidoctor.jvm.pdf") version asciidoctorVersion
  id("org.asciidoctor.jvm.epub") version asciidoctorVersion
  id("org.asciidoctor.jvm.revealjs") version asciidoctorVersion
}

val supportLanguages = listOf("en", "zh")

val mainClass = "org.toolkit.spring.boot.website.WebsiteApplication"

group = "org.toolkit.spring.boot.website"

version = "1.0-SNAPSHOT"

dependencies { implementation("org.springframework.boot:spring-boot-starter-web") }

tasks {
  "asciidoctor"(AsciidoctorTask::class) {
    baseDirIsRootProjectDir()
    baseDirIsProjectDir()
    baseDirFollowsSourceDir()
    baseDirFollowsSourceFile()
    languages(supportLanguages)
    setSourceDir(file("src/asciidoc"))
    sources(delegateClosureOf<PatternSet> { include("**/*.adoc") })
    setOutputDir(file("build/docs"))
  }
}

sourceSets {
  create("asciidoc") {
    val baseAsciidoc = "src/asciidoc"
    java.srcDir(baseAsciidoc)
    supportLanguages.forEach { language -> java.srcDir(Path(baseAsciidoc, language)) }
  }
}

asciidoctorj {
  modules {
    diagram.use()
    diagram.version("1.5.16")
  }
}

resources.delegateClosureOf<CopySpec> {
  from("src/resources/images") {
    include("images/**/*.png")
    exclude("images/**/notThisOne.png")
  }

  from("${layout.buildDirectory}/downloads") { include("deck.js/**") }

  into("./images")
}

tasks.getByName<BootJar>("bootJar") {
  dependsOn("asciidoctor")

  from("build/docs") { into("static") }
}

tasks.getByName<Jar>("jar") {
  dependsOn("asciidoctor")

  from("build/docs") { into("static") }
}
