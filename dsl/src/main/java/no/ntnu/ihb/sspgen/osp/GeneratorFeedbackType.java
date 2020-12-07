
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group represents feedback sent from a generator and contains exactly 1 ElectricPower (representing the power delivered presently), exactly 1 Voltage, and exactly 1 Frequency.
 *
 * <p>Java class for GeneratorFeedbackType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GeneratorFeedbackType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ElectricPower" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ElectricPowerType"/>
 *         &lt;element name="Voltage" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VoltageType"/>
 *         &lt;element name="Frequency" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}FrequencyType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeneratorFeedbackType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "electricPower",
        "voltage",
        "frequency"
})
public class GeneratorFeedbackType {

    @XmlElement(name = "ElectricPower", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected ElectricPowerType electricPower;
    @XmlElement(name = "Voltage", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected VoltageType voltage;
    @XmlElement(name = "Frequency", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected FrequencyType frequency;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the electricPower property.
     *
     * @return possible object is
     * {@link ElectricPowerType }
     */
    public ElectricPowerType getElectricPower() {
        return electricPower;
    }

    /**
     * Sets the value of the electricPower property.
     *
     * @param value allowed object is
     *              {@link ElectricPowerType }
     */
    public void setElectricPower(ElectricPowerType value) {
        this.electricPower = value;
    }

    /**
     * Gets the value of the voltage property.
     *
     * @return possible object is
     * {@link VoltageType }
     */
    public VoltageType getVoltage() {
        return voltage;
    }

    /**
     * Sets the value of the voltage property.
     *
     * @param value allowed object is
     *              {@link VoltageType }
     */
    public void setVoltage(VoltageType value) {
        this.voltage = value;
    }

    /**
     * Gets the value of the frequency property.
     *
     * @return possible object is
     * {@link FrequencyType }
     */
    public FrequencyType getFrequency() {
        return frequency;
    }

    /**
     * Sets the value of the frequency property.
     *
     * @param value allowed object is
     *              {@link FrequencyType }
     */
    public void setFrequency(FrequencyType value) {
        this.frequency = value;
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
