plugins {
  java
}

group = "org.spring.boost.codegen"


dependencies {
  implementation(platform(rootProject.projects.bom.springBoostBom))
}

tasks.test {
    useJUnitPlatform()
}