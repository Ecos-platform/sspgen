
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group must contain exactly 1 Pressure and exactly 1 VolumeFlowRate, where the causalities of the two groups must be opposite of each other. The xml schema validates that the element contains the correct child elements, and the OSP-IS validator verifies the causalities.
 *
 * <p>Java class for HydraulicPortType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HydraulicPortType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pressure" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}PressureType"/>
 *         &lt;element name="VolumeFlowRate" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VolumeFlowRateType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HydraulicPortType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "pressure",
        "volumeFlowRate"
})
public class HydraulicPortType {

    @XmlElement(name = "Pressure", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected PressureType pressure;
    @XmlElement(name = "VolumeFlowRate", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected VolumeFlowRateType volumeFlowRate;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the pressure property.
     *
     * @return possible object is
     * {@link PressureType }
     */
    public PressureType getPressure() {
        return pressure;
    }

    /**
     * Sets the value of the pressure property.
     *
     * @param value allowed object is
     *              {@link PressureType }
     */
    public void setPressure(PressureType value) {
        this.pressure = value;
    }

    /**
     * Gets the value of the volumeFlowRate property.
     *
     * @return possible object is
     * {@link VolumeFlowRateType }
     */
    public VolumeFlowRateType getVolumeFlowRate() {
        return volumeFlowRate;
    }

    /**
     * Sets the value of the volumeFlowRate property.
     *
     * @param value allowed object is
     *              {@link VolumeFlowRateType }
     */
    public void setVolumeFlowRate(VolumeFlowRateType value) {
        this.volumeFlowRate = value;
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
