package no.ntnu.ihb.sspgen.dsl

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NamespaceTest {

    @Test
    fun testNamespace() {

        ssp("dummyArchive") {

            val xml = ssd("dummySsd") {

                namespaces {
                    namespace("osp", "http://opensimulationplatform.com/SSP/OSPAnnotations")
                }

            }.ssdXml()

            Assertions.assertTrue("xmlns:osp=" in xml)

        }

    }

}
