
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * Root element of document
 *
 * <p>Java class for OspModelDescriptionType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OspModelDescriptionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="UnitDefinitions" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}UnitDefinitionsType" minOccurs="0"/>
 *         &lt;element name="VariableGroups" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableGroupsType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}string" fixed="1.0" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OspModelDescriptionType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "unitDefinitions",
        "variableGroups"
})
public class OspModelDescriptionType {

    @XmlElement(name = "UnitDefinitions", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected UnitDefinitionsType unitDefinitions;
    @XmlElement(name = "VariableGroups", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected VariableGroupsType variableGroups;
    @XmlAttribute(name = "version", required = true)
    protected String version;

    /**
     * Gets the value of the unitDefinitions property.
     *
     * @return possible object is
     * {@link UnitDefinitionsType }
     */
    public UnitDefinitionsType getUnitDefinitions() {
        return unitDefinitions;
    }

    /**
     * Sets the value of the unitDefinitions property.
     *
     * @param value allowed object is
     *              {@link UnitDefinitionsType }
     */
    public void setUnitDefinitions(UnitDefinitionsType value) {
        this.unitDefinitions = value;
    }

    /**
     * Gets the value of the variableGroups property.
     *
     * @return possible object is
     * {@link VariableGroupsType }
     */
    public VariableGroupsType getVariableGroups() {
        return variableGroups;
    }

    /**
     * Sets the value of the variableGroups property.
     *
     * @param value allowed object is
     *              {@link VariableGroupsType }
     */
    public void setVariableGroups(VariableGroupsType value) {
        this.variableGroups = value;
    }

    /**
     * Gets the value of the version property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getVersion() {
        if (version == null) {
            return "1.0";
        } else {
            return version;
        }
    }

    /**
     * Sets the value of the version property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setVersion(String value) {
        this.version = value;
    }

}
