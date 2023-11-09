plugins { id("java") }

group = "org.toolkit.spring.boot.starter.vertx.web"

version = "1.0-SNAPSHOT"

repositories { mavenCentral() }

dependencies {
  val vertxVersion: String by project
  implementation(projects.kits.core.springBootToolkitUtils)
  implementation(projects.kits.vertx.springBootToolkitVertxCore)
  implementation("io.vertx:vertx-web:$vertxVersion")
  implementation("io.vertx:vertx-web-client:$vertxVersion")
  testImplementation("io.vertx:vertx-web-client:$vertxVersion")
  testImplementation("io.vertx:vertx-web:$vertxVersion")
}

tasks.test { useJUnitPlatform() }
