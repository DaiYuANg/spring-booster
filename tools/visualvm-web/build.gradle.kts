plugins { kotlin("jvm") }

apply<GuicePlugin>()

group = "org.toolkit.visualvm.web"

sourceSets {}

dependencies {
  implementation("io.javalin:javalin:5.6.3")
  implementation("io.javalin:javalin-rendering:5.6.2")
  implementation("ch.qos.logback:logback-classic:1.4.14")
  implementation("com.github.oshi:oshi-core-java11:6.4.8")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.15.0")
  implementation("tools.profiler:async-profiler:2.9")
  implementation("io.insert-koin:koin-core:3.5.2-RC1")
  implementation("io.insert-koin:koin-logger-slf4j:3.5.2-RC1")
  testImplementation("io.insert-koin:koin-test:3.5.2-RC1")
  testImplementation("io.insert-koin:koin-test-junit5:3.5.2-RC1")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.15.0")
  implementation("io.insert-koin:koin-core-coroutines:3.5.2-RC1")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0-RC")
  implementation("com.google.jimfs:jimfs:1.3.0")
}
