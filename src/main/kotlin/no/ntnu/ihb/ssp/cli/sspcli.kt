package no.ntnu.ihb.ssp.cli

import no.ntnu.ihb.ssp.extractElementAndConnectorNames
import no.ntnu.ihb.ssp.schema.*
import java.io.BufferedOutputStream
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream
import javax.xml.bind.JAXB

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class Scoped

enum class Kind {
    input, output, inout, parameter, calculatedParameter
}

fun ssp(archiveName: String, ctx: SspContext.() -> Unit): SspContext {
    return SspContext().apply(ctx).apply {

        val sspArchive = File("$archiveName.ssp")

        ZipOutputStream(BufferedOutputStream(FileOutputStream(sspArchive))).use { zos ->

            zos.putNextEntry(ZipEntry("SystemStructure.ssd"))
            zos.write(ssd.toXML().toByteArray())
            zos.closeEntry()

            if (fmus.isNotEmpty()) {
                zos.putNextEntry(ZipEntry("fmus/"))
                fmus.forEach {
                    zos.putNextEntry(ZipEntry("fmus/${it.name}"))
                    zos.write(it.readBytes())
                    zos.closeEntry()
                }
                zos.closeEntry()
            }

            if (extra.isNotEmpty()) {
                zos.putNextEntry(ZipEntry("extra/"))
                extra.forEach {
                    zos.putNextEntry(ZipEntry("extra/${it.name}"))
                    zos.write(it.readBytes())
                    zos.closeEntry()
                }
                zos.closeEntry()
            }


        }

    }
}

@Scoped
class SspContext {

    val ssd: SystemStructureDescription = SystemStructureDescription()
    val extra = mutableListOf<File>()
    val fmus = mutableListOf<File>()

    fun ssd(name: String, ctx: SsdContext.() -> Unit) {
        ssd.name = name
        ssd.version = "1.0"
        ssd.generationTool = "sspgen"
        SsdContext(ssd).apply(ctx)
    }

    fun fmus(ctx: FmuContext.() -> Unit) {
        FmuContext().apply(ctx)
    }

    fun extra(ctx: ExtraContext.() -> Unit) {
        ExtraContext().apply(ctx)
    }

    inner class FmuContext {

        fun fmu(filePath: String) {
            val file = File(filePath)
            if (file.extension != "fmu") throw IllegalArgumentException("FMU does not have extension .fmu!")
            if (!file.exists()) throw NoSuchFileException(file)
            fmus.add(file)
        }

    }

    inner class ExtraContext {

        fun file(filePath: String) {
            val file = File(filePath)
            if (!file.exists()) throw NoSuchFileException(file)
            extra.add(file)
        }

    }

}


