plugins { id("org.siouan.frontend-jdk17") version "8.0.0" }

frontend { nodeVersion.set("20.9.0") }

val frontendDist = project.layout.buildDirectory.dir("dist")
val resourceDir = project.layout.buildDirectory.dir("resources")

tasks.register("copyFrontendDist", Copy::class) {
  dependsOn("jmhRunBytecodeGenerator")
  from(frontendDist)
  into(resourceDir)
}

tasks.jar {
  dependsOn("copyFrontendDist")
  from(resourceDir)
  manifest {
    attributes["Implementation-Title"] = project.name
    attributes["Implementation-Version"] = project.version
  }
}
