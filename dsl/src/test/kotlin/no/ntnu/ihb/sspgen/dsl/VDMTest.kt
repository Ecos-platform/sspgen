package no.ntnu.ihb.sspgen.dsl

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import java.io.File


@EnabledIfEnvironmentVariable(named = "VDMCHECK_DIR", matches = ".*vdmcheck-1.0.0$")
class VDMTest {

    @Test
    fun test() {

        ssp("QuarterTruck") {

            resources {
                val cl = QuarterTruckTest::class.java.classLoader
                val fmuPath = cl.getResource("quarter-truck")!!.file
                file("$fmuPath/chassis.fmu")
                file("$fmuPath/wheel.fmu")
                file("$fmuPath/ground.fmu")
            }

        }.validate(pathToVdm)

    }

    private companion object {
        private val pathToVdm = File(
            "${System.getenv("VDMCHECK_DIR")}/fmi2vdm-1.0.0.jar"
        )
    }

}
