import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import java.net.URI
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
  java
  pmd
  idea
  tasks
  jacoco
  checkstyle
  commonProject
  id("com.github.ben-manes.versions")
  id("com.palantir.git-version")
  id("com.github.spotbugs-base")
  id("com.diffplug.spotless")
  id("org.owasp.dependencycheck")
  id("me.champeau.jmh") apply false
  id("io.freefair.lombok") apply false
  id("org.jreleaser")
  id("org.springframework.boot") apply false
  id("io.spring.dependency-management") apply false
}

allprojects {
  repositories {
    maven { url = URI("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
    maven { url = URI("https://mirrors.cloud.tencent.com/nexus/repository/maven-public/") }
    maven { url = URI("https://maven.aliyun.com/repository/public") }
    maven { url = URI("https://maven.aliyun.com/repository/spring/") }
    maven { url = URI("https://repo.huaweicloud.com/repository/maven/") }
    maven { setUrl("https://repo.spring.io/snapshot") }
    maven { setUrl("https://repo.spring.io/milestone") }
    mavenLocal()
    mavenCentral()
    gradlePluginPortal()
    google()
  }
}

group = "org.toolkit"

version = "1.0-SNAPSHOT"

spotless {
  format("misc") {
    target("*.md", ".gitignore", "**/*.java")
    indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
    endWithNewline()
  }
  java {
    target("**/*.java")
    importOrder()
    palantirJavaFormat()
    indentWithTabs()
    removeUnusedImports()
    formatAnnotations()
  }

  kotlinGradle {
    target("**/*.gradle.kts") // default target for kotlinGradle
    ktfmt() // or ktfmt() or prettier()
  }
}

true.also { gradle.startParameter.isBuildCacheEnabled = it }

subprojects {
  val jdkVersion: String by project

  apply {
    plugin("java")
    plugin("java-library")
    plugin("me.champeau.jmh")
    plugin("io.freefair.lombok")
    plugin("maven-publish")
    plugin("com.palantir.git-version")
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
  }

  the<DependencyManagementExtension>().apply {
    imports { mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) }
  }

  group = "org." + rootProject.name + "." + project.name
  val versionDetails: groovy.lang.Closure<com.palantir.gradle.gitversion.VersionDetails> by extra
  val details = versionDetails()
  version = details.lastTag

  dependencies {
    val gsonVersion: String by project
    val mapstructVersion: String by project
    val guavaVersion: String by project
    val slf4jVersion: String by project
    val rxjavaVersion: String by project
    val commonIOVersion: String by project
    val jetbrainsAnnotationsVersion: String by project
    val immutablesVersion: String by project
    val jakartaJsonVersion: String by project
    val junitVersion: String by project
    val testContainersVersion: String by project
    val hutoolVersion: String by project
    implementation("com.google.code.gson:gson:${gsonVersion}")
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    implementation("com.google.guava:guava:${guavaVersion}")
    implementation("org.slf4j:slf4j-api:${slf4jVersion}")
    implementation("io.reactivex.rxjava3:rxjava:${rxjavaVersion}")
    implementation("commons-io:commons-io:${commonIOVersion}")
    implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
    implementation("io.soabase.record-builder:record-builder-core:37")
    implementation("org.inferred:freebuilder:2.8.0")
    implementation("cn.hutool:hutool-all:${hutoolVersion}")
    implementation("org.eclipse.collections:eclipse-collections-api:11.1.0")
    implementation("org.eclipse.collections:eclipse-collections:11.1.0")
    implementation("org.agrona:Agrona:0.9.1")
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    annotationProcessor("io.soabase.record-builder:record-builder-processor:37")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    annotationProcessor("org.inferred:freebuilder:2.8.0")
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
    testImplementation("org.testcontainers:testcontainers:$testContainersVersion")
    testImplementation("org.testcontainers:testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
  }

  tasks {
    withType<JavaCompile> {
      options.isIncremental = true
      options.encoding = "UTF-8"
    }
    withType<Test> { useJUnitPlatform() }
    withType<BootJar> { enabled = false }

    withType<Jar> {
      enabled = true
      duplicatesStrategy = DuplicatesStrategy.INCLUDE
    }

    withType<JavaCompile> { dependsOn("processResources") }
    java {
      sourceCompatibility = JavaVersion.toVersion(jdkVersion)
      targetCompatibility = JavaVersion.toVersion(jdkVersion)
      toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion)) }
    }
  }
  tasks.test { useJUnitPlatform() }
}
