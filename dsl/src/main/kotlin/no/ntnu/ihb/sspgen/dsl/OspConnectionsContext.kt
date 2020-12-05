package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.ssp.TSystem

class OspConnectionsContext(
    private val system: TSystem,
    private val osp: OspModelDescriptionType
) {

    infix fun String.to(other: String) {


    }

}
