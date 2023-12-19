group = "org.toolkit.minio"

version = "1.0-SNAPSHOT"

dependencies {
    api(libs.tikaCore)
    api(libs.tikaParsers)
    api(libs.minio)
    testImplementation(libs.testcontainersMinio)
}
