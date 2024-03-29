package no.ntnu.ihb.sspgen.dsl.extensions

import no.ntnu.ihb.sspgen.ssp.TComponent
import no.ntnu.ihb.sspgen.ssp.TConnectors
import no.ntnu.ihb.sspgen.ssp.TParameter

internal fun String.extractElementAndConnectorNames(): Pair<String, String> {
    val i = indexOf('.')
    if (i == -1) throw IllegalArgumentException("Invalid argument: $this")
    val elementName = substring(0, i)
    val connectorName = substring(i + 1)
    return elementName to connectorName
}

internal fun TComponent.getSourceFileName(): String {
    var source = source.replace("resources/", "")
    val idx = source.indexOf("file=")
    if (idx != -1) {
        source = source.substring(idx + 5)
    }
    return source
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

internal fun TParameter.typeName(): String {
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
