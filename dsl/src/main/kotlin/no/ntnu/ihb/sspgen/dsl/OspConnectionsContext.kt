package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.fmi4j.modeldescription.ModelDescription
import no.ntnu.ihb.fmi4j.modeldescription.variables.Causality
import no.ntnu.ihb.sspgen.osp.OspModelDescriptionType
import no.ntnu.ihb.sspgen.osp.VariableType
import no.ntnu.ihb.sspgen.ssp.TComponent
import no.ntnu.ihb.sspgen.ssp.TSystem
import javax.xml.bind.annotation.XmlElement

class VariableGroupIdentifier(
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

class OspConnectionsContext(
    private val system: TSystem,
    private val modelDescriptions: Map<String, ModelDescription>,
    private val ospModelDescriptions: Map<String, OspModelDescriptionType>
) {

    private fun VariableGroupIdentifier.getOspVariableGroup(osp: OspModelDescriptionType): Any {

        val vgs = osp.variableGroups
        vgs.javaClass.declaredFields.forEach { f1 ->

            f1.getAnnotation(XmlElement::class.java)?.also { annotation ->
                if (annotation.name.toLowerCase().contains("port")) {
                    f1.isAccessible = true
                    (f1.get(vgs) as? List<*>)?.onEach { e ->
                        val name = e!!.javaClass.getDeclaredField("name").let {
                            it.isAccessible = true
                            it.get(e)
                        }
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
                if (f1.type.name.toLowerCase().contains("type")) {
                    f1.isAccessible = true
                    types.add(f1.get(this))
                }
            }
        }
        return types
    }

    private fun Any.getVariables(): List<VariableType> {
        val refs = mutableListOf<VariableType>()
        val variables = this.javaClass.getDeclaredField("variable").let {
            it.isAccessible = true
            it.get(this) as List<*>
        }
        variables.forEach { variable ->
            refs.add(variable as VariableType)
        }
        return refs
    }

    private fun VariableGroupIdentifier.getComponent(): TComponent {
        return system.elements.component.firstOrNull { it.name == this.componentName }
            ?: throw IllegalStateException("No component named '${this.componentName}'")
    }

    private fun VariableGroupIdentifier.getModelDescription(): ModelDescription {
        val component = getComponent()
        return modelDescriptions[component.getSourceFileName()]
            ?: throw IllegalStateException("No modelDescription.xml available for component '${this.componentName}'")
    }

    private fun VariableGroupIdentifier.getOspModelDescription(): OspModelDescriptionType {
        val component = getComponent()
        return ospModelDescriptions[component.getSourceFileName()]
            ?: throw IllegalStateException("No OspModelDescription.xml available for component '${this.componentName}'")
    }

    infix fun String.to(other: String) {

        val vgi1 = VariableGroupIdentifier(this)
        val vgi2 = VariableGroupIdentifier(other)

        val md1 = vgi1.getModelDescription()
        val md2 = vgi2.getModelDescription()

        val osp1 = vgi1.getOspModelDescription()
        val osp2 = vgi2.getOspModelDescription()

        val vg1 = vgi1.getOspVariableGroup(osp1)
        val vg2 = vgi2.getOspVariableGroup(osp2)

        require(vg1.javaClass == vg2.javaClass) { "${vg1.javaClass} !=${vg2.javaClass}" }

        val types1 = vg1.getTypes()
        val types2 = vg2.getTypes()

        require(types1.isNotEmpty())
        require(types2.isNotEmpty())

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

                    when (md1.modelVariables.getByName(ref1).causality) {
                        Causality.CALCULATED_PARAMETER, Causality.OUTPUT -> {
                            connection.startElement = vgi1.componentName
                            connection.startConnector = ref1
                            connection.endElement = vgi2.componentName
                            connection.endConnector = ref2
                        }
                        else -> {
                            connection.startElement = vgi2.componentName
                            connection.startConnector = ref2
                            connection.endElement = vgi1.componentName
                            connection.endConnector = ref1
                        }
                    }
                    system.connections.connection.add(connection)
                }

            }

        }

    }

}
