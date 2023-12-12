import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.quality.CheckstylePlugin
import org.gradle.api.tasks.compile.JavaCompile
import org.gradle.kotlin.dsl.withType
import org.gradle.testing.jacoco.plugins.JacocoPlugin
import org.gradle.testing.jacoco.tasks.JacocoReport

class FormatterPlugin : Plugin<Project> {
    private val pluginList = listOf(
        SpotlessPlugin::class.java,
        JacocoPlugin::class.java,
        CheckstylePlugin::class.java,
        SpotlessPlugin::class.java
    )

    override fun apply(project: Project) {
        pluginList.forEach { project.plugins.apply(it) }

        project.extensions.configure(SpotlessExtension::class.java) {
            format("misc") {
                target("*.md", ".gitignore", "**/*.java")
                indentWithTabs() // or spaces. Takes an integer argument if you don't like 4
                endWithNewline()
            }
            java {
                target("**/*.java")
                importOrder()
                palantirJavaFormat()
                indentWithTabs()
                removeUnusedImports()
                formatAnnotations()
                licenseHeader("/* (C)\$YEAR*/")
            }

            kotlinGradle {
                target("**/*.gradle.kts") // default target for kotlinGradle
                ktfmt() // or ktfmt() or prettier()
            }
            kotlin {
                // by default the target is every '.kt' and '.kts` file in the java sourcesets
                ktfmt()    // has its own section below
                ktlint()   // has its own section below
//        diktat()   // has its own section below
//        prettier() // has its own section below

//        licenseHeader("/* (C)$YEAR */")
//        licenseHeader.set("/* (C)$YEAR */") // or licenseHeaderFile
            }
        }

        project.tasks.withType<JacocoReport> {
            reports {
                xml.required.set(false)
                csv.required.set(false)
                html.outputLocation.set(project.layout.buildDirectory.dir("jacocoHtml"))
            }
        }

        project.tasks.withType<JavaCompile> {
            dependsOn("spotlessApply")
        }
    }
}