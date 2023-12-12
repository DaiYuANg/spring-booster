import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.allopen.gradle.SpringGradleSubplugin
import org.jetbrains.kotlin.gradle.plugin.KotlinPlatformJvmPlugin
import org.jetbrains.kotlin.lombok.gradle.LombokSubplugin

class KotlinProjectPlugin :Plugin<Project> {

    private val kotlinPlugins = listOf(
        KotlinPlatformJvmPlugin::class.java,
        LombokSubplugin::class.java,
        SpringGradleSubplugin::class.java,
    )
    override fun apply(target: Project) {
        TODO("Not yet implemented")
    }
}