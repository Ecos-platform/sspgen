
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * This group contains exactly 7 variables which describes NMEA GPS fix information. The contained variables represent the following
 * 1.Quality
 * 2. Number of satellites
 * 3. Horizontal dilution
 * 4. Antenna altitude
 * 5. Geoidal separation
 * 6. GPS age
 * 7. Station ID
 * The variables must all have the same causality and appear in the order specified above.
 *
 * <p>Java class for NmeaGgaFixType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NmeaGgaFixType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Variable" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableType" maxOccurs="7" minOccurs="7"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NmeaGgaFixType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "variable"
})
public class NmeaGgaFixType {

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
