plugins {
  kotlin("jvm")
  kotlin("plugin.allopen")
}

group = "org.toolkit.collections"

version = "1.0-SNAPSHOT"

dependencies { api("org.eclipse.collections:eclipse-collections-api:11.1.0") }
