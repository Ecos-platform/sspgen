package no.ntnu.ihb.sspgen

import picocli.CommandLine
import java.io.File

@CommandLine.Command
class SSPGenerator : Runnable {

    @CommandLine.Option(
        names = ["-out", "--outputDir"],
        description = ["Directory to save the generated .ssp file"]
    )
    private var outputDir: File? = null

    @CommandLine.Parameters(
        arity = "1",
        paramLabel = "SCRIPT",
        description = ["Path to the sspgen script"]
    )
    private lateinit var scriptFile: File

    override fun run() {

        require(scriptFile.exists())
        require(scriptFile.extension == "kts")
        evaluateScript(scriptFile.inputStream()).apply {
            createSSP(outputDir)
        }

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CommandLine(SSPGenerator()).execute(*args)
        }

    }

}
