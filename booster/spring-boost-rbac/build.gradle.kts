group = "org.spring.boost.rbac"

dependencies {
  api(projects.booster.springBoostJpa)
  implementation(libs.hutoolCore)
  val queryDSLApt = variantOf(libs.queryDslApt) { classifier(JAKARTA) }
  compileOnly(queryDSLApt)
  annotationProcessor(queryDSLApt)
  annotationProcessor(libs.jakartaPersistence)
}
