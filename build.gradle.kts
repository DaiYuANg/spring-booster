import org.jetbrains.kotlin.kapt3.base.Kapt
import java.net.URI

plugins {
    java
    pmd
    idea
    tasks
    scala
    jacoco
    checkstyle
    commonProject
    id("org.jetbrains.kotlinx.benchmark") apply false
    id("org.jetbrains.kotlin.plugin.lombok") apply false
    id("org.jetbrains.kotlin.plugin.allopen") apply false
//    kotlin("noarg") apply false
    kotlin("kapt")
    id("com.palantir.git-version")
    id("org.jetbrains.kotlin.jvm") apply false
    id("com.github.spotbugs-base")
    id("com.diffplug.spotless")
    id("org.owasp.dependencycheck")
    id("me.champeau.jmh") apply false
    id("io.freefair.lombok") apply false
    id("org.jreleaser")
    id("com.github.node-gradle.node") apply false
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
        if (rootProject.hasProperty("gitLabPrivateToken")) {
            maven {
                url = URI("https://dev.daiyuang.cloud:83/api/v4/groups/17/-/packages/maven")
                name = "GitLab"
//                credentials(HttpHeaderCredentials) {
//                    name = 'gradle'
//                    value = gitLabPrivateToken
//                }
//                authentication {
//                    header(HttpHeaderAuthentication)
//                }
            }
        }
    }
}


tasks.jar {
    enabled = false
}

group = "org.toolkit4J"
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

    kotlin {
        target("**/*.kt")
        ktfmt()
//		ktlint()
        //		diktat()
        //		prettier()
    }

    scala {
        scalafmt()
    }
}

true.also { gradle.startParameter.isBuildCacheEnabled = it }

subprojects {
    val jdkVersion: String by project

    apply {
        plugin("java")
        plugin("me.champeau.jmh")
        plugin("io.freefair.lombok")
        plugin("org.jetbrains.kotlinx.benchmark")
        plugin("org.jetbrains.kotlin.jvm")
        plugin("org.jetbrains.kotlin.plugin.lombok")
        plugin("org.jetbrains.kotlin.plugin.allopen")
        plugin("org.jetbrains.kotlin.kapt")
        plugin("org.jetbrains.kotlinx.benchmark")
        plugin("maven-publish")
        plugin("com.palantir.git-version")
        plugin("groovy")
        plugin("scala")
    }

    group = "org." + rootProject.name + "." + project.name
//    def details = versionDetails()
//    def vs = details.lastTag
//            version(vs)

    dependencies {
        val gsonVersion: String by project
        val mapstructVersion: String by project
        val guavaVersion: String by project
        val slf4jVersion: String by project
        val caffeineVersion: String by project
        val rxjavaVersion: String by project
        val aspectjVersion: String by project
        val agronaVersion: String by project
        val commonIOVersion: String by project
        val jetbrainsAnnotationsVersion: String by project
        val immutablesVersion: String by project
        val okhttpVersion: String by project
        val jakartaPersistenceVersion: String by project
        val jakartaEnterpriseCdi: String by project
        val hutoolVersion: String by project
        val jakartaJsonVersion: String by project
        val junitVersion: String by project
        val testContainersVersion: String by project
        val restAssuredVersion: String by project
        val assertjVersion: String by project
        val mockitoVersion: String by project
        implementation("com.google.code.gson:gson:${gsonVersion}")
        implementation("org.mapstruct:mapstruct:${mapstructVersion}")
        implementation("com.google.guava:guava:${guavaVersion}")
        implementation("org.slf4j:slf4j-api:${slf4jVersion}")
        implementation("com.github.ben-manes.caffeine:caffeine:${caffeineVersion}")
        implementation("com.github.ben-manes.caffeine:guava:${caffeineVersion}")
        implementation("com.github.ben-manes.caffeine:jcache:${caffeineVersion}")
        implementation("io.reactivex.rxjava3:rxjava:${rxjavaVersion}")
        implementation("org.aspectj:aspectjtools:${aspectjVersion}")
        implementation("org.agrona:agrona:${agronaVersion}")
        implementation("org.jsoup:jsoup:1.16.1")
        implementation("net.bytebuddy:byte-buddy:1.14.5")

        annotationProcessor("org.mapstruct:mapstruct-processor:${mapstructVersion}")
        implementation("org.aspectj:aspectjrt:${aspectjVersion}")
        implementation("commons-io:commons-io:${commonIOVersion}")
        implementation("org.aspectj:aspectjweaver:${aspectjVersion}")
        implementation("org.jetbrains:annotations:${jetbrainsAnnotationsVersion}")
        implementation("org.immutables:value:${immutablesVersion}")
        implementation(platform("com.squareup.okhttp3:okhttp-bom:${okhttpVersion}"))
        implementation("com.squareup.okhttp3:okhttp")
        implementation("org.jetbrains:annotations:24.0.1")
        implementation("com.squareup.okhttp3:logging-interceptor")
        implementation("jakarta.persistence:jakarta.persistence-api:${jakartaPersistenceVersion}")
        implementation("jakarta.enterprise:jakarta.enterprise.cdi-api:${jakartaEnterpriseCdi}")
        implementation("cn.hutool:hutool-all:${hutoolVersion}")
        implementation("net.datafaker:datafaker:2.0.1")
        implementation("jakarta.json:jakarta.json-api:${jakartaJsonVersion}")
        implementation("jakarta.data:jakarta-data-api:1.0.0-b2")
        implementation("org.jetbrains.kotlin:kotlin-reflect")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.2")
        testImplementation(platform("org.junit:junit-bom:${junitVersion}"))
        testImplementation("com.squareup.okhttp3:mockwebserver:${okhttpVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter:${junitVersion}")
        testImplementation("org.junit.jupiter:junit-jupiter-api:${junitVersion}")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${junitVersion}")
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        implementation(platform("org.testcontainers:testcontainers-bom:${testContainersVersion}"))
        testImplementation("org.testcontainers:postgresql")
        testImplementation("org.testcontainers:mysql")
        testImplementation("org.testcontainers:rabbitmq")
        testImplementation("org.testcontainers:elasticsearch")
        testImplementation("org.testcontainers:mssqlserver")
        testImplementation("org.testcontainers:mockserver")
        testImplementation("org.testcontainers:selenium")
        testImplementation("com.github.dasniko:testcontainers-keycloak:2.5.0")
        testImplementation("com.redis.testcontainers:testcontainers-redis-junit:1.6.4")
        testImplementation("org.seleniumhq.selenium:selenium-remote-driver:3.141.59")
        testImplementation("org.jetbrains.kotlinx:lincheck:2.21")
        testImplementation("net.datafaker:datafaker:2.0.1")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
        testImplementation("io.rest-assured:rest-assured:${restAssuredVersion}")
        testImplementation("org.assertj:assertj-core:${assertjVersion}")
        testImplementation("org.mockito:mockito-core:${mockitoVersion}")
    }

    kapt {
        useBuildCache = true
        keepJavacAnnotationProcessors = true
        showProcessorStats = true
    }

    tasks {
        withType<JavaCompile> {
//            options.isIncremental = true
            options.encoding = "UTF-8"
        }
        withType<Test> {
            useJUnitPlatform()
//            testLogging {
//                events("passed", "skipped", "failed")
//            }
        }

        java {
            toolchain {
                languageVersion.set(JavaLanguageVersion.of(jdkVersion))
            }
        }
    }
}