@Scoped
class SsdContext(
    private val ssd: SystemStructureDescription
) {

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

    fun system(name: String, ctx: SystemContext.() -> Unit) {
        ssd.system = TSystem().apply { this.name = name }
        SystemContext(ssd.system).apply(ctx)
    }

    fun defaultExperiment(
        startTime: Number? = null,
        stopTime: Number? = null,
        ctx: DefaultExperimentContext.() -> Unit
    ) {
        ssd.defaultExperiment = TDefaultExperiment()
        ssd.defaultExperiment.startTime = startTime?.toDouble()
        ssd.defaultExperiment.stopTime = stopTime?.toDouble()
        DefaultExperimentContext(ssd.defaultExperiment).apply(ctx)
    }

    @Scoped
    class SystemContext(
        private val system: TSystem
    ) {

        var description: String? = system.description

        fun elements(ctx: ElementsContext.() -> Unit) {
            system.elements = TSystem.Elements()
            ElementsContext(system).apply(ctx)
        }

        fun connections(ctx: ConnectionsContext.() -> Unit) {
            system.connections = TSystem.Connections()
            ConnectionsContext(system.connections).apply(ctx)
        }

        @Scoped
        class ConnectionsContext(
            private val connections: TSystem.Connections
        ) {

            infix fun String.to(other: String): ConnectionContext {
                val (e1, c1) = this.extractElementAndConnectorNames()
                val (e2, c2) = other.extractElementAndConnectorNames()
                val connection = TSystem.Connections.Connection().apply {
                    startElement = e1
                    startConnector = c1
                    endElement = e2
                    endConnector = c2
                }
                connections.connection.add(connection)
                return ConnectionContext(connection)
            }

            class ConnectionContext(
                private val connection: TSystem.Connections.Connection
            ) {

                fun annotations(ctx: AnnotationsContext.() -> Unit) {
                    connection.annotations = TAnnotations()
                    AnnotationsContext(connection.annotations).apply(ctx)
                }

                fun linearTransformation(factor: Number? = null, offset: Number? = null) {
                    connection.linearTransformation = TSystem.Connections.Connection.LinearTransformation().apply {
                        this.offset = offset?.toDouble() ?: 0.0
                        this.factor = factor?.toDouble() ?: 1.0
                    }
                }

            }

        }

        @Scoped
        class ElementsContext(
            system: TSystem
        ) {

            private val components = system.elements.component

            fun component(name: String, source: String, ctx: (ComponentContext.() -> Unit)? = null) {
                val component = TComponent().apply {
                    this.name = name
                    this.source = source
                }.also { components.add(it) }
                ctx?.also { ComponentContext(component).apply(it) }
            }

            @Scoped
            class ComponentContext(
                private val component: TComponent
            ) {

                fun connectors(ctx: ConnectorsContext.() -> Unit) {
                    component.connectors = TConnectors()
                    ConnectorsContext(component.connectors).apply(ctx)
                }

                fun parameterBindings(ctx: ParameterBindingsContext.() -> Unit) {
                    ParameterBindingsContext().apply(ctx)
                }

                fun annotations(ctx: AnnotationsContext.() -> Unit) {
                    component.annotations = TAnnotations()
                    AnnotationsContext(component.annotations).apply(ctx)
                }

                @Scoped
                class ConnectorsContext(
                    private val connectors: TConnectors
                ) {

                    private fun connector(name: String, kind: Kind): TConnectors.Connector {
                        return TConnectors.Connector().apply {
                            this.name = name
                            this.kind = kind.name
                        }.also { connectors.connector.add(it) }
                    }

                    fun integerConnector(name: String, kind: Kind) {
                        connector(name, kind).apply {
                            this.integer = TConnectors.Connector.Integer()
                        }
                    }

                    fun realConnector(name: String, kind: Kind, ctx: (RealConnectorContext.() -> Unit)? = null) {
                        val connector = connector(name, kind).apply {
                            this.real = TConnectors.Connector.Real()
                        }
                        ctx?.also { RealConnectorContext(connector.real).apply(it) }
                    }

                    fun stringConnector(name: String, kind: Kind) {
                        connector(name, kind).apply {
                            this.string = TConnectors.Connector.String()
                        }
                    }

                    fun booleanConnector(name: String, kind: Kind) {
                        connector(name, kind).apply {
                            this.boolean = TConnectors.Connector.Boolean()
                        }
                    }

                    fun enumerationConnector(name: String, kind: Kind) {
                        connector(name, kind).apply {
                            this.enumeration = TConnectors.Connector.Enumeration()
                        }
                    }

                    @Scoped
                    class RealConnectorContext(
                        private val real: TConnectors.Connector.Real
                    ) {

                        fun unit(value: String) {
                            real.unit = value
                        }

                    }

                }

                class ParameterBindingsContext {

                }

            }

        }

    }

    @Scoped
    class AnnotationsContext(
        private val annotations: TAnnotations
    ) {

        fun annotation(type: String, content: () -> String) {
            val annotation = TAnnotations.Annotation().apply {
                this.type = type
                this.any = content.invoke()
            }
            annotations.annotation.add(annotation)
        }

    }

    @Scoped
    class DefaultExperimentContext(
        private val defaultExperiment: TDefaultExperiment
    ) {

        fun annotations(ctx: AnnotationsContext.() -> Unit) {
            defaultExperiment.annotations = TAnnotations()
            AnnotationsContext(defaultExperiment.annotations).apply(ctx)
        }

    }

}

fun SystemStructureDescription.toXML(): String {
    val bos = ByteArrayOutputStream()
    JAXB.marshal(this, bos)
    var xml = bos.toString()
    xml = xml.replace("ns2:", "ssd:")
    xml = xml.replace("ns3:", "ssc:")
    xml = xml.replace("xmlns:ns2", "xmlns:ssd")
    xml = xml.replace("xmlns:ns3", "xmlns:ssc")
    xml = xml.replace("xmlns:ns4", "xmlns:ssb")

    xml = xml.replace("<any>", "")
    xml = xml.replace("</any>", "")
    xml = xml.replace("&lt;", "<")
    xml = xml.replace("/&gt;", "/>")
    xml = xml.replace("&gt;", ">")

    return xml
}

private fun main() {

    val ssd = ssp("TestSsdGen") {

        ssd("A simple CLI test") {

            author = "John Doe"
            description = "A simple description"

            system("Test") {

                description = "An even simpler description"

                elements {
                    component("FMU1", "fmus/FMU1.fmu") {
                        connectors {
                            realConnector("output", Kind.output) {
                                unit("m/s")
                            }
                            realConnector("input", Kind.input)
                            integerConnector("counter", Kind.output)
                        }
                        annotations {
                            annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                                """
                                <TestElement/>
                            """.trimIndent()
                            }
                        }
                    }
                    component("FMU2", "fmus/FMU2.fmu") {
                        connectors {
                            realConnector("input", Kind.input)
                            realConnector("output", Kind.output)
                        }
                    }
                }

                connections {
                    "FMU2.output" to "FMU1.input"
                    ("FMU1.output" to "FMU2.input").linearTransformation(factor = 1.5)
                }

            }

            defaultExperiment(startTime = 1.0) {

                annotations {
                    annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                        """
                        <MyElement value="90">
                            <MySecondElement/>
                        </MyElement>
                    """
                    }
                }

            }

        }

    }.ssd

    println(ssd.toXML())

}

