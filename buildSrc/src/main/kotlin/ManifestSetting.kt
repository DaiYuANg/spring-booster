import com.coditory.gradle.manifest.ManifestPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class ManifestSetting : Plugin<Project> {
  override fun apply(target: Project) {
    target.apply<ManifestPlugin>()
  }
}