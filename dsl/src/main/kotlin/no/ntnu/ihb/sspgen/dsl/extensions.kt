package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.schema.TConnectors
import no.ntnu.ihb.sspgen.schema.TParameter

internal fun String.extractElementAndConnectorNames(): Pair<String, String> {
    val i = indexOf('.')
    if (i == -1) throw IllegalArgumentException()
    val elementName = substring(0, i)
    val connectorName = substring(i + 1)
    return elementName to connectorName
}


internal fun TParameter.copy(): TParameter {
    fun TParameter.Integer.copy() = TParameter.Integer().also { p ->
        p.value = value
    }

    fun TParameter.Real.copy() = TParameter.Real().also { p ->
        p.value = value
        p.unit = unit
    }

    fun TParameter.String.copy() = TParameter.String().also { p ->
        p.value = value
    }

    fun TParameter.Enumeration.copy() = TParameter.Enumeration().also { p ->
        p.value = value
    }

    fun TParameter.Boolean.copy() = TParameter.Boolean().also { p ->
        p.isValue = isValue
    }

    fun TParameter.Binary.copy() = TParameter.Binary().also { p ->
        p.value = value.copyOf()
    }

    return TParameter().also { p ->
        p.name = name
        p.description = description
        p.integer = integer?.copy()
        p.real = real?.copy()
        p.string = string?.copy()
        p.boolean = boolean?.copy()
        p.enumeration = enumeration?.copy()
        p.binary = binary?.copy()
    }
}

internal fun TConnectors.Connector.typeName(): String {
    return when {
        integer != null -> "Integer"
        real != null -> "Real"
        string != null -> "String"
        boolean != null -> "Boolean"
        enumeration != null -> "Enumeration"
        binary != null -> "Binary"
        else -> throw IllegalArgumentException()
    }
}
