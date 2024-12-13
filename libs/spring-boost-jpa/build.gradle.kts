dependencies {
  implementation(libs.hutool.core)
  implementation(libs.agrona)
  compileOnly(libs.jakarta.persistence)
  compileOnly(projects.libs.springBoostCore)
  api(libs.spring.boot.starter.jdbc)
  api(libs.spring.data.envers)
  api(libs.spring.boot.starter.data.jpa)
  annotationProcessor(libs.hibernate.jpamodelgen)

  val queryDSLApt = variantOf(libs.querydsl.apt) { classifier(JAKARTA) }
  compileOnly(queryDSLApt)
  annotationProcessor(queryDSLApt)
  implementation(libs.querydsl.jpa)
  implementation(libs.querydsl.core)
  annotationProcessor(libs.jakarta.persistence)
}
