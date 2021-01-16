package no.ntnu.ihb.sspgen.dsl

import no.ntnu.ihb.sspgen.dsl.annotations.Scoped
import no.ntnu.ihb.sspgen.ssp.TUnit
import no.ntnu.ihb.sspgen.ssp.TUnits

@Scoped
class UnitsContext(
    private val units: TUnits
) {

    fun unit(name: String, ctx: UnitContext.() -> Unit) {
        val unit = TUnit().apply {
            this.name = name
        }
        UnitContext(unit).apply(ctx)
        units.unit.add(unit)
    }

    @Scoped
    inner class UnitContext(
        private val unit: TUnit
    ) {

        init {
            unit.baseUnit = TUnit.BaseUnit()
        }

        var description: String?
            get() = unit.description
            set(value) {
                unit.description = value
            }

        fun baseUnit(
            kg: Int? = null,
            m: Int? = null,
            s: Int? = null,
            A: Int? = null,
            K: Int? = null,
            mol: Int? = null,
            cd: Int? = null,
            rad: Int? = null,
            factor: Double? = null,
            offset: Double? = null
        ) {
            unit.baseUnit.apply {
                kg?.also { this.kg = it }
                m?.also { this.m = it }
                s?.also { this.s = it }
                A?.also { this.a = it }
                K?.also { this.k = it }
                mol?.also { this.mol = it }
                cd?.also { this.cd = it }
                rad?.also { this.rad = it }
                factor?.also { this.factor = it }
                offset?.also { this.offset = it }
            }
        }

    }

}
