package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.ssp.*


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

}
