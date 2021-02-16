package no.ntnu.ihb.sspgen.dsl.resources

import java.io.*
import java.lang.Exception
import java.lang.IllegalStateException
import java.net.URL
import java.nio.file.Files


sealed class Resource : Closeable {

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

    override fun close() {}

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

    override fun close() {}

}

class PythonfmuResource(
    source: File,
    projectFiles: List<File> = emptyList()
) : Resource() {

    override val name: String
        get() = fmu.nameWithoutExtension

    private val tempDir = Files.createTempDirectory("pythonfmu").toFile()
    private val fmu: File by lazy { tempDir.listFiles()?.first() ?: throw IllegalStateException() }

    init {
        println("Building FMU from python sources..")
        val tempDir = Files.createTempDirectory("pythonfmu").toFile()
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
            Runtime.getRuntime().exec(cmd.toTypedArray())
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

    override fun close() {
        tempDir.deleteRecursively()
    }

}
