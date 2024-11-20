dependencies {
  implementation(libs.hutoolCore)
  implementation(libs.snowflake4j)
  implementation(libs.agrona)
  compileOnly(libs.jakartaPersistence)
  compileOnly(projects.booster.springBoostCore)
  api(libs.springBootJdbc)
  api(libs.springBootDataEnvers)
  api(libs.springBootJPA)
  annotationProcessor(libs.hibernatejpaModelGen)

  val queryDSLApt = variantOf(libs.queryDslApt) { classifier(JAKARTA) }
  compileOnly(queryDSLApt)
  annotationProcessor(queryDSLApt)
  implementation(libs.queryDslJPA)
  implementation(libs.queryDslCore)
  annotationProcessor(libs.jakartaPersistence)
}
