# SSP-DSL
Command Line Interface (CLI) for generating SSP archives from a Kotlin scrip
using a custom Domain Specific Language (DSL)

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
                        realConnector("realValue", Kind.input) {
                            unit("m/s")
                        }
                        integerConnector("integerValue", Kind.output)
                    }
                    parameterBindings {

                    }
                    annotations {
                        annotation("no.ntnu.ihb.ssp.MyAnnotation") {
                            """
                            <TestElement/>
                        """.trimIndent()
                        }
                    }
                }
                component("FMU2", "fmus/FMU2.fmu")
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
    
    fmus {
        fmu("path/to/FMU1.fmu")
        fmu("path/to/FMU2.fmu")
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
                    <ssd:Connector name="realValue" kind="input">
                        <ssc:Real unit="m/s"/>
                    </ssd:Connector>
                    <ssd:Connector name="integerValue" kind="output">
                        <ssc:Integer/>
                    </ssd:Connector>
                </ssd:Connectors>
                <ssd:Annotations>
                    <ssc:Annotation type="no.ntnu.ihb.ssp.MyAnnotation">
                        <TestElement/>
                    </ssc:Annotation>
                </ssd:Annotations>
            </ssd:Component>
            <ssd:Component source="fmus/FMU2.fmu" name="FMU2"/>
        </ssd:Elements>
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
