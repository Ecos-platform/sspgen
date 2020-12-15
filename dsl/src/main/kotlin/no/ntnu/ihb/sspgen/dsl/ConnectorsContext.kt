package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.ssp.TComponent
import no.ntnu.ihb.sspgen.ssp.TConnectors

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
