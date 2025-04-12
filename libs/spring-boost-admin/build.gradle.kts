plugins {
  alias(libs.plugins.frontend)
}

group = "org.spring.boost.admin"



dependencies {
  implementation(projects.libs.springBoostMutiny)
//  implementation(libs.vertx.core)
  implementation(projects.libs.springBoostCore)
//  testImplementation(libs.vertx.junit5)
//  implementation(libs.vertx.web)
//  implementation(libs.vertx.web.client)
//  implementation(libs.mutiny.vertx)
//  implementation(libs.mutiny.vertx.web.client)
//  implementation(libs.mutiny.vertx.web)
  implementation(libs.javalin)
  implementation("org.eclipse.jetty:jetty-server:11.0.24")
  implementation("org.eclipse.jetty:jetty-servlet:11.0.24")
  implementation("org.eclipse.jetty:jetty-webapp:11.0.24")
  implementation("org.eclipse.jetty:jetty-http:11.0.24")
  implementation("org.eclipse.jetty:jetty-util:11.0.24")
  implementation("org.eclipse.jetty:jetty-io:11.0.24")
  implementation(libs.oshi)
}

frontend {
  nodeVersion.set("22.14.0")
  packageJsonDirectory.set(project.layout.projectDirectory.dir("src/main/webui"))
  assembleScript.set("build")
}

tasks.register<Copy>("copyFrontend") {
  from("src/main/webui/dist")
  destinationDir = File("build/classes/java/main/webroot")
  dependsOn(tasks.assembleFrontend)
}

tasks.withType(ProcessResources::class) {
  dependsOn("copyFrontend")
}