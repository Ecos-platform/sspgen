package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.dsl.extensions.extractElementAndConnectorNames
import no.ntnu.ihb.sspgen.dsl.extensions.typeName
import no.ntnu.ihb.sspgen.ssp.TAnnotations
import no.ntnu.ihb.sspgen.ssp.TConnectors
import no.ntnu.ihb.sspgen.ssp.TSystem

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

    @Scoped
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
