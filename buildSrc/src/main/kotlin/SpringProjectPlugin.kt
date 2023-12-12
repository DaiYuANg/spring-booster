import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.DuplicatesStrategy
import org.gradle.jvm.tasks.Jar
import org.springframework.boot.gradle.plugin.SpringBootPlugin

class SpringProjectPlugin : Plugin<Project> {

    private val springBootGroup = "org.springframework.boot"

    private val springBootDependencies = mapOf(
        DependenciesDeclaration.IMPLEMENTATION to "spring-boot-starter",
        DependenciesDeclaration.IMPLEMENTATION to "spring-boot-starter-json",
        DependenciesDeclaration.IMPLEMENTATION to "spring-boot-starter-aop",
        DependenciesDeclaration.IMPLEMENTATION to "spring-boot-starter-actuator",
        DependenciesDeclaration.ANNOTATION_PROCESSOR to "spring-boot-configuration-processor",
        DependenciesDeclaration.TEST_IMPLEMENTATION to "spring-boot-starter-test"
    )

    override fun apply(project: Project) {
        // 应用 Spring Boot 插件
        project.pluginManager.apply(SpringBootPlugin::class.java)

        // 应用 Dependency Management 插件
        project.extensions.configure(DependencyManagementExtension::class.java) {
            imports { mavenBom(SpringBootPlugin.BOM_COORDINATES) }
        }

        // 配置 compileOnly 配置
        project.configurations.create("compileOnly")
        project.configurations.getByName("compileOnly")
            .extendsFrom(project.configurations.getByName("annotationProcessor"))

        springBootDependencies.forEach { (t, u) ->
            project.dependencies.add(
                t, "$springBootGroup:$u"
            )
        }

        // 配置 Jar 任务
        project.tasks.withType(Jar::class.java) {
            enabled = true
            duplicatesStrategy = DuplicatesStrategy.INCLUDE
        }
    }
}