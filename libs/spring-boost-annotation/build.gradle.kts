plugins {
  java
}

group = "org.spring.boost.codegen"


dependencies {
  implementation(platform(rootProject.projects.libs.springBoostBom))
}

tasks.test {
    useJUnitPlatform()
}