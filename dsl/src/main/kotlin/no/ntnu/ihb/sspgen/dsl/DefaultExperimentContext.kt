package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.ssp.TAnnotations
import no.ntnu.ihb.sspgen.ssp.TDefaultExperiment

@Scoped
class DefaultExperimentContext(
    private val defaultExperiment: TDefaultExperiment
) {

    fun annotations(ctx: AnnotationsContext.() -> Unit) {
        defaultExperiment.annotations = TAnnotations()
        AnnotationsContext(defaultExperiment.annotations).apply(ctx)
    }

}
