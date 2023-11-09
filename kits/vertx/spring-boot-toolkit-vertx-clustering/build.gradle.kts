group = "org.toolkit.spring.boot.starter.vertx.clustering"

version = "1.0-SNAPSHOT"

dependencies {
  val vertxVersion: String by project
  implementation("io.vertx:vertx-hazelcast:$vertxVersion")
  implementation(projects.kits.vertx.springBootToolkitVertxCore)
}
