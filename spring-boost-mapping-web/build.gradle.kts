dependencies {
//  implementation(projects.framework.springBoot.springBootMappingCore)
//  implementation(projects.framework.springBoot.springBootMappingBase)
  compileOnly("org.springframework.boot:spring-boot-starter-data-jpa")
  api(libs.bytebuddy)
}
