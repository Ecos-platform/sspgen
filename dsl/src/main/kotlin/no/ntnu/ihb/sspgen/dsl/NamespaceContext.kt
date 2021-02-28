package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped

@Scoped
class NamespaceContext(
    private val namespaces: MutableList<String>
) {

    fun namespace(namespace: String, uri: String) {
        namespaces.add("xmlns:$namespace=\"$uri\"")
    }

}
