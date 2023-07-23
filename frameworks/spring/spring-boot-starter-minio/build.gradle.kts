dependencies {
    val expiringmapVersion: String by project
    api(projects.libs.helpers)
    api("io.minio:minio:8.5.4")
    api(projects.libs.thready)
    implementation("net.jodah:expiringmap:$expiringmapVersion")
}
