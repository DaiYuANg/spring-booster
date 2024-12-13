plugins {
  `java-gradle-plugin`
  kotlin("jvm") version "2.1.0"
}

group = "org.spring.boost.gradle.plugin"

dependencies {
//  testImplementation(platform("org.junit:junit-bom:5.10.0"))
//  testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
  useJUnitPlatform()
}