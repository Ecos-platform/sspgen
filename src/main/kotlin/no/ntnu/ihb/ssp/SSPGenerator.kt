package no.ntnu.ihb.ssp

import no.ntnu.ihb.ssp.cli.SspContext
import picocli.CommandLine
import java.io.File
import javax.script.ScriptEngineManager

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
        description = ["Path to Vico script"]
    )
    private lateinit var scriptFile: File

    override fun run() {

        require(scriptFile.exists())
        require(scriptFile.extension == "kts")

        System.setProperty("idea.io.use.nio2", "true")

        val import = "import no.ntnu.ihb.ssp.cli.*"

        ScriptEngineManager().getEngineByExtension("kts").apply {
            val scriptContent = scriptFile.readLines().toMutableList()
            if (!scriptContent.contains(import)) {
                val insertionPoint = if (scriptContent[0].startsWith("#!")) 1 else 0
                scriptContent.add(insertionPoint, import)
            }
            (eval(scriptContent.joinToString("\n")) as SspContext).apply {
                createSSP(outputDir)
            }
        }

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CommandLine(SSPGenerator()).execute(*args)
        }

    }

}
