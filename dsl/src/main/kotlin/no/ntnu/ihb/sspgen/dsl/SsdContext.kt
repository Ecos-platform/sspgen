package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.ssp.*

@Scoped
class SsdContext(
    private val ssd: SystemStructureDescription,
    private val modelDescriptions: Map<String, ModelDescription>,
    private val ospModelDescriptions: Map<String, OspModelDescriptionType>
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
        SystemContext(ssd.system, modelDescriptions, ospModelDescriptions).apply(ctx)
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
            DefaultExperimentContext(ssd.defaultExperiment).apply(it)
        }
    }

}
