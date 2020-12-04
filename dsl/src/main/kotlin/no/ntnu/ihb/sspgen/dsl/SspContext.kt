package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionParser
import no.ntnu.ihb.sspgen.schema.SystemStructureDescription
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.net.URL
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.xml.bind.JAXB


fun ssp(archiveName: String, ctx: SspContext.() -> Unit): SspContext {
    return SspContext(archiveName).apply(ctx)
}

class SspContext(
    private val archiveName: String
) {

    private val ssd: SystemStructureDescription = SystemStructureDescription()
    private val resources = mutableListOf<Resource>()
    private val namespaces = mutableListOf<String>()
    private val modelDescriptions = mutableListOf<ModelDescription>()

    fun ssd(name: String, ctx: SsdContext.() -> Unit) {
        ssd.name = name
        ssd.version = "1.0"
        ssd.generationTool = "sspgen"
        SsdContext(ssd).apply(ctx)
    }

    fun namespaces(ctx: NamespaceContext.() -> Unit) {
        NamespaceContext().apply(ctx)
    }

    fun resources(ctx: ResourcesContext.() -> Unit) {
        ResourcesContext().apply(ctx)
    }

    inner class NamespaceContext {

        fun namespace(namespace: String, uri: String) {
            namespaces.add("xmlns:$namespace=\"$uri\"")
        }

    }

    inner class ResourcesContext {

        fun file(filePath: String) {
            val file = File(filePath)
            if (!file.exists()) throw NoSuchFileException(file)
            FileResource(file).also { resource ->
                resources.add(resource)
            }
        }

        fun url(urlString: String) {
            UrlResource(URL(urlString)).also { resource ->
                resources.add(resource)
            }
        }

    }

    fun ssdXml(): String {

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

    private fun retrieveModelDescriptions(): Map<String, ModelDescription> {
        val modelDescriptions = mutableMapOf<String, ModelDescription>()
        resources.forEach { resource ->
            if (resource.name.endsWith(".fmu")) {
                val md = ByteArrayInputStream(resource.readBytes()).use {
                    ModelDescriptionParser.parse(it)
                }
                modelDescriptions[resource.name] = md
            }
        }
        return modelDescriptions
    }

    internal fun validate() {
        val modelDescriptions = retrieveModelDescriptions()

        ssd.system.elements.component.forEach { component ->

            val fmuName = component.source.replace(SOURCE_PREFIX, "")
            val md = modelDescriptions[fmuName]
                ?: throw IllegalStateException("No modelDescription affiliated with $fmuName!")

            component.connectors.connector.forEach { connector ->
                val name = connector.name
                when (connector.typeName()) {
                    "Integer" -> md.modelVariables.integers.find { it.name == name }
                        ?: throw IllegalStateException("No Integer variable named $name found within the modelDescription of FMU named $fmuName!")
                    "Real" -> md.modelVariables.reals.find { it.name == name }
                        ?: throw IllegalStateException("No Real variable named $name found within the modelDescription of FMU named $fmuName!")
                    "Boolean" -> md.modelVariables.booleans.find { it.name == name }
                        ?: throw IllegalStateException("No Boolean variable named $name found within the modelDescription of FMU named $fmuName!")
                    "String" -> md.modelVariables.strings.find { it.name == name }
                        ?: throw IllegalStateException("No String variable named $name found within the modelDescription of FMU named $fmuName!")
                    "Enumeration" -> md.modelVariables.enumerations.find { it.name == name }
                        ?: throw IllegalStateException("No Enumeration variable named $name found within the modelDescription of FMU named $fmuName!")
                }
            }

        }

        fun build(outputDir: File? = null) {

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

            ZipOutputStream(FileOutputStream(sspArchive).buffered()).use { zos ->

                zos.putNextEntry(ZipEntry("SystemStructure.ssd"))
                zos.write(ssdXml().toByteArray())
                zos.closeEntry()

                if (resources.isNotEmpty()) {
                    zos.putNextEntry(ZipEntry(SOURCE_PREFIX))
                    resources.forEach {
                        zos.putNextEntry(ZipEntry("SOURCE_PREFIX${it.name}"))
                        zos.write(it.readBytes())
                        zos.closeEntry()
                    }
                    zos.closeEntry()
                }

            }

        }

    }

    private companion object {
        private const val SOURCE_PREFIX = "resources/"
    }

}
