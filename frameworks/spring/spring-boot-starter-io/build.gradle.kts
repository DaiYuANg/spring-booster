dependencies {
    val expiringmapVersion: String by project
    api(projects.libs.io)
    api(projects.libs.helpers)
    api(projects.frameworks.spring.springBootStarterAsync)
    implementation("net.jodah:expiringmap:$expiringmapVersion")
}
