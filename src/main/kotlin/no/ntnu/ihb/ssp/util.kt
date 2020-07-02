package no.ntnu.ihb.ssp

internal fun String.extractElementAndConnectorNames(): Pair<String, String> {
    val i = indexOf('.')
    if (i == -1) throw IllegalArgumentException()
    val elementName = substring(0, i)
    val connectorName = substring(i + 1)
    return elementName to connectorName
}
