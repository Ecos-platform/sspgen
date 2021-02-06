package no.ntnu.ihb.sspgen.dsl

import org.junit.jupiter.api.Test
import java.io.File

class VDMTest {

    private val pathToVdm = File(
        "C:/Users/LarsIvar/AppData/Local/" +
                "FMI2-vdmcheck-1.0.0-201022-distribution/" +
                "vdmcheck-1.0.0/fmi2vdm-1.0.0.jar"
    )

    @Test
    fun test() {
        ssp("QuarterTruck") {

            validate = false

            resources(pathToVdm) {
                val cl = QuarterTruckTest::class.java.classLoader
                val fmuPath = cl.getResource("quarter-truck")!!.file
                file("$fmuPath/chassis.fmu")
                file("$fmuPath/wheel.fmu")
                file("$fmuPath/ground.fmu")
            }

        }
    }

}
