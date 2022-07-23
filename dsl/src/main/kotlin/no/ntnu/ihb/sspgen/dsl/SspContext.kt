package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.ModelDescriptionParser
import no.ntnu.ihb.fmi4j.modeldescription.util.FmiModelDescriptionUtil
import no.ntnu.ihb.fmi4j.modeldescription.variables.VariableType
import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.dsl.extensions.getSourceFileName
import no.ntnu.ihb.sspgen.dsl.extensions.typeName
import no.ntnu.ihb.sspgen.dsl.resources.Resource
import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.sspgen
import java.io.*
import java.net.URLClassLoader
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream
import javax.xml.bind.JAXB


fun ssp(archiveName: String, ctx: SspContext.() -> Unit): SspContext {
    return SspContext(archiveName).apply(ctx)
}

@Scoped
class SspContext(
    val archiveName: String
) {

    private val modelDescriptions: Map<String, String> by lazy {
        retrieveModelDescriptions()
    }

    internal val parsedModelDescriptions: Map<String, ModelDescription> by lazy {
        modelDescriptions.mapValues { ModelDescriptionParser.parse(it.value) }
    }

    internal val ospModelDescriptions by lazy {
        retrieveOspModelDescriptions()
    }

    private val resources = mutableListOf<Resource>()
    private lateinit var ssdCtx: SsdContext
    private var validated = false

    fun ssd(name: String, ctx: SsdContext.() -> Unit): SsdContext {
        return SsdContext(name, { parsedModelDescriptions }, { ospModelDescriptions }).apply(ctx).also {
            ssdCtx = it
        }
    }

    fun resources(ctx: ResourcesContext.() -> Unit) {
        ResourcesContext(resources).apply(ctx)
    }

    private fun retrieveModelDescriptions(): Map<String, String> {

        if (resources.isEmpty()) {
            throw IllegalStateException("No resources has been defined. Resources must be defined prior to ssd!")
        }

        return resources.filter { it.name.endsWith(".fmu") }.associate {
            val xml = FmiModelDescriptionUtil.extractModelDescriptionXml(it.openStream())
            it.name to xml
        }

    }

    private fun extractOspModelDescription(`is`: InputStream): OspModelDescriptionType? {
        ZipInputStream(`is`.buffered()).use { zis ->
            var zipEntry: ZipEntry? = zis.nextEntry
            while (zipEntry != null) {
                if (zipEntry.name.endsWith("OspModelDescription.xml")) {
                    val xml = InputStreamReader(zis).buffered().useLines {
                        it.joinToString("\n")
                    }
                    return JAXB.unmarshal(StringReader(xml), OspModelDescriptionType::class.java)
                }
                zis.closeEntry()
                zipEntry = zis.nextEntry
            }
        }
        return null
    }

    private fun retrieveOspModelDescriptions(): Map<String, OspModelDescriptionType> {
        val ospModelDescriptions = mutableMapOf<String, OspModelDescriptionType>()
        resources.forEach { resource ->
            if (resource.name.endsWith(".fmu")) {
                extractOspModelDescription(resource.openStream())?.also { ospMd ->
                    ospModelDescriptions[resource.name] = ospMd
                }
            }
        }
        return ospModelDescriptions
    }

    private fun vdmCheck(vdmJar: File?) {
        if (vdmJar != null && vdmJar.exists() && vdmJar.extension == "jar") {

            println("VDMCheck found..")
            val cl = URLClassLoader(arrayOf(vdmJar.toURI().toURL()))
            val vdm = cl.loadClass("VDMCheck")

            val vdmMethod = vdm.getDeclaredMethod(
                "run",
                String::class.java, String::class.java, String::class.java, String::class.java
            )
            resources.filter { it.name.endsWith(".fmu") }.forEach { resource ->
                val name = resource.name
                println("Checking modelDescription of $name using VDMCheck..")
                val xml = FmiModelDescriptionUtil.extractModelDescriptionXml(resource.openStream())
                val version = FmiModelDescriptionUtil.extractVersion(xml)
                if (version.startsWith("2.")) {
                    val xml1 = if (xml.startsWith("<?xml version")) {
                        xml.split("\n").drop(1).joinToString("\n")
                    } else {
                        xml
                    }
                    vdmMethod.isAccessible = true
                    vdmMethod.invoke(null, null, xml1, null, "schema/fmi2ModelDescription.xsd")
                } else {
                    System.err.println("Unable to check FMU adhering to version $version of the FMI standard..")
                }
            }
            println("VDMCheck finished..")
        }

    }

    fun validate(vdmJar: File? = null) = apply {

        vdmCheck(vdmJar)

        ssdCtx.ssd.system?.elements?.component?.forEach { component ->

            val fmuName = component.getSourceFileName()
            val md = parsedModelDescriptions[fmuName]
                ?: throw IllegalStateException("No modelDescription affiliated with $fmuName!")
            val mv = md.modelVariables

            component.connectors.connector.forEach { connector ->
                val name = connector.name
                when (connector.typeName()) {
                    "Integer" -> mv.integers.find { it.name == name }
                        ?: throw IllegalStateException("No Integer variable named $name found within the modelDescription of FMU named $fmuName!")
                    "Real" -> mv.reals.find { it.name == name }
                        ?: throw IllegalStateException("No Real variable named $name found within the modelDescription of FMU named $fmuName!")
                    "Boolean" -> mv.booleans.find { it.name == name }
                        ?: throw IllegalStateException("No Boolean variable named $name found within the modelDescription of FMU named $fmuName!")
                    "String" -> mv.strings.find { it.name == name }
                        ?: throw IllegalStateException("No String variable named $name found within the modelDescription of FMU named $fmuName!")
                    "Enumeration" -> mv.enumerations.find { it.name == name }
                        ?: throw IllegalStateException("No Enumeration variable named $name found within the modelDescription of FMU named $fmuName!")
                }
            }

            component.parameterBindings?.parameterBinding?.forEach { binding ->
                binding.parameterValues?.parameterSet?.forEach { set ->
                    set.parameters?.parameter?.forEach { p ->
                        val v = mv.getByNameOrNull(p.name)
                            ?: throw IllegalStateException("No variable ${p.name} exists for component ${component.name}!")
                        when (v.type) {
                            VariableType.INTEGER -> require(p.integer != null)
                            { "Expected ${component.name}::${p.name} to be of type INTEGER!" }
                            VariableType.REAL -> require(p.real != null)
                            { "Expected ${component.name}::${p.name} to be of type ${v.type.typeName}, but found ${p.typeName()}!" }
                            VariableType.BOOLEAN -> require(p.boolean != null)
                            { "Expected ${component.name}::${p.name} to be of type BOOLEAN!" }
                            VariableType.STRING -> require(p.string != null)
                            { "Expected ${component.name}::${p.name} to be of type STRING!" }
                            VariableType.ENUMERATION -> require(p.enumeration != null)
                            { "Expected ${component.name}::${p.name} to be of type ENUMERATION!" }
                        }
                    }
                }
            }

        }

        validated = true

    }

    fun build(outputDir: File? = null, vdmJar: File? = null) {

        println("sspgen v${sspgen.version}")

        if (!validated) validate(vdmJar)

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
            zos.write(ssdCtx.ssdXml().toByteArray())
            zos.closeEntry()

            if (resources.isNotEmpty()) {
                zos.putNextEntry(ZipEntry(SOURCE_PREFIX))
                resources.forEach {
                    zos.putNextEntry(ZipEntry("$SOURCE_PREFIX${it.name}"))
                    zos.write(it.readBytes())
                    zos.closeEntry()
                }
                zos.closeEntry()
            }

        }

    }

    private companion object {
        const val SOURCE_PREFIX = "resources/"
    }

}
