package no.ntnu.ihb.sspgen

import no.ntnu.ihb.sspgen.dsl.ssp
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NamespaceTest {

    @Test
    fun testNamespace() {

        val xml = ssp("") {

            ssd("") {}

            namespaces {
                namespace("osp", "http://opensimulationplatform.com/SSP/OSPAnnotations")
            }

        }.ssdXml()

        Assertions.assertTrue("xmlns:osp=" in xml)

    }

}
