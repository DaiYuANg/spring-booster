group = "org.toolkit.spring.boot.cache.redis"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(projects.kits.cache.springBootToolkitCacheApi)
  implementation("org.springframework.boot:spring-boot-starter-data-redis")
}
