plugins {
  java
  application
}
apply<SpringBootProject>()
group = "org.spring.boost.sample.fs"

dependencies {
  implementation(enforcedPlatform(projects.bom.springBoostBom))
  implementation(projects.libs.springBoostFs)
  implementation(projects.libs.springBoostFsLocal)
  implementation(projects.libs.springBoostFsMinio)

  implementation(libs.spring.boot.starter.web)
}
