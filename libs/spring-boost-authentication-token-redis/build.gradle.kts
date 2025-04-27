group = "org.spring.boost.authentication.token.redis"

dependencies {
  implementation(libs.spring.boot.starter.redis)
  implementation(projects.libs.springBoostAuthentication)
  implementation(projects.libs.springBoostCore)
}
