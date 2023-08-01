val aspectjVersion: String by project

dependencies {
  implementation("jakarta.validation:jakarta.validation-api:3.0.2")
  implementation("org.aspectj:aspectjrt:${aspectjVersion}")
}
