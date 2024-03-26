dependencies {
  compileOnly(projects.booster.springBoostMappingCore)
  implementation(libs.springBootJPA)
  compileOnly("com.querydsl:querydsl-apt:${libs.versions.queryDsl.get()}:jakarta")
  implementation("com.querydsl:querydsl-jpa:${libs.versions.queryDsl.get()}:jakarta")
  annotationProcessor("com.querydsl:querydsl-apt:${libs.versions.queryDsl.get()}:jakarta")
  implementation(libs.queryDslCore)
  implementation(libs.queryDslCollection)
  annotationProcessor(libs.jakartaPersistence)
}
