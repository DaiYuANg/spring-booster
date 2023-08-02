dependencies {
  val caffeineVersion: String by project
  implementation("javax.cache:cache-api:1.1.1")
  implementation("org.ehcache:ehcache:3.10.8")
  implementation("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
  implementation("com.github.ben-manes.caffeine:guava:${caffeineVersion}")
  implementation("com.github.ben-manes.caffeine:jcache:${caffeineVersion}")
}
