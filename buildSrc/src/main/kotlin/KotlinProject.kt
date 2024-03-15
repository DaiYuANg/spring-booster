
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.allopen.gradle.AllOpenGradleSubplugin
import org.jetbrains.kotlin.allopen.gradle.SpringGradleSubplugin
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KotlinPluginWrapper
import org.jetbrains.kotlin.lombok.gradle.LombokSubplugin
import org.jetbrains.kotlinx.serialization.gradle.SerializationGradleSubplugin

class KotlinProject : Plugin<Project> {
  override fun apply(target: Project) {
    val rootLib = rootLibs(target)
    target.apply<KotlinPluginWrapper>()
    target.apply<SpringGradleSubplugin>()
    target.apply<LombokSubplugin>()
    target.apply<AllOpenGradleSubplugin>()
//    target.apply<Kapt3GradleSubplugin>()
    target.apply<SerializationGradleSubplugin>()

    target.dependencies {
      add(IMPLEMENTATION, rootLib.kotlinxCoroutinesCore)
    }

    target.extensions.configure<KotlinJvmProjectExtension> {
      jvmToolchain(jdkVersion = rootLib.versions.jdkVersion.get().toInt())
      compilerOptions {
        freeCompilerArgs = listOf("-Xjvm-default=all")
      }
    }

//    target.extensions.configure<KaptExtension> {
//      keepJavacAnnotationProcessors = true
//    }
  }
}