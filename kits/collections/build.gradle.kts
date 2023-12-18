plugins {
  kotlin("jvm")
  kotlin("plugin.allopen")
}

group = "org.toolkit.collections"

version = "1.0-SNAPSHOT"

dependencies { implementation("org.eclipse.collections:eclipse-collections-api:11.1.0") }
