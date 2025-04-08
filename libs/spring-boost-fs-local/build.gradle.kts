group = "org.spring.boost.local.fs"

dependencies {
  compileOnly(projects.libs.springBoostFs)
  implementation(libs.jimfs)
}
