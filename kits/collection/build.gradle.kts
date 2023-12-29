plugins {
  kotlin("jvm")
  kotlin("plugin.allopen")
}

group = "org.toolkit.collections"

version = "1.0-SNAPSHOT"

dependencies {
  api("org.eclipse.collections:eclipse-collections-api:11.1.0")
  api("com.google.guava:guava:33.0.0-jre")
  api("org.immutables:value:2.9.2")
}

kotlin{
  jvmToolchain(21)
  compilerOptions{
    freeCompilerArgs = listOf("-Xjvm-default=all")
  }
}
