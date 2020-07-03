# SSP-DSL
A Command Line Application for generating SSP archives from a Kotlin script
using a custom Domain Specific Language (DSL).

### Example

Imagine a file named `ExampleSspGen.kts` with the following content:

```kotlin

ssp("TestSsdGen") {

    ssd("A simple CLI test") {

        author = "John Doe"
        description = "A simple description"

        system("Test") {

            description = "An even simpler description"

            elements {
                component("FMU1", "fmus/FMU1.fmu") {
                    connectors {
                        realConnector("output", Kind.output) {
                            unit("m/s")
                        }
                        realConnector("input", Kind.input)
                        integerConnector("counter", Kind.output)
                    }
                    parameterbindings {
                        parameterSet("initalValues") {
                            real("input", 2.0)
                            integer("counter", 99)
                        }
                    }
                    annotations {
                        annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                            """
                            <TestElement/>
                        """.trimIndent()
                        }
                    }
                }
                component("FMU2", "fmus/FMU2.fmu") {
                    connectors {
                        realConnector("input", Kind.input)
                        realConnector("output", Kind.output)
                    }
                }
            }

            connections {
                "FMU2.output" to "FMU1.input"
                ("FMU1.output" to "FMU2.input").linearTransformation(factor = 1.5)
            }

        }

        defaultExperiment(startTime = 1.0) {

            annotations {
                annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                    """
                    <MyElement value="90">
                        <MySecondElement/>
                    </MyElement>
                """
                }
            }

        }

    }

}

```

Invoking the following in a shell `./ssdgen ExampleSsdGen.kts` would result
in an SSP archive named `TestSsdGen.ssp` with two FMUs and a `SystemStructure.ssd` with the content:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ssd:SystemStructureDescription xmlns:ssd="http://ssp-standard.org/SSP1/SystemStructureDescription" xmlns:ssc="http://ssp-standard.org/SSP1/SystemStructureCommon" xmlns:ssb="http://ssp-standard.org/SSP1/SystemStructureSignalDictionary" version="1.0" name="A simple CLI test" description="A simple description" author="John Doe" generationTool="sspgen">
    <ssd:System name="Test">
        <ssd:Elements>
            <ssd:Component source="fmus/FMU1.fmu" name="FMU1">
                <ssd:Connectors>
                    <ssd:Connector name="output" kind="output">
                        <ssc:Real unit="m/s"/>
                    </ssd:Connector>
                    <ssd:Connector name="input" kind="input">
                        <ssc:Real/>
                    </ssd:Connector>
                    <ssd:Connector name="counter" kind="output">
                        <ssc:Integer/>
                    </ssd:Connector>
                </ssd:Connectors>
                <ssd:ParameterBindings>
                    <ssd:ParameterBinding>
                        <ssd:ParameterValues>
                            <ssv:ParameterSet version="1.0" name="initalValues">
                                <ssv:Parameters>
                                    <ssv:Parameter name="input">
                                        <ssv:Real value="2.0"/>
                                    </ssv:Parameter>
                                    <ssv:Parameter name="counter">
                                        <ssv:Integer value="99"/>
                                    </ssv:Parameter>
                                </ssv:Parameters>
                            </ssv:ParameterSet>
                        </ssd:ParameterValues>
                    </ssd:ParameterBinding>
                </ssd:ParameterBindings>
                <ssd:Annotations>
                    <ssc:Annotation type="no.ntnu.ihb.ssp.MyAnnotation">
                        <TestElement/>
                    </ssc:Annotation>
                </ssd:Annotations>
            </ssd:Component>
            <ssd:Component source="fmus/FMU2.fmu" name="FMU2">
                <ssd:Connectors>
                    <ssd:Connector name="input" kind="input">
                        <ssc:Real/>
                    </ssd:Connector>
                    <ssd:Connector name="output" kind="output">
                        <ssc:Real/>
                    </ssd:Connector>
                </ssd:Connectors>
            </ssd:Component>
        </ssd:Elements>
        <ssd:Connections>
            <ssd:Connection startElement="FMU2" startConnector="output" endElement="FMU1" endConnector="input"/>
            <ssd:Connection startElement="FMU1" startConnector="output" endElement="FMU2" endConnector="input">
                <ssc:LinearTransformation factor="1.5" offset="0.0"/>
            </ssd:Connection>
        </ssd:Connections>
    </ssd:System>
    <ssd:DefaultExperiment startTime="1.0">
        <ssd:Annotations>
            <ssc:Annotation type="no.ntnu.ihb.ssp.MyAnnotation">
                <MyElement value="90">
                    <MySecondElement/>
                </MyElement>
            </ssc:Annotation>
        </ssd:Annotations>
    </ssd:DefaultExperiment>
</ssd:SystemStructureDescription>

```
