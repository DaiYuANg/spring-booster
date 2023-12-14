plugins { id("gg.jte.gradle") version "3.1.6" }

apply<GuicePlugin>()

group = "org.toolkit.visualvm.web"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("io.javalin:javalin:5.6.3")
  implementation("io.javalin:javalin-rendering:5.6.2")
  implementation("ch.qos.logback:logback-classic:1.4.14")
  implementation("gg.jte:jte:3.1.6")
  implementation("com.github.oshi:oshi-core-java11:6.4.8")
}
