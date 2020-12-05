
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group contains exactly 1 variable representing NMEA status information used in several NMEA messages.
 *
 * <p>Java class for NmeaStatusType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NmeaStatusType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Variable" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NmeaStatusType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "variable"
})
public class NmeaStatusType {

    @XmlElement(name = "Variable", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected VariableType variable;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the variable property.
     *
     * @return possible object is
     * {@link VariableType }
     */
    public VariableType getVariable() {
        return variable;
    }

    /**
     * Sets the value of the variable property.
     *
     * @param value allowed object is
     *              {@link VariableType }
     */
    public void setVariable(VariableType value) {
        this.variable = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

}
