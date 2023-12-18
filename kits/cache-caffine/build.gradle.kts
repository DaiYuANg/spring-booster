group = "org.toolkit.spring.boot.cache.caffine"

version = "1.0-SNAPSHOT"

dependencies {
  val caffeineVersion: String by project
  implementation(libs.caffine)
}
