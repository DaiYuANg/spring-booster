import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.springframework.boot.gradle.tasks.bundling.BootJar
import java.net.URI

plugins {
  `java-library`
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
    val okhttpVersion: String by project
    val jakartaPersistenceVersion: String by project
    val hutoolVersion: String by project
    val jakartaJsonVersion: String by project
    val junitVersion: String by project
    val testContainersVersion: String by project
    implementation("com.google.code.gson:gson:${gsonVersion}")
    implementation("org.mapstruct:mapstruct:${mapstructVersion}")
    implementation("com.google.guava:guava:${guavaVersion}")
    implementation("org.slf4j:slf4j-api:${slf4jVersion}")
    implementation("org.springframework.boot:spring-boot-starter-json")
    implementation("org.springframework.boot:spring-boot-starter")
    testImplementation("org.springframework.boot:spring-boot-starter")
    implementation("org.springframework.boot:spring-boot-starter-aop")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
    implementation("io.reactivex.rxjava3:rxjava:${rxjavaVersion}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
    implementation("commons-io:commons-io:${commonIOVersion}")
    implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
    implementation("org.immutables:value:${immutablesVersion}")
    implementation("cn.hutool:hutool-all:${hutoolVersion}")
    implementation("net.bytebuddy:byte-buddy:1.14.5")
    testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
    testImplementation("net.datafaker:datafaker:2.0.1")
    testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
    testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
    implementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
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
    java { toolchain { languageVersion.set(JavaLanguageVersion.of(jdkVersion)) } }
  }
}
