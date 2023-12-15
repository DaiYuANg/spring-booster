apply<GuicePlugin>()

group = "org.toolkit.visualvm.web"

version = "1.0-SNAPSHOT"

dependencies {
  implementation("io.javalin:javalin:5.6.3")
  implementation("io.javalin:javalin-rendering:5.6.2")
  implementation("ch.qos.logback:logback-classic:1.4.14")
  implementation("com.github.oshi:oshi-core-java11:6.4.8")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
}
