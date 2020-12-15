package no.ntnu.ihb.sspgen.dsl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class QuarterTruckOspTest {

    @Test
    fun testOspModelDescriptionRetrieval() {
        Assertions.assertDoesNotThrow {
            validSspDefinition.validate()
        }
        Assertions.assertEquals(3, validSspDefinition.ospModelDescriptions.size)
    }

    private companion object {

        val validSspDefinition = ssp("QuarterTruck") {

            resources {
                val cl = QuarterTruckOspTest::class.java.classLoader
                val fmuPath = cl.getResource("quarter-truck")!!.file
                file("$fmuPath/chassis.fmu")
                file("$fmuPath/wheel.fmu")
                file("$fmuPath/ground.fmu")
            }

            ssd("QuarterTruck") {

                system("QuarterTruck") {

                    elements {

                        component("chassis", "resources/chassis.fmu") {
                            connectors {
                                real("p.e", output)
                                real("p.f", input)
                            }
                        }

                        component("wheel", "resources/wheel.fmu") {
                            connectors {
                                real("p.f", input)
                                real("p1.e", input)
                                real("p.e", output)
                                real("p1.f", output)
                            }
                        }

                        component("ground", "resources/ground.fmu") {
                            connectors {
                                real("p.e", input)
                                real("p.f", output)
                            }
                        }

                    }

                    ospConnections {
                        "chassis.linear mechanical port" to "wheel.chassis port"
                        "wheel.ground port" to "ground.linear mechanical port"
                    }

                }

            }

            namespaces {

            }

        }

    }

}
