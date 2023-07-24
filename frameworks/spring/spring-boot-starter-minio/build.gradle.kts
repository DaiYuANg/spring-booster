dependencies {
    val expiringmapVersion: String by project
    val testContainersVersion: String by project
    api(projects.libs.helpers)
    api("io.minio:minio:8.5.4")
    api(projects.libs.thready)
    implementation("net.jodah:expiringmap:$expiringmapVersion")
    testImplementation("io.minio:minio:8.5.4")
    testImplementation("net.jodah:expiringmap:$expiringmapVersion")
}
