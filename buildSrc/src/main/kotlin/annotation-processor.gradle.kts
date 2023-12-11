plugins{
    `java-library`
}

dependencies{
    compileOnly("com.google.auto.service:auto-service:1.1.1")
    compileOnly("net.ltgt.gradle.incap:incap-processor:1.0.0")
    annotationProcessor("com.google.auto.service:auto-service:1.1.1")
    annotationProcessor("com.google.auto:auto-common:1.2.2")
    annotationProcessor("net.ltgt.gradle.incap:incap-processor:1.0.0")
    testImplementation("net.ltgt.gradle.incap:incap:1.0.0")
}