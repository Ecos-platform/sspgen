package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.*
import no.ntnu.ihb.sspgen.schema.*
import java.io.File
import java.net.URL

@DslMarker
@Target(AnnotationTarget.CLASS, AnnotationTarget.TYPE)
annotation class Scoped

fun ssp(archiveName: String, ctx: SspContext.() -> Unit): SspContext {
    return SspContext(archiveName).apply(ctx)
}

class SspContext(
    val archiveName: String
) {

    val ssd: SystemStructureDescription = SystemStructureDescription()
    val resources = mutableListOf<Resource>()

    fun ssd(name: String, ctx: SsdContext.() -> Unit) {
        ssd.name = name
        ssd.version = "1.0"
        ssd.generationTool = "sspgen"
        SsdContext(ssd).apply(ctx)
    }

    fun resources(ctx: ResourcesContext.() -> Unit) {
        ResourcesContext().apply(ctx)
    }

    inner class ResourcesContext {

        fun file(filePath: String) {
            val file = File(filePath)
            if (!file.exists()) throw NoSuchFileException(file)
            resources.add(FileResource(file))
        }

        fun url(urlString: String) {
            resources.add(UrlResource(URL(urlString)))
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
        ctx: (DefaultExperimentContext.() -> Unit)? = null
    ) {
        ssd.defaultExperiment = TDefaultExperiment()
        ssd.defaultExperiment.startTime = startTime?.toDouble()
        ssd.defaultExperiment.stopTime = stopTime?.toDouble()
        ctx?.also {
            DefaultExperimentContext(ssd.defaultExperiment)
                .apply(it)
        }
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

        fun connections(inputsFirst: Boolean = false, ctx: ConnectionsContext.() -> Unit) {
            system.connections = TSystem.Connections()
            ConnectionsContext(inputsFirst, system.connections).apply(ctx)
        }

        @Scoped
        class ConnectionsContext(
            private val inputsFirst: Boolean,
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

                if (inputsFirst) {
                    connection.startElement = connection.endElement
                    connection.startConnector = connection.startConnector
                    connection.endElement = connection.endConnector
                    connection.endConnector = connection.startConnector
                }
                connections.connection.add(connection)
                return ConnectionContext(
                    connection
                )
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

            private val components: MutableList<TComponent> = system.elements.component

            fun component(name: String, source: String, ctx: (ComponentContext.() -> Unit)? = null) {
                val component = TComponent().apply {
                    this.name = name
                    this.source = source
                }.also { components.add(it) }
                ctx?.also {
                    ComponentContext(
                        components,
                        component
                    ).apply(it)
                }
            }

            @Scoped
            class ComponentContext(
                private val components: MutableList<TComponent>,
                private val component: TComponent
            ) {

                fun connectors(ctx: ConnectorsContext.() -> Unit) {
                    component.connectors = TConnectors()
                    ConnectorsContext(
                        components,
                        component.connectors
                    ).apply(ctx)
                }

                fun parameterBindings(ctx: ParameterBindingsContext.() -> Unit) {
                    if (component.parameterBindings == null) {
                        component.parameterBindings = TParameterBindings()
                    }
                    val binding = TParameterBindings.ParameterBinding().apply {
                        parameterValues = TParameterBindings.ParameterBinding.ParameterValues()
                    }
                    component.parameterBindings.parameterBinding.add(binding)
                    ParameterBindingsContext(
                        components,
                        binding.parameterValues.parameterSet
                    ).apply(ctx)
                }

                fun annotations(ctx: AnnotationsContext.() -> Unit) {
                    component.annotations = TAnnotations()
                    AnnotationsContext(component.annotations).apply(ctx)
                }

                @Scoped
                class ConnectorsContext(
                    private val components: MutableList<TComponent>,
                    private val connectors: TConnectors
                ) {

                    val input = "input"
                    val output = "output"
                    val inout = "inout"
                    val parameter = "parameter"
                    val calculatedParameter = "calculatedParameter"

                    private fun connector(name: String, kind: String): TConnectors.Connector {
                        return TConnectors.Connector().apply {
                            this.name = name
                            this.kind = kind
                        }.also { connectors.connector.add(it) }
                    }

                    fun integer(name: String, kind: String) {
                        connector(name, kind).apply {
                            this.integer = TConnectors.Connector.Integer()
                        }
                    }

                    fun real(name: String, kind: String, ctx: (RealConnectorContext.() -> Unit)? = null) {
                        val connector = connector(name, kind).apply {
                            this.real = TConnectors.Connector.Real()
                        }
                        ctx?.also {
                            RealConnectorContext(
                                connector.real
                            ).apply(it)
                        }
                    }

                    fun string(name: String, kind: String) {
                        connector(name, kind).apply {
                            this.string = TConnectors.Connector.String()
                        }
                    }

                    fun boolean(name: String, kind: String) {
                        connector(name, kind).apply {
                            this.boolean = TConnectors.Connector.Boolean()
                        }
                    }

                    fun enumeration(name: String, kind: String) {
                        connector(name, kind).apply {
                            this.enumeration = TConnectors.Connector.Enumeration()
                        }
                    }

                    fun copyFrom(name: String) {
                        val component = components.first { it.name == name }
                        connectors.connector.addAll(component.connectors.connector)
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

                @Scoped
                class ParameterBindingsContext(
                    private val components: MutableList<TComponent>,
                    private val parameterSets: MutableList<ParameterSet>
                ) {

                    fun parameterSet(name: String, ctx: ParameterSetContext.() -> Unit) {
                        val parameterSet = ParameterSet().apply {
                            this.name = name
                            this.version = "1.0"
                        }
                        parameterSet.parameters = TParameters()
                        ParameterSetContext(
                            parameterSet.parameters.parameter
                        ).apply(ctx)
                        parameterSets.add(parameterSet)
                    }

                    fun copyFrom(
                        componentName: String,
                        parameterSetName: String,
                        ctx: (ParameterSetContext.() -> Unit)? = null
                    ) {
                        val copyComponent = components.first { it.name == componentName }
                        val copyParameterSet = copyComponent.parameterBindings.parameterBinding
                            .flatMap { it.parameterValues.parameterSet }
                            .first { it.name == parameterSetName }

                        val parameterSet = ParameterSet().apply {
                            this.name = copyParameterSet.name
                            this.version = "1.0"
                        }
                        parameterSet.parameters = TParameters().apply {
                            parameter.addAll(copyParameterSet.parameters.parameter.map { it.copy() })
                        }
                        ctx?.also {
                            ParameterSetContext(
                                parameterSet.parameters.parameter
                            ).apply(it)
                        }
                        parameterSets.add(parameterSet)
                    }

                    @Scoped
                    class ParameterSetContext(
                        private val parameters: MutableList<TParameter>
                    ) {

                        private fun parameter(name: String): TParameter {
                            return parameters.firstOrNull { it.name == name }
                                ?: TParameter().apply {
                                    this.name = name
                                    parameters.add(this)
                                }
                        }

                        fun integer(name: String, value: Int) {
                            parameter(name).apply {
                                this.integer = TParameter.Integer().apply {
                                    this.value = value
                                }
                            }
                        }

                        fun real(name: String, value: Number) {
                            parameter(name).apply {
                                this.real = TParameter.Real().apply {
                                    this.value = value.toDouble()
                                }
                            }
                        }

                        fun string(name: String, value: String) {
                            parameter(name).apply {
                                this.string = TParameter.String().apply {
                                    this.value = value
                                }
                            }
                        }

                        fun boolean(name: String, value: Boolean) {
                            parameter(name).apply {
                                this.boolean = TParameter.Boolean().apply {
                                    this.isValue = value
                                }
                            }
                        }

                    }

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
