plugins { `spring-boot-project` }

group = "org.toolkit.spring.boot.devservice"

version = "1.0-SNAPSHOT"

dependencies {
  implementation(libs.progressbar)
  implementation(libs.javaDockerClientCore)
  implementation(libs.javaDockerClientHttpClient)
  implementation(libs.apacheHttpClient)
}
