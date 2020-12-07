
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group must contain exactly 1 Voltage and exactly 1 Charge, where the causalities of the two groups must be opposite of each other. The xml schema validates that the element contains the correct child elements, and the OSP-IS validator verifies the causalities.
 *
 * <p>Java class for ElectromagneticQuasiPortType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ElectromagneticQuasiPortType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Voltage" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VoltageType"/>
 *         &lt;element name="Charge" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ChargeType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ElectromagneticQuasiPortType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "voltage",
        "charge"
})
public class ElectromagneticQuasiPortType {

    @XmlElement(name = "Voltage", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected VoltageType voltage;
    @XmlElement(name = "Charge", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected ChargeType charge;
    @XmlAttribute(name = "name", required = true)
    protected String name;

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
     * Gets the value of the charge property.
     *
     * @return possible object is
     * {@link ChargeType }
     */
    public ChargeType getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     *
     * @param value allowed object is
     *              {@link ChargeType }
     */
    public void setCharge(ChargeType value) {
        this.charge = value;
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
