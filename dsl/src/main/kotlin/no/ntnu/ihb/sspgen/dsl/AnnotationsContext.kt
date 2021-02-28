package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.ssp.TAnnotations
import no.ntnu.ihb.sspgen.ssp.TComponent

@Scoped
open class AnnotationsContext(
    private val annotations: TAnnotations
) {

    fun annotation(type: String, content: () -> String) {
        val annotation = TAnnotations.Annotation().apply {
            this.type = type
            this.any = content.invoke()
        }
        annotations.annotation.add(annotation)
    }

}

@Scoped
class ComponentAnnotationsContext(
    private val components: MutableList<TComponent>,
    private val annotations: TAnnotations
) : AnnotationsContext(annotations) {

    fun copyFrom(name: String) {
        val component = components.firstOrNull { it.name == name }
            ?: throw NoSuchElementException("No component named '$name'!")
        annotations.annotation.addAll(component.annotations.annotation)
    }

}
