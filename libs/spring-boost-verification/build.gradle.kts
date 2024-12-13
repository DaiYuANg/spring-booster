dependencies {
  implementation(libs.jakarta.validation)
  api(libs.spring.boot.starter.validation)
  api(libs.spring.boot.starter.jdbc)
  compileOnly(projects.libs.springBoostCore)
  api(libs.hutool.core)
  api(libs.hutool.extra)
  api(libs.hutool.json)
}
