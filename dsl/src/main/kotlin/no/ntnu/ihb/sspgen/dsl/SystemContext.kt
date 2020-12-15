package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.ssp.TAnnotations
import no.ntnu.ihb.sspgen.ssp.TConnectors
import no.ntnu.ihb.sspgen.ssp.TSystem


@Scoped
class SystemContext(
    private val system: TSystem,
    private val modelDescriptions: Map<String, ModelDescription>,
    private val ospModelDescriptions: Map<String, OspModelDescriptionType>
) {

    var description: String? = system.description

    init {
        system.connectors = TConnectors()
        system.connections = TSystem.Connections()
    }

    fun elements(ctx: ElementsContext.() -> Unit) {
        system.elements = TSystem.Elements()
        ElementsContext(system).apply(ctx)
    }

    fun connections(inputsFirst: Boolean = false, ctx: ConnectionsContext.() -> Unit) {
        ConnectionsContext(inputsFirst, system).apply(ctx)
    }

    fun ospConnections(ctx: OspConnectionsContext.() -> Unit) {
        OspConnectionsContext(system, modelDescriptions, ospModelDescriptions).apply(ctx)
    }

    fun annotations(ctx: AnnotationsContext.() -> Unit) {
        system.annotations = TAnnotations()
        AnnotationsContext(system.annotations).apply(ctx)
    }

}
