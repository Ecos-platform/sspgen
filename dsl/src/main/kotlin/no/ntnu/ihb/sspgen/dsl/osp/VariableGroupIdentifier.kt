package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.extensions.extractElementAndConnectorNames

internal class VariableGroupIdentifier(
    str: String
) {

    val componentName: String
    val groupName: String

    init {
        str.extractElementAndConnectorNames().also {
            componentName = it.first
            groupName = it.second
        }
    }

}
