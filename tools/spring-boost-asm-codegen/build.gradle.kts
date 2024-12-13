plugins {
  `java-library`
}

group = "org.spring.boost.codegen"


dependencies {
  implementation(platform(rootProject.projects.bom.springBoostBom))
  implementation(libs.bytebuddy)
}

tasks.test {
  useJUnitPlatform()
}