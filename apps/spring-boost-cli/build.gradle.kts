plugins {
  application
  alias(libs.plugins.graalvmNative)
}

dependencyManagement { imports { mavenBom("${libs.springShellBom.get()}") } }

repositories { maven { url = uri("https://repo.gradle.org/gradle/libs-releases") } }

val mainClassPath = "org.spring.boost.cli.SpringBoostCLI"

dependencies {
  implementation(projects.booster.springBoostMutiny)
  implementation(libs.mysqlDriver)
  implementation(libs.javapoet)
  implementation(libs.jakartaPersistence)
  implementation(libs.commonsDBUtil)
  implementation(libs.apacheCommonIO)
  implementation(libs.jansi)
  implementation(libs.jlineNative)
  implementation(libs.springShellStarter)
  implementation(libs.springBootJdbc)
  implementation(libs.sqliteDriver)
  implementation(libs.postgresqlDriver)
  implementation(libs.mavenModel)
  implementation(libs.springBootFreemarker)
  implementation(libs.gradleToolingAPI)
  testImplementation(libs.springBootJdbc)
  developmentOnly(libs.springBootDevtools)
  implementation(libs.springBootLogging)
  testImplementation(libs.testcontainersMysql)
  developmentOnly(libs.springBootDockerCompose)
  implementation(libs.schemacrawler)
  implementation(libs.schemacrawlerMySQL)
  implementation(libs.schemacrawlerSqlite)
  implementation(libs.schemacrawlerSqlServer)
  implementation(libs.schemacrawlerPostgreSQL)
  implementation(libs.logbackCore)
  implementation(libs.logbackClassic)
  implementation(libs.mutiny)
  implementation(libs.javaparser.core)
  compileOnly(libs.immutables.value)
  annotationProcessor(libs.immutables.value)
}

application {
  mainClass = mainClassPath
  applicationDefaultJvmArgs = listOf(
    "-XX:+UseZGC",
    "-XX:+ZGenerational",
    "-XX:+AlwaysPreTouch"
  )
}

graalvmNative {
  metadataRepository { enabled = true }
  binaries {
    named("main") {
      mainClass.set(mainClassPath)
      sharedLibrary.set(false)
      quickBuild.set(false)
      buildArgs.add("-H:+UnlockExperimentalVMOptions")
    }
  }
}