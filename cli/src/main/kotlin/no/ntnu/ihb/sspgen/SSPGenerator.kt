package no.ntnu.ihb.sspgen

import picocli.CommandLine
import java.io.File

@CommandLine.Command(versionProvider = VersionProvider::class)
class SSPGenerator : Runnable {

    @CommandLine.Option(names = ["-h", "--help"], usageHelp = true, description = ["Display a help message"])
    private var helpRequested: Boolean = false

    @CommandLine.Option(
        names = ["-v", "--version"],
        versionHelp = true,
        description = ["Print the version of this application."]
    )
    private var showVersion = false

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
