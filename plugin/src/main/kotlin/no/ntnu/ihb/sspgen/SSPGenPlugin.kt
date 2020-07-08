package no.ntnu.ihb.sspgen

import org.gradle.api.Plugin
import org.gradle.api.Project

open class SSPGenPluginExtension {

    val urls = mutableListOf<String>()

}

class SSPGenPlugin : Plugin<Project> {

    override fun apply(project: Project) {
        val extension = project.extensions.create("sspgen", SSPGenPluginExtension::class.java)
    }

}
