dependencies {
  val caffeineVersion: String by project
  compileOnly("javax.cache:cache-api:1.1.1")
  compileOnly("org.ehcache:ehcache:3.10.8")
  implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
  compileOnly("org.springframework.boot:spring-boot-starter-data-redis")
  compileOnly("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
  compileOnly("com.github.ben-manes.caffeine:guava:${caffeineVersion}")
  compileOnly("com.github.ben-manes.caffeine:jcache:${caffeineVersion}")
}
