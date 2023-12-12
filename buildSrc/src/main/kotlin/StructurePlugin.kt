
import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import java.io.FileOutputStream


class StructurePlugin : Plugin<Project> {
    override fun apply(project: Project) {
        val treeTask = project.tasks.register("tree", TreeTask::class.java) {
            outputFile = project.layout.buildDirectory.file("tree-output.txt") as RegularFileProperty
        }

        // Make "tree" task depend on the "build" task (or any other task you want)
        project.tasks.named("build").configure {
            dependsOn(treeTask)
        }
    }
}

open class TreeTask : DefaultTask() {

    @get:OutputFile
    var outputFile: RegularFileProperty = project.objects.fileProperty()

    @TaskAction
    fun generateTree() {
        val outputFilePath = outputFile.get().asFile.absolutePath

        // Execute the "tree" command and capture the output to the specified file
        project.exec {
            commandLine("tree", "-L", "20", "-I", "*git|*build*|*bin*")
            // Capture the standard output using a FileOutputStream
            standardOutput = FileOutputStream(outputFilePath)
        }
    }
}