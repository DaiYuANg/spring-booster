val aspectjVersion: String by project

dependencies {
  api("org.springframework.boot:spring-boot-starter-artemis")
  implementation("org.apache.activemq:artemis-jms-server:2.29.0")
  api("org.apache.activemq:activemq-kahadb-store")
  api("org.apache.activemq:activemq-broker")
  api("org.apache.activemq:activemq-pool")
  implementation("org.ehcache:ehcache:3.10.8")
  implementation("org.aspectj:aspectjrt:${aspectjVersion}")
}