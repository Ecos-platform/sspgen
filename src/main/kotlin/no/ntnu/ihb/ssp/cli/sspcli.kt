package no.ntnu.ihb.ssp.cli

import no.ntnu.ihb.ssp.schema.*
import java.io.ByteArrayOutputStream
import javax.xml.bind.JAXB

fun ssd(ctx: SspContext.() -> Unit): SystemStructureDescription {
    return SystemStructureDescription().also {
        SspContext(it).apply(ctx)
    }
}

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class Scoped

enum class Kind {
    input, output, inout, parameter, calculatedParameter
}

@Scoped
class SspContext(
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

    var name: String?
        get() = ssd.name
        set(value) {
            ssd.name = value
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

    init {
        ssd.generationTool = "sspgen"
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
            if (system.elements == null) {
                system.elements = TSystem.Elements()
            }
            ElementsContext(system).apply(ctx)
        }

        @Scoped
        class ElementsContext(
            private val system: TSystem
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

                    fun integerConnector(name: String, kind: Kind, ctx: (RealConnectorContext.() -> Unit)? = null) {
                        val connector = TConnectors.Connector().apply {
                            this.name = name
                            this.kind = kind.name
                        }
                    }

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

    val ssd = ssd {

        author = "John Doe"
        name = "A simple CLI test"
        description = "A simple description"

        system("Test") {

            description = "An even simpler description"

            elements {
                component("FMU1", "fmus/FMU1.fmu") {
                    connectors {
                        realConnector("realValue", Kind.input) {
                            unit("m/s")
                        }
                        integerConnector("integerValue", Kind.output)
                    }
                    parameterBindings {

                    }
                    annotations {
                        annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                            """
                                <TestElement/>
                            """.trimIndent()
                        }
                    }
                }
            }

        }

        defaultExperiment(startTime = 1.0) {

            annotations {
                annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                    """
                        <MyElement value="90"/>
                    """.trimIndent()
                }
                annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                    """
                        <MyElement value="90">
                            <MySecondElement/>
                        </MyElement>
                    """.trimIndent()
                }
            }

        }

    }

    println(ssd.toXML())

}

