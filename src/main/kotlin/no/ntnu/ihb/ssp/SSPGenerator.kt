package no.ntnu.ihb.ssp

import picocli.CommandLine
import java.io.File
import javax.script.ScriptEngineManager

@CommandLine.Command
class SSPGenerator : Runnable {

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

        val imports = """
            import no.ntnu.ihb.ssp.cli.*
        """.trimIndent()

        ScriptEngineManager().getEngineByExtension("kts").apply {
            val scriptContent = scriptFile.readLines().toMutableList()
            val insertionPoint = if (scriptContent[0].startsWith("#!")) 1 else 0
            scriptContent.add(insertionPoint, imports)
            eval(scriptContent.joinToString("\n"))
        }

    }

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CommandLine(SSPGenerator()).execute(*args)
        }

    }

}
