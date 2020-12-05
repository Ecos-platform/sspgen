package no.ntnu.ihb.sspgen.dsl

import java.io.File
import java.io.FileInputStream
import java.net.URL


interface Resource {

    val name: String
    fun readBytes(): ByteArray

}

class FileResource(
    private val file: File
) : Resource {

    override val name: String
        get() = file.name

    override fun readBytes(): ByteArray {
        return FileInputStream(file).buffered().use {
            it.readBytes()
        }
    }

}

class UrlResource(
    private val url: URL
) : Resource {

    override val name: String
        get() {
            val path = url.path
            return path.substring(path.lastIndexOf('/') + 1)
        }

    override fun readBytes(): ByteArray {
        return url.openStream().buffered().use {
            it.readBytes()
        }
    }

}
