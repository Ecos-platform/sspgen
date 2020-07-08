package no.ntnu.ihb.sspgen

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.net.URL

open class SSPGenPluginExtension {

    var outputDir: String? = null
    var urls = mutableListOf<String>()
    var files = mutableListOf<String>()

}

class SSPGenPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("sspgen", SSPGenPluginExtension::class.java).also { ext ->

            val task = project.task("invoke")
            task.group = "sspgen"
            task.doLast {
                val outputDir: File? = ext.outputDir?.let { File(it) }

                ext.urls.map { URL(it) }.forEach { url ->
                    println("Downloading sspgen-definitions '$it'")
                    evaluateScript(url.openStream(), outputDir)
                }
                ext.files.map { File(it) }.forEach { file ->
                    println("Downloading sspgen-definitions '$it'")
                    evaluateScript(file.inputStream(), outputDir)
                }
            }

        }
    }

}
