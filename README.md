# sspgen
A Kotlin DSL for generating [SSP](https://ssp-standard.org/) archives.

`sspgen` will perform some validation of the `SystemStructureDefinition`, 
e.g. checking that connectors exists and that connections are made between the same variable type.

Resources bundled with the generated `.ssp` may be specified both as local files and remote URLs.


#### Pre-requisites

Download the [kotlin-compiler](https://github.com/JetBrains/kotlin/releases/tag/v1.4.20) and add the bin folder to PATH.

OR, simply run the script in the context of IntelliJ, which additionally adds script auto completion.


### Example

Imagine a file named `ExampleSspGen.main.kts` with the following content:

_note_: File names MUST end with `.main.kts`

```kotlin
#!kotlin

@file:Repository("https://dl.bintray.com/ntnu-ihb/mvn")
@file:DependsOn("no.ntnu.ihb.sspgen:dsl:0.4.0")

import no.ntnu.ihb.sspgen.dsl.*

ssp("TestSsdGen") {
    
    resources {
        file("path/to/FMU1.fmu")
        file("path/to/FMU2.fmu")
        url("example.com/someFile.txt")
    }

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

}.build()

```

Executing `./ExampleSsdGen.main.kts` in a shell would result
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

Another convenient feature of the DSL is the ability for copying connectors and parameterSets from one component to
another. Additionally, [OSP-IS](https://opensimulationplatform.com/specification/) is supported, allowing high-level
connections to be formed.


#### API

```kotlin 
ssp(archiveName: String) {

    resources {
        file(path: String)
        url(path: String)
    }

    ssd(name: String) {

        author: String
        description: String
        fileVersion: String
        copyright: String
        license: String
        
        system(name: String) {

            description: String

            elements {
                component(name: String, source: String) {
                    connectors {
                        integer(name: String, kind: String)
                        real(name: String, kind: String) {
                            unit(name: String)
                        }
                        string(name: String, kind: String)
                        boolean(name: String, kind: String)
                        enumeration(name: String, kind: String)
                        copyFrom(componentName: String) {
                            //declare additional connectors as above
                        }       
                    }
                    parameterBindings {
                        parameterSet(name: String) {
                            integer(name: String, value: Int)
                            real(name: String, value: Number)
                            string(name: String, value: String)
                            boolean(name: String, value: Boolean)
                            enumeration(name: String, value: String)
                            copyFrom(componentName: String, parameterSetName: String) {
                                //declare additional parameters or override existing ones
                            }       
                        }
                    }              
                    annotations {
                        annotation(rawString: String) {
                            // e.g: 
                            """
                            <MyElement>
                                <ChildElement value="something"/>
                            </MyElement>
                            """
                        }
                        copyFrom(component: String)       
                    }
                }
            }
            connections(inputsFirst: Boolean = false) {
                "StartElement.StartConnector" to "EndElement.EndConnector" //inputsFirst=true swaps this
            }
            ospConnections {
                "component1.bond" to "component2.bond"
            }      
        }

        defaultExperiment(startTime: Number, stopTime: Number) {       
            annotations {
                annotation(rawString: String) {
                    // e.g: 
                    """
                    <MyElement>
                        <ChildElement value="something"/>
                    </MyElement>
                    """
                }   
    
            }

        }

    }

    namespaces {
        namespace(namespace: String, uri: String)
    }

}

```

#### Integration with FMI-VDM-Model

sspgen integrates with [FMI-VDM-Model](https://github.com/INTO-CPS-Association/FMI-VDM-Model), allowing optional static
ananysis of the included FMUs for informative purposes. To use, simply provide the path to the `fmi2vdm.jar` when
invoking `validate` or `build`.

#### Gradle plugin

sspgen exists as a gradle plugin. To use it, add the following to `settings.gradle`:

```groovy
pluginManagement {
    repositories {
        mavenCentral()
        maven { url "https://plugins.gradle.org/m2/" }
        maven { url "https://dl.bintray.com/ntnu-ihb/mvn" }
    }
}
```

And apply the plugin as usual:

```groovy
plugins {
    id 'no.ntnu.ihb.sspgen' version '0.x.x'
}

sspgen {
    outputDir: String
    files: List<String>
    urls: List<String>
}

```
