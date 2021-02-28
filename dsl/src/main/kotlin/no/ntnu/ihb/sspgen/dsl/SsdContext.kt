package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.ssp.SystemStructureDescription
import no.ntnu.ihb.sspgen.ssp.TDefaultExperiment
import no.ntnu.ihb.sspgen.ssp.TSystem
import no.ntnu.ihb.sspgen.ssp.TUnits
import no.ntnu.ihb.sspgen.sspgen
import java.io.ByteArrayOutputStream
import javax.xml.bind.JAXB

@Scoped
class SsdContext(
    val name: String,
    private val modelDescriptions: () -> Map<String, ModelDescription>,
    private val ospModelDescriptions: () -> Map<String, OspModelDescriptionType>
) {

    private val namespaces = mutableListOf<String>()
    internal val ssd: SystemStructureDescription = SystemStructureDescription()

    var author: String?
        get() = ssd.author
        set(value) {
            ssd.author = value
        }

    var copyright: String?
        get() = ssd.copyright
        set(value) {
            ssd.copyright = value
        }

    var description: String?
        get() = ssd.description
        set(value) {
            ssd.description = value
        }

    var license: String?
        get() = ssd.license
        set(value) {
            ssd.license = value
        }

    var fileVersion: String?
        get() = ssd.fileversion
        set(value) {
            ssd.fileversion = value
        }

    init {
        ssd.name = name
        ssd.version = "1.0"
        ssd.generationTool = "sspgen ${sspgen.version}"
    }

    fun system(name: String, ctx: SystemContext.() -> Unit) {
        ssd.system = TSystem().apply { this.name = name }
        SystemContext(ssd.system, modelDescriptions, ospModelDescriptions).apply(ctx)
    }

    fun units(ctx: UnitsContext.() -> Unit) {
        ssd.units = TUnits()
        UnitsContext(ssd.units).apply(ctx)
    }

    fun namespaces(ctx: NamespaceContext.() -> Unit) {
        NamespaceContext(namespaces).apply(ctx)
    }

    fun defaultExperiment(
        startTime: Number? = null,
        stopTime: Number? = null,
        ctx: (DefaultExperimentContext.() -> Unit)? = null
    ) {
        ssd.defaultExperiment = TDefaultExperiment()
        ssd.defaultExperiment.startTime = startTime?.toDouble()
        ssd.defaultExperiment.stopTime = stopTime?.toDouble()
        ctx?.also {
            DefaultExperimentContext(ssd.defaultExperiment).apply(it)
        }
    }


    fun ssdXml(): String {

        var xml = ByteArrayOutputStream().use { baos ->
            JAXB.marshal(ssd, baos)
            baos.toString()
        }

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

}
