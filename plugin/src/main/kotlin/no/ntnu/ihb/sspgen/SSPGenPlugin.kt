package no.ntnu.ihb.sspgen

import no.ntnu.ihb.sspgen.dsl.SspContext
import org.gradle.api.Plugin
import org.gradle.api.Project
import java.io.File
import java.io.InputStream
import java.net.URI
import java.net.URL
import javax.script.ScriptEngineManager

open class SSPGenPluginExtension {

    var outputDir: String? = null
    var urls = mutableListOf<String>()
    var files = mutableListOf<String>()

}

class SSPGenPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        project.extensions.create("sspgen", SSPGenPluginExtension::class.java).also { ext ->

            project.task("invoke").apply {

                group = "sspgen"

                doLast {
                    val outputDir: File? = ext.outputDir?.let { File(it) }

                    ext.urls.map { URL(it) }.forEach { url ->
                        println("Building sspgen-definition from url: '$url'")
                        evaluateScript(url.openStream()).apply {
                            build(outputDir)
                        }
                    }
                    ext.files.map { File(it) }.forEach { file ->
                        println("Building sspgen-definition from file: '$file'")
                        evaluateScript(file.inputStream()).apply {
                            build(outputDir)
                        }
                    }
                }

            }

        }

        project.repositories.maven {
            it.url= URI("https://dl.bintray.com/ntnu-ihb/mvn")
        }

    }

}

private fun evaluateScript(inputStream: InputStream): SspContext {

    val readScript = inputStream.bufferedReader().use {
        it.readLines()
    }

    System.setProperty("idea.io.use.nio2", "true")

    val import = "import no.ntnu.ihb.sspgen.dsl.*"

    ScriptEngineManager().getEngineByExtension("kts").apply {
        val scriptContent = readScript.toMutableList()
        if (!scriptContent.contains(import)) {
            val insertionPoint = if (scriptContent[0].startsWith("#!")) 1 else 0
            scriptContent.add(insertionPoint, import)
        }
        return eval(scriptContent.joinToString("\n")) as SspContext
    }

}

