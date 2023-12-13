apply<PicoCliProjectPlugin>()
apply<GuicePlugin>()
group = "org.toolkit.site.generator.cli"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("io.javalin:javalin:6.0.0-beta.3")
}
