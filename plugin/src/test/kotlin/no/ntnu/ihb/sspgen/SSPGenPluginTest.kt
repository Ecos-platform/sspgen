package no.ntnu.ihb.sspgen

import org.gradle.testfixtures.ProjectBuilder
import org.junit.jupiter.api.Test

class SSPGenPluginTest {

    @Test
    fun sspgenPluginAddsTaskToProject() {
        val project = ProjectBuilder.builder().build()
        project.pluginManager.apply("no.ntnu.ihb.sspgen")
    }

}
