
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Variables grouped under this element is defined to represent a angular displacement. The xml schema validates the number of contained Variable elements, and the OSP-IS validator checks that the causalities are correct.
 *
 * <p>Java class for AngularDisplacementType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AngularDisplacementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Variable" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableType" maxOccurs="3"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AngularDisplacementType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "variable"
})
@XmlSeeAlso({
        AzimuthAngleType.class,
        BladePitchType.class
})
public class AngularDisplacementType {

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
