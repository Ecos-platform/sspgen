package no.ntnu.ihb.ssp.cli

import no.ntnu.ihb.ssp.schema.SystemStructureDescription
import no.ntnu.ihb.ssp.schema.TDefaultExperiment
import java.io.ByteArrayOutputStream
import javax.xml.bind.JAXB

fun ssp(ctx: SspContext.() -> Unit): SystemStructureDescription {
    return SystemStructureDescription().also {
        SspContext(it).apply(ctx)
    }
}

class SspContext(
    private val ssd: SystemStructureDescription
) {

    fun defaultExperiment(ctx: DefaultExperimentContext.() -> Unit) {
        DefaultExperimentContext().apply(ctx)
    }

    inner class DefaultExperimentContext {

        private val defaultExperiment by lazy {
            TDefaultExperiment().also { ssd.defaultExperiment = it }
        }

       fun startTime(value: Double) {
           defaultExperiment.startTime = value
       }

        fun stopTime(value: Double) {
            defaultExperiment.stopTime = value
        }

    }

}




private fun main() {

    val ssd = ssp {

        defaultExperiment {

            startTime(1.0)

        }

    }


    val bos = ByteArrayOutputStream()
    JAXB.marshal(ssd, bos)

    println(bos.toString())

}

