plugins{
    kotlin("jvm")
    `java-gradle-plugin`
}

group = "org.neccar.nava.gradle.plugin"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))
    implementation(projects.tools.novaCore)
    implementation(gradleApi())
    testImplementation(gradleTestKit())
}
//
//gradlePlugin {
//    plugins {
//        create(property("ID").toString()) {
//            id = property("org.neccar.nava.gradle.plugin").toString()
//            implementationClass = property("IMPLEMENTATION_CLASS").toString()
//            version = property("VERSION").toString()
//            description = property("DESCRIPTION").toString()
//            displayName = property("DISPLAY_NAME").toString()
//            tags.set(listOf("plugin", "gradle", "sample", "template"))
//        }
//    }
//}

//gradlePlugin {
//    website.set(property("WEBSITE").toString())
//    vcsUrl.set(property("VCS_URL").toString())
//}
