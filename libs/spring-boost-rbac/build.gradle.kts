group = "org.spring.boost.rbac"

dependencies {
  api(projects.libs.springBoostJpa)
  implementation(libs.hutool.core)
  val queryDSLApt = variantOf(libs.querydsl.apt) { classifier(JAKARTA) }
  compileOnly(queryDSLApt)
  compileOnly(projects.libs.springBoostAuthentication)
  annotationProcessor(queryDSLApt)
  annotationProcessor(libs.jakarta.persistence)
}
