group = "org.spring.boost.admin"
dependencies {
  implementation(projects.libs.springBoostMutiny)
  implementation(libs.vertx.core)
  testImplementation(libs.vertx.junit5)
  implementation(libs.vertx.web)
  implementation(libs.vertx.web.client)
  implementation(libs.vertx.web.templ.thymeleaf)
  implementation(libs.mutiny.vertx)
  implementation(libs.mutiny.vertx.web.client)
  implementation(libs.mutiny.vertx.web.templ.thymeleaf)
  implementation(libs.mutiny.vertx.web)
}
