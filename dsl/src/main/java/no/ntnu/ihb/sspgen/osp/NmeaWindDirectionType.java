
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This group contains exactly 2 variables which represent the wind direction part for an NMEA MWV message. The contained variables specify the following:
 * 1. Wind angle in degrees (0 to 359 degrees)
 * 2. Wind direction reference ("R" for "relative" or "T" or "true")
 * The variables must all have the same causality and appear in the order specified above.
 *
 * <p>Java class for NmeaWindDirectionType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NmeaWindDirectionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Variable" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableType" maxOccurs="2" minOccurs="2"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NmeaWindDirectionType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "variable"
})
public class NmeaWindDirectionType {

    @XmlElement(name = "Variable", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected List<VariableType> variable;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the variable property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the variable property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVariable().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VariableType }
     */
    public List<VariableType> getVariable() {
        if (variable == null) {
            variable = new ArrayList<VariableType>();
        }
        return this.variable;
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
