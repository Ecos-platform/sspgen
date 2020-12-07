
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group must contain exactly 1 Torque and exactly 1 AngularVelocity, where the causalities of the two groups must be opposite of each other. The xml schema validates that the element contains the correct child elements, and the OSP-IS validator verifies the causalities.
 *
 * <p>Java class for AngularMechanicalPortType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AngularMechanicalPortType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Torque" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}TorqueType"/>
 *         &lt;element name="AngularVelocity" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularVelocityType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AngularMechanicalPortType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "torque",
        "angularVelocity"
})
public class AngularMechanicalPortType {

    @XmlElement(name = "Torque", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected TorqueType torque;
    @XmlElement(name = "AngularVelocity", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected AngularVelocityType angularVelocity;
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
     * Gets the value of the angularVelocity property.
     *
     * @return possible object is
     * {@link AngularVelocityType }
     */
    public AngularVelocityType getAngularVelocity() {
        return angularVelocity;
    }

    /**
     * Sets the value of the angularVelocity property.
     *
     * @param value allowed object is
     *              {@link AngularVelocityType }
     */
    public void setAngularVelocity(AngularVelocityType value) {
        this.angularVelocity = value;
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
