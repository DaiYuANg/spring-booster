group = "org.toolkit.spring.boot.starter.vertx"
version = "1.0-SNAPSHOT"


dependencies {
    val vertxVersion: String by project
    implementation("io.vertx:vertx-core:$vertxVersion")
    compileOnly("io.vertx:vertx-web-client:$vertxVersion")
    compileOnly("io.vertx:vertx-hazelcast:$vertxVersion")
    compileOnly("io.vertx:vertx-web:$vertxVersion")
    testImplementation("io.vertx:vertx-core:$vertxVersion")
    testImplementation("io.vertx:vertx-web-client:$vertxVersion")
    testImplementation("io.vertx:vertx-hazelcast:$vertxVersion")
    testImplementation("io.vertx:vertx-web:$vertxVersion")
}

