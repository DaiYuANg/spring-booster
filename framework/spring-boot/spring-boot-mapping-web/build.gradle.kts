plugins { `kotlin-support` }

group = "org.toolkit.spring.boot.mapping.web"

version = "1.0-SNAPSHOT"

dependencies {
  //  implementation(projects.kits.mapping.springBootToolkitMappingCore)
  compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("net.bytebuddy:byte-buddy:1.14.10")
  //  api(projects.kits.mapping.springBootMappingBase)
}