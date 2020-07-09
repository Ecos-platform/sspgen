package no.ntnu.ihb.sspgen

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NamespaceTest {

    @Test
    fun testNamespace() {

        val script = NamespaceTest::class.java.classLoader.getResource("namespace.kts")!!

        evaluateScript(script.openStream()).apply {
            val xml = ssdXml()
            Assertions.assertTrue("xlmns:osp=" in xml)
        }

    }

}
