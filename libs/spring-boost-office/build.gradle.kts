plugins{
  `java-library`
}

dependencies {
  compileOnly(libs.spring.boot.starter.web)
  implementation(libs.poi)
  implementation(libs.poi.ooxml.full)
  implementation(libs.poi.ooxml)
  implementation(libs.classgraph)
  testImplementation(libs.spring.boot.starter.web)
  implementation(libs.apache.common.pool)
  compileOnly(projects.libs.springBoostCore)
}
