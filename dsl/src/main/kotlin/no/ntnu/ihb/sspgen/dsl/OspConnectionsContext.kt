package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.osp.VariableType
import no.ntnu.ihb.sspgen.ssp.TSystem
import javax.xml.bind.annotation.XmlElement

data class VariableGroup(
    val component: String,
    val groupName: String
)

class OspConnectionsContext(
    private val system: TSystem,
    private val osp: OspModelDescriptionType
) {

    private fun VariableGroup.getOspVariableGroup(): Any {

        val vgs = osp.variableGroups
        vgs.javaClass.declaredFields.forEach { f1 ->

            f1.getAnnotation(XmlElement::class.java)?.also { annotation ->
                if (annotation.name.toLowerCase().contains("port")) {
                    (f1.get(vgs) as? List<*>)?.onEach { e ->
                        val name = e!!.javaClass.getField("name").get(e)
                        if (name == this.groupName) {
                            return e
                        }
                    }
                }
            }

        }

        throw IllegalStateException()
    }

    private fun Any.getTypes(): List<Any> {
        val types = mutableListOf<Any>()
        this.javaClass.declaredFields.forEach { f1 ->
            f1.getAnnotation(XmlElement::class.java)?.also {
                if (it.name.toLowerCase().contains("type")) {
                    types.add(f1.get(this))
                }
            }
        }
        return types
    }

    private fun Any.getVariables(): List<VariableType> {
        val refs = mutableListOf<VariableType>()
        this.javaClass.declaredFields.forEach { f1 ->
            val variables = this.javaClass.getField("variable") as List<*>
            variables.forEach { variable ->
                refs.add(variable as VariableType)
            }
        }
        return refs
    }

    infix fun VariableGroup.to(other: VariableGroup) {

        val vg1 = this.getOspVariableGroup()
        val vg2 = other.getOspVariableGroup()

        require(vg1.javaClass == vg2.javaClass) { "${vg1.javaClass} !=${vg2.javaClass}" }

        val types1 = vg1.getTypes()
        val types2 = vg2.getTypes()

        require(types1.size == types2.size) { "Dimension mismatch" }

        for (i in types1.indices) {
            val t1 = types1[i]
            val t2 = types2[i]

            val v1 = t1.getVariables()
            val v2 = t2.getVariables()

            require(v1.size == v2.size) { "Dimension mismatch" }

            for (j in v1.indices) {
                val ref1 = v1[j].ref
                val ref2 = v2[j].ref

                TSystem.Connections.Connection().also { connection ->
                    connection.startElement = this@to.component
                    connection.startConnector = ref1
                    connection.endElement = this@to.component
                    connection.endConnector = ref2
                    system.connections.connection.add(connection)
                }

            }

        }

    }

}
