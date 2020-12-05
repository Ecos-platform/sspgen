
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group represents setpoints or feedbacks used for communications between azimuth thruster controllers and azimuth thrusters and can contain 1 ShaftSpeed describing the desired rotational velocity of the propeller shaft and exactly 1 AzimuthAngle describing the desired or actual azimuth angle of the thruster. It can also contain 1 BladePitch describing the desired propeller blade pitch.
 *
 * <p>Java class for AzimuthThrusterSetpointType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AzimuthThrusterSetpointType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ShaftSpeed" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ShaftSpeedType" minOccurs="0"/>
 *         &lt;element name="AzimuthAngle" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AzimuthAngleType" minOccurs="0"/>
 *         &lt;element name="BladePitch" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}BladePitchType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AzimuthThrusterSetpointType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "shaftSpeed",
        "azimuthAngle",
        "bladePitch"
})
public class AzimuthThrusterSetpointType {

    @XmlElement(name = "ShaftSpeed", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected ShaftSpeedType shaftSpeed;
    @XmlElement(name = "AzimuthAngle", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected AzimuthAngleType azimuthAngle;
    @XmlElement(name = "BladePitch", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected BladePitchType bladePitch;
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
     * Gets the value of the azimuthAngle property.
     *
     * @return possible object is
     * {@link AzimuthAngleType }
     */
    public AzimuthAngleType getAzimuthAngle() {
        return azimuthAngle;
    }

    /**
     * Sets the value of the azimuthAngle property.
     *
     * @param value allowed object is
     *              {@link AzimuthAngleType }
     */
    public void setAzimuthAngle(AzimuthAngleType value) {
        this.azimuthAngle = value;
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
