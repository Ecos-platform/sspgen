
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group must contain exactly 1 Torque and exactly 1 AngularDisplacement, where the causalities of the two groups must be opposite of each other. The xml schema validates that the element contains the correct child elements, and the OSP-IS validator verifies the causalities.
 *
 * <p>Java class for AngularMechanicalQuasiPortType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AngularMechanicalQuasiPortType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Torque" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}TorqueType"/>
 *         &lt;element name="AngularDisplacement" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularDisplacementType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AngularMechanicalQuasiPortType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "torque",
        "angularDisplacement"
})
public class AngularMechanicalQuasiPortType {

    @XmlElement(name = "Torque", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected TorqueType torque;
    @XmlElement(name = "AngularDisplacement", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected AngularDisplacementType angularDisplacement;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the torque property.
     *
     * @return possible object is
     * {@link TorqueType }
     */
    public TorqueType getTorque() {
        return torque;
    }

    /**
     * Sets the value of the torque property.
     *
     * @param value allowed object is
     *              {@link TorqueType }
     */
    public void setTorque(TorqueType value) {
        this.torque = value;
    }

    /**
     * Gets the value of the angularDisplacement property.
     *
     * @return possible object is
     * {@link AngularDisplacementType }
     */
    public AngularDisplacementType getAngularDisplacement() {
        return angularDisplacement;
    }

    /**
     * Sets the value of the angularDisplacement property.
     *
     * @param value allowed object is
     *              {@link AngularDisplacementType }
     */
    public void setAngularDisplacement(AngularDisplacementType value) {
        this.angularDisplacement = value;
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
