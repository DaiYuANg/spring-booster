import org.gradle.api.Plugin
import org.gradle.api.Project

class PicoCliProjectPlugin : Plugin<Project> {

    private val picocliGroup = "info.picocli"

    private val picocliDependencies = mapOf(
        DependenciesDeclaration.IMPLEMENTATION to "picocli",
        DependenciesDeclaration.IMPLEMENTATION to "picocli-codegen",
        DependenciesDeclaration.IMPLEMENTATION to "picocli-shell-jline3",
        DependenciesDeclaration.ANNOTATION_PROCESSOR to "picocli-codegen",
    )

    override fun apply(project: Project) {
        picocliDependencies.forEach{ (key, value) ->
            project.dependencies.add(key,"$picocliGroup:$value:${Dependencies.PICOCLI_VERSION}")
        }
    }
}