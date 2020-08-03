# sspgen
A Command Line Application for generating [SSP](https://ssp-standard.org/) archives from a Kotlin script
using a custom Domain Specific Language (DSL).

`sspgen` will perform some validation of the `SystemStructureDefinition`, 
e.g. checking that connectors exists and that connections are made between the same variable type.

Resources bundled with the generated `.ssp` may be specified both as local files and remote URLs.

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

Executing `./ExampleSsdGen.kts` in a shell would result
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

Another convenient feature of the DSL is the ability for copying connectors and parameterSets from one component to another.


#### API

```kotlin 
ssp(archiveName: String) {

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
                    parameterSets {
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

    resources {
        file(path: String)
        url(path: String)
    }

}

```

#### Gradle plugin

sspgen exists as a gradle plugin.
To use it, add the following to `settings.gradle`:

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
    id 'no.ntnu.ihb.sspgen' version '0.1.3'
}

sspgen {
    outputDir: String
    files: List<String>
    urls: List<String>
}

```

#### Prebuilt sspgen executable

Aside from releases, bleeding edge builds of the cli tool can be retrieved from GitHub Actions. 

