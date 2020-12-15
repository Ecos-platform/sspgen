package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.dsl.extensions.copy
import no.ntnu.ihb.sspgen.ssp.*

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
