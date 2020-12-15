package no.ntnu.ihb.sspgen.dsl.resources

import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.net.URL


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
