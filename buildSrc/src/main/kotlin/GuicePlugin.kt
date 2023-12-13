import gradle.kotlin.dsl.accessors._47a9ee0b77daf1d537dea5d39cd4702e.implementation
import gradle.kotlin.dsl.accessors._47a9ee0b77daf1d537dea5d39cd4702e.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project

class GuicePlugin : Plugin<Project> {

    private val guiceExtensionGroup = "com.google.inject.extensions"

    private val extensionDependencies = listOf(
        "guice-assistedinject",
        "guice-jmx",
        "guice-throwingproviders"
    )

    override fun apply(project: Project) {
        project.dependencies.implementation("com.google.inject:guice:${Dependencies.GUICE_VERSION}")
        extensionDependencies.forEach { project.dependencies.implementation("$guiceExtensionGroup:$it:${Dependencies.GUICE_VERSION}") }
        project.dependencies.testImplementation("com.google.inject.extensions:guice-testlib:${Dependencies.GUICE_VERSION}")
    }
}