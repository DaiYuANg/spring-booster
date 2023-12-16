import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import javax.inject.Inject

class WebJarPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        WebjarBuildTask.install(project)
    }
}

internal abstract class WebjarBuildTask @Inject constructor() {
//    init {
//        group = WEBJAR_TASK_GROUP
//        args.set(listOf("run", webjar.taskNames.build))
//        if (webjar.cache.enabled) {
//            setupCache()
//        }
//    }

    private fun setupCache() {
//        webjar.cache.src
//            .map { project.projectDir.resolve(it) }
//            .forEach {
//                if (it.isDirectory) {
//                    inputs.dir(it)
//                } else if (it.isFile) {
//                    inputs.file(it)
//                }
//            }
//        inputs.files("package.json", "package-lock.json", ".babelrc", ".tsconfig.json")
//        outputs.dir(webjar.distDir)
    }

    @TaskAction
    fun run() {
//        exec()
        copyToJarOutput()
    }

    private fun copyToJarOutput() {
//        val from = project.projectDir.resolve(webjar.distDir)
//        if (from.isDirectory) {
//            val to = project.buildDir
//                .resolve(webjar.outputDir)
//                .resolve(webjar.webjarDir)
//            to.mkdirs()
//            from.copyRecursively(to, true)
//        }
    }

    companion object {
        fun install(project: Project) {
//            val taskProvider = project.tasks.register(WEBJAR_BUILD_TASK, WebjarBuildTask::class.java, webjar)
//            taskProvider.configure { it.dependsOn(WEBJAR_INSTALL_TASK) }
//            if (!isWebjarSkipped(project)) {
//                project.tasks.named(PROCESS_RESOURCES_TASK_NAME).configure {
//                    it.dependsOn(taskProvider)
//                }
        }
    }
}
