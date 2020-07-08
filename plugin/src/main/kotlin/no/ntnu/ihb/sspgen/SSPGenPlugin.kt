package no.ntnu.ihb.sspgen

import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.net.URL

open class SSPGenPluginExtension {

    val outputDir: String? = null
    val urls = mutableListOf<String>()
    val files = mutableListOf<String>()

}

class SSPGenPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("sspgen", SSPGenPluginExtension::class.java).also { ext ->

            val outputDir: File? = ext.outputDir?.let { File(it) }

            ext.urls.map { URL(it) }.forEach { url ->
                evaluateScript(url.openStream(), outputDir)
            }
            ext.files.map { File(it) }.forEach { file ->
                evaluateScript(file.inputStream(), outputDir)
            }

        }
    }

}
