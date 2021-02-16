package no.ntnu.ihb.sspgen.dsl.resources

import java.io.*
import java.lang.Exception
import java.lang.RuntimeException
import java.net.URL
import java.nio.file.Files


sealed class Resource {

    abstract val name: String
    abstract fun readBytes(): ByteArray
    abstract fun openStream(): InputStream

}

class FileResource(
    private val file: File
) : Resource() {

    override val name: String
        get() = file.name

    override fun openStream(): InputStream {
        return FileInputStream(file)
    }

    override fun readBytes(): ByteArray {
        return openStream().buffered().use {
            it.readBytes()
        }
    }

}

class UrlResource(
    private val url: URL
) : Resource() {

    override val name: String
        get() {
            val path = url.path
            return path.substring(path.lastIndexOf('/') + 1)
        }

    override fun openStream(): InputStream {
        return url.openStream()
    }

    override fun readBytes(): ByteArray {
        return openStream().buffered().use {
            it.readBytes()
        }
    }

}

class PythonfmuResource(
    source: File,
    projectFiles: List<File> = emptyList()
) : Resource() {

    override val name: String
        get() = fmu.name

    private lateinit var fmu: File

    init {

        try {
            Runtime.getRuntime().exec("pythonfmu")
        } catch (ex: Exception) {
            throw RuntimeException("Cannot handle pythonfmu resource as pythonfmu is not available..")
        }

        println("Building FMU from python sources..")
        val tempDir = Files.createTempDirectory("pythonfmu").toFile().apply {
            Runtime.getRuntime().addShutdownHook(Thread {
                this.deleteRecursively()
            })
        }
        val cmd = mutableListOf<String>(
            "pythonfmu",
            "build",
            "-d",
            tempDir.absolutePath,
            "-f",
            source.absolutePath
        )
        if (projectFiles.isNotEmpty()) {
            projectFiles.map { it.absolutePath }.forEach(cmd::add)
        }

        try {
            val status = Runtime.getRuntime().exec(cmd.toTypedArray()).waitFor()
            fmu = tempDir.listFiles()?.first() ?: throw IllegalStateException()
            println("Building FMU from python sources done with status ${status}..")
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

    }

    override fun readBytes(): ByteArray {
        return openStream().buffered().readBytes()
    }

    override fun openStream(): InputStream {
        return FileInputStream(fmu)
    }

}
