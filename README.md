# sspgen
A Command Line Application for generating SSP archives from a Kotlin script
using a custom Domain Specific Language (DSL).

### Example

Imagine a file named `ExampleSspGen.kts` with the following content:

```kotlin
#!sspgen

ssp("TestSsdGen") {

    ssd("A simple CLI test") {

        author = "John Doe"
        description = "A simple description"

        system("Test") {

            description = "An even simpler description"

            elements {
                component("FMU1", "resources/FMU1.fmu") {
                    connectors {
                        real("output", output) {
                            unit("m/s")
                        }
                        real("input", input)
                        integer("counter", output)
                    }
                    parameterBindings {
                        parameterSet("initialValues") {
                            real("input", 2.0)
                            integer("counter", 99)
                        }
                    }
                }
                component("FMU2", "resources/FMU2.fmu") {
                    connectors {
                        real("input", input)
                        real("output", output)
                    }
                }
            }

            connections {
                "FMU2.output" to "FMU1.input"
                ("FMU1.output" to "FMU2.input").linearTransformation(factor = 1.5)
            }

        }

        defaultExperiment(startTime = 1.0)

    }

    resources {
        file("path/to/FMU1.fmu")
        file("path/to/FMU2.fmu")
        url("example.com/someFile.txt")
    }

}

```

Executiong `./ExampleSsdGen.kts` in a shell would result
in an SSP archive named `TestSsdGen.ssp` with two FMUs and `someFile.txt` located 
under `/resources` and a `SystemStructure.ssd` in the root directory with the content:

```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<ssd:SystemStructureDescription xmlns:ssd="http://ssp-standard.org/SSP1/SystemStructureDescription" xmlns:ssc="http://ssp-standard.org/SSP1/SystemStructureCommon" xmlns:ssb="http://ssp-standard.org/SSP1/SystemStructureSignalDictionary" version="1.0" name="A simple CLI test" description="A simple description" author="John Doe" generationTool="sspgen">
    <ssd:System name="Test">
        <ssd:Elements>
            <ssd:Component source="resources/FMU1.fmu" name="FMU1">
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
                            <ssv:ParameterSet version="1.0" name="initialValues">
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
            </ssd:Component>
            <ssd:Component source="resources/FMU2.fmu" name="FMU2">
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
    <ssd:DefaultExperiment startTime="1.0"/>
</ssd:SystemStructureDescription>

```
