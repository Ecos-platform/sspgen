package no.ntnu.ihb.sspgen

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.io.File

internal class CLITest {

    @Test
    fun testCLI() {

        val outputDir = File("build/sspGen").apply {
            deleteRecursively()
        }

        val scriptFile = File(CLITest::class.java.classLoader.getResource("TestSsdGen.kts")!!.file)

        SSPGenerator.main(
            arrayOf(
                "-out", outputDir.absolutePath,
                scriptFile.absolutePath
            )
        )

        Assertions.assertEquals(1, outputDir.listFiles()?.size ?: 0)

    }

}
