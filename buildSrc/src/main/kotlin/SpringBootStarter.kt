import org.gradle.api.Plugin
import org.gradle.api.Project

class SpringBootStarter : Plugin<Project> {
    private val springBootGroup = "org.springframework.boot"

    override fun apply(target: Project) {
        commonDependencies(target)
        commonPlugins(target)
        target.configurations.all {
            resolutionStrategy.dependencySubstitution {
                substitute(module("org.springframework.boot:spring-boot-dependencies"))
                    .apply {
                        target.dependencies.platform("org.springframework.boot:spring-boot-dependencies:2.6.3")
                    }
            }
        }

//        target.dependencies.apply {
//            configure<DependencyManagement> {
////                imports {
////                    mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
////                }
//            }
//        }
//        target.dependencies.apply {
//            // 在 buildSrc 中配置 DependencyManagementExtension
//            configure<DependencyManagement> {
////                imports {
////                    mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
////                }
//            }
//        }
//        target.the<DependencyManagementExtension>().apply {
//            imports { mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES) }
//        }
    }

    private fun commonDependencies(target: Project) {
        target.dependencies.add(springBootGroup, "spring-boot-starter")
    }

    private fun commonPlugins(target: Project) {
        target.plugins.apply("org.springframework.boot")
    }

    companion object Factory {
        fun create(): SpringBootStarter = SpringBootStarter()
    }
}