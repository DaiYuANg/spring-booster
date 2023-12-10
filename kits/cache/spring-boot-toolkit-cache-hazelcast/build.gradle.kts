group = "org.toolkit.spring.boot.cache.hazelcast"
version = "1.0-SNAPSHOT"


dependencies {
    val hazelcastVersion = "5.3.6"
    implementation("com.hazelcast:hazelcast:$hazelcastVersion")
    implementation("com.hazelcast:hazelcast-spring:$hazelcastVersion")
}
