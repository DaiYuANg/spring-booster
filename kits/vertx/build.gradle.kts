subprojects {
  dependencies {
    val vertxVersion: String by project
    implementation("io.vertx:vertx-core:$vertxVersion")
  }
}
