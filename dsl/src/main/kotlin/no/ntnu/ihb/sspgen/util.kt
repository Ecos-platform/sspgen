package no.ntnu.ihb.sspgen

import no.ntnu.ihb.sspgen.dsl.SspContext
import no.ntnu.ihb.sspgen.schema.TConnectors
import no.ntnu.ihb.sspgen.schema.TParameter
import java.io.*
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.script.ScriptEngineManager
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
    private val file: File
) : Resource {

    override val name: String
        get() = file.name

    override fun readBytes(): ByteArray {
        return FileInputStream(file).buffered().use {
            readBytes()
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

fun SspContext.ssdXml(): String {

    var xml = ByteArrayOutputStream().apply {
        JAXB.marshal(ssd, this)
    }.toString()

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

    if (namespaces.isNotEmpty()) {
        val indexOf = xml.indexOf("xmlns")
        namespaces.forEach { namespace ->
            xml = xml.substring(0, indexOf) + "$namespace " + xml.substring(indexOf)
        }
    }

    return xml
}


internal fun TParameter.copy(): TParameter {
    fun TParameter.Integer.copy() = TParameter.Integer().also { p ->
        p.value = value
    }

    fun TParameter.Real.copy() = TParameter.Real().also { p ->
        p.value = value
        p.unit = unit
    }

    fun TParameter.String.copy() = TParameter.String().also { p ->
        p.value = value
    }

    fun TParameter.Enumeration.copy() = TParameter.Enumeration().also { p ->
        p.value = value
    }

    fun TParameter.Boolean.copy() = TParameter.Boolean().also { p ->
        p.isValue = isValue
    }

    fun TParameter.Binary.copy() = TParameter.Binary().also { p ->
        p.value = value.copyOf()
    }

    return TParameter().also { p ->
        p.name = name
        p.description = description
        p.integer = integer?.copy()
        p.real = real?.copy()
        p.string = string?.copy()
        p.boolean = boolean?.copy()
        p.enumeration = enumeration?.copy()
        p.binary = binary?.copy()
    }
}

internal fun TConnectors.Connector.typeName(): String {
    return when {
        integer != null -> "Integer"
        real != null -> "Real"
        string != null -> "String"
        boolean != null -> "Boolean"
        enumeration != null -> "Enumeration"
        binary != null -> "Binary"
        else -> throw IllegalArgumentException()
    }
}
