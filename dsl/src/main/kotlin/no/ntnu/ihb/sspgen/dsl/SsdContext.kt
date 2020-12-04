package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.schema.*

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

    var fileVersion: String?
        get() = ssd.fileversion
        set(value) {
            ssd.fileversion = value
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

        init {
            system.connectors = TConnectors()
        }

        fun elements(ctx: ElementsContext.() -> Unit) {
            system.elements = TSystem.Elements()
            ElementsContext(system).apply(ctx)
        }

        fun connections(inputsFirst: Boolean = false, ctx: ConnectionsContext.() -> Unit) {
            system.connections = TSystem.Connections()
            ConnectionsContext(inputsFirst, system).apply(ctx)
        }

        fun annotations(ctx: AnnotationsContext.() -> Unit) {
            system.annotations = TAnnotations()
            AnnotationsContext(system.annotations).apply(ctx)
        }

        @Scoped
        class ConnectionsContext(
            private val inputsFirst: Boolean,
            private val system: TSystem
        ) {

            private val connections: TSystem.Connections = system.connections

            private fun validateComponentAndConnectorExists(
                componentName: String,
                connectorName: String
            ): TConnectors.Connector {
                return system.elements.component.firstOrNull { it.name == componentName }?.let { c ->
                    c.connectors.connector.firstOrNull { it.name == connectorName }
                        ?: throw NoSuchElementException("No connector named '$connectorName' declared for component '$componentName'!")
                }
                    ?: throw NoSuchElementException("No component named '$componentName' declared for system '${system.name}'!")
            }

            private fun validateConnectionTypes(c1: TConnectors.Connector, c2: TConnectors.Connector) {
                val t1 = c1.typeName()
                val t2 = c2.typeName()
                require(t1 == t2) { "Trying to connect variables with different type! $t1 <=> $t2!" }
            }

            infix fun String.to(other: String): ConnectionContext {
                val (e1, c1) = this.extractElementAndConnectorNames()
                val (e2, c2) = other.extractElementAndConnectorNames()

                val connector1 = validateComponentAndConnectorExists(e1, c1)
                val connector2 = validateComponentAndConnectorExists(e2, c2)
                validateConnectionTypes(connector1, connector2)

                val connection = TSystem.Connections.Connection().apply {
                    if (inputsFirst) {
                        startElement = e2
                        startConnector = c2
                        endElement = e1
                        endConnector = c1
                    } else {
                        startElement = e1
                        startConnector = c1
                        endElement = e2
                        endConnector = c2
                    }
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
                        offset?.toDouble()?.also { this.offset = it }
                        factor?.toDouble()?.also { this.factor = it }
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

                fun annotations(ctx: ComponentAnnotationsContext.() -> Unit) {
                    component.annotations = TAnnotations()
                    ComponentAnnotationsContext(components, component.annotations).apply(ctx)
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
                        val copyComponent = components.firstOrNull { it.name == componentName }
                            ?: throw NoSuchElementException("No component named '$componentName'!")
                        val copyParameterSet = copyComponent.parameterBindings.parameterBinding
                            .flatMap { it.parameterValues.parameterSet }
                            .firstOrNull { it.name == parameterSetName }
                            ?: throw NoSuchElementException("No parameterSet named '$parameterSetName' in component '$componentName'!")

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

                        fun enumeration(name: String, value: String) {
                            parameter(name).apply {
                                this.enumeration = TParameter.Enumeration().apply {
                                    this.value = value
                                }
                            }
                        }

                    }

                }

            }

        }

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
            val component = components.firstOrNull { it.name == name }
                ?: throw NoSuchElementException("No component named '$name'!")
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
    class ComponentAnnotationsContext(
        private val components: MutableList<TComponent>,
        private val annotations: TAnnotations
    ) {

        fun annotation(type: String, content: () -> String) {
            val annotation = TAnnotations.Annotation().apply {
                this.type = type
                this.any = content.invoke()
            }
            annotations.annotation.add(annotation)
        }

        fun copyFrom(name: String) {
            val component = components.firstOrNull { it.name == name }
                ?: throw NoSuchElementException("No component named '$name'!")
            annotations.annotation.addAll(component.annotations.annotation)
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
