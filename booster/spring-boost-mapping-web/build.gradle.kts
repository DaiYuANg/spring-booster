import org.springframework.boot.gradle.tasks.bundling.BootJar


dependencies {
  compileOnly(projects.booster.springBoostMappingCore)
  implementation(libs.bytebuddy)
  implementation(libs.fastutil)
  testImplementation(projects.booster.springBoostMappingCore)
}

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true