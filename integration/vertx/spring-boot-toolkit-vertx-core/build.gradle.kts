group = "org.toolkit.spring.boot.vertx"

version = "1.0-SNAPSHOT"

dependencies {
  val vertxVersion: String by project
  implementation(projects.kits.core.springBootToolkitUtils)
  testImplementation("io.vertx:vertx-core:$vertxVersion")
  testImplementation("io.vertx:vertx-hazelcast:$vertxVersion")
  testImplementation(projects.kits.core.springBootToolkitUtils)
}
