package no.ntnu.ihb.sspgen

import no.ntnu.ihb.sspgen.dsl.SspContext
import no.ntnu.ihb.sspgen.schema.SystemStructureDescription
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.xml.bind.JAXB

internal fun String.extractElementAndConnectorNames(): Pair<String, String> {
    val i = indexOf('.')
    if (i == -1) throw IllegalArgumentException()
    val elementName = substring(0, i)
    val connectorName = substring(i + 1)
    return elementName to connectorName
}

interface Resource {

    val name: String

    fun readBytes(): ByteArray

}

class FileResource(
    val file: File
) : Resource {

    override val name: String
        get() = file.name

    override fun readBytes(): ByteArray {
        return file.readBytes()
    }

}

class UrlResource(
    val url: URL
) : Resource {

    override val name: String
        get() {
            val path = url.path
            return path.substring(path.lastIndexOf('/') + 1)
        }

    override fun readBytes(): ByteArray {
        return url.openStream().use {
            it.readBytes()
        }
    }

}

fun SystemStructureDescription.toXML(): String {
    val bos = ByteArrayOutputStream()
    JAXB.marshal(this, bos)
    var xml = bos.toString()
    xml = xml.replace("ns2:", "ssd:")
    xml = xml.replace("ns3:", "ssc:")
    xml = xml.replace("ns4:", "ssv:")
    xml = xml.replace("xmlns:ns2", "xmlns:ssd")
    xml = xml.replace("xmlns:ns3", "xmlns:ssc")
    xml = xml.replace("xmlns:ns4", "xmlns:ssv")
    xml = xml.replace("xmlns:ns5", "xmlns:ssb")

    xml = xml.replace("<any>", "")
    xml = xml.replace("</any>", "")
    xml = xml.replace("&lt;", "<")
    xml = xml.replace("/&gt;", "/>")
    xml = xml.replace("&gt;", ">")

    return xml
}

fun SspContext.createSSP(outputDir: File? = null) {

    val fileName = if (archiveName.endsWith(".ssp")) {
        archiveName
    } else {
        "$archiveName.ssp"
    }

    val sspArchive = if (outputDir == null) {
        File(fileName)
    } else {
        outputDir.mkdirs()
        File(outputDir, fileName)
    }

    ZipOutputStream(BufferedOutputStream(FileOutputStream(sspArchive))).use { zos ->

        zos.putNextEntry(ZipEntry("SystemStructure.ssd"))
        zos.write(ssd.toXML().toByteArray())
        zos.closeEntry()

        if (resources.isNotEmpty()) {
            zos.putNextEntry(ZipEntry("resources/"))
            resources.forEach {
                zos.putNextEntry(ZipEntry("resources/${it.name}"))
                zos.write(it.readBytes())
                zos.closeEntry()
            }
            zos.closeEntry()
        }

    }

}

