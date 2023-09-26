dependencies {
  val caffeineVersion: String by project
  compileOnly("javax.cache:cache-api:1.1.1")
  compileOnly("org.ehcache:ehcache:3.10.8")
  compileOnly("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
  compileOnly("com.github.ben-manes.caffeine:guava:${caffeineVersion}")
  compileOnly("com.github.ben-manes.caffeine:jcache:${caffeineVersion}")
}
