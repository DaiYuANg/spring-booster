dependencies {
  val caffeineVersion: String by project
  compileOnly("org.ehcache:ehcache:3.10.8")
  implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")

  compileOnly("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
  compileOnly("com.github.ben-manes.caffeine:guava:${caffeineVersion}")
  compileOnly("com.github.ben-manes.caffeine:jcache:${caffeineVersion}")
}
