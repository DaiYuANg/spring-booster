group = "org.toolkit.spring.boot.tika"

version = "1.0-SNAPSHOT"

dependencies {
  val tikaVersion: String by project
  api("org.apache.tika:tika-core:$tikaVersion")
  api("org.apache.tika:tika-parsers:$tikaVersion")
}
