
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group represents feedbacks used for communications between fixed thruster controllers and fixed thrusters and can contain 1 ShaftSpeed describing the actual shaft speed of the propeller and exactly 1 Force representing the generated force(s). It can also contain 1 BladePitch describing the actual pitch of the propeller blades.
 *
 * <p>Java class for FixedThrusterFeedbackType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FixedThrusterFeedbackType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShaftSpeed" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ShaftSpeedType" minOccurs="0"/>
 *         &lt;element name="BladePitch" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}BladePitchType" minOccurs="0"/>
 *         &lt;element name="Force" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ForceType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FixedThrusterFeedbackType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "shaftSpeed",
        "bladePitch",
        "force"
})
public class FixedThrusterFeedbackType {

    @XmlElement(name = "ShaftSpeed", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected ShaftSpeedType shaftSpeed;
    @XmlElement(name = "BladePitch", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected BladePitchType bladePitch;
    @XmlElement(name = "Force", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected ForceType force;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the shaftSpeed property.
     *
     * @return possible object is
     * {@link ShaftSpeedType }
     */
    public ShaftSpeedType getShaftSpeed() {
        return shaftSpeed;
    }

    /**
     * Sets the value of the shaftSpeed property.
     *
     * @param value allowed object is
     *              {@link ShaftSpeedType }
     */
    public void setShaftSpeed(ShaftSpeedType value) {
        this.shaftSpeed = value;
    }

    /**
     * Gets the value of the bladePitch property.
     *
     * @return possible object is
     * {@link BladePitchType }
     */
    public BladePitchType getBladePitch() {
        return bladePitch;
    }

    /**
     * Sets the value of the bladePitch property.
     *
     * @param value allowed object is
     *              {@link BladePitchType }
     */
    public void setBladePitch(BladePitchType value) {
        this.bladePitch = value;
    }

    /**
     * Gets the value of the force property.
     *
     * @return possible object is
     * {@link ForceType }
     */
    public ForceType getForce() {
        return force;
    }

    /**
     * Sets the value of the force property.
     *
     * @param value allowed object is
     *              {@link ForceType }
     */
    public void setForce(ForceType value) {
        this.force = value;
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
