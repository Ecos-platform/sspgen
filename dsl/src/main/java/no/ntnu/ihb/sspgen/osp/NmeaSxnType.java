
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group represents a proprietary Kongsberg Seatex NMEA SXN message and contains exactly 1 AngularDisplacement and exactly 1 NmeaStatus.
 * AngularDisplacement must contain exactly 2 variables where the first one represents roll and the second represents pitch with radians ([rad]) as units.
 *
 * <p>Java class for NmeaSxnType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NmeaSxnType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AngularDisplacement" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularDisplacementType"/>
 *         &lt;element name="NmeaStatus" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaStatusType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NmeaSxnType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "angularDisplacement",
        "nmeaStatus"
})
public class NmeaSxnType {

    @XmlElement(name = "AngularDisplacement", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected AngularDisplacementType angularDisplacement;
    @XmlElement(name = "NmeaStatus", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected NmeaStatusType nmeaStatus;
    @XmlAttribute(name = "name", required = true)
    protected String name;

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
     * Gets the value of the nmeaStatus property.
     *
     * @return possible object is
     * {@link NmeaStatusType }
     */
    public NmeaStatusType getNmeaStatus() {
        return nmeaStatus;
    }

    /**
     * Sets the value of the nmeaStatus property.
     *
     * @param value allowed object is
     *              {@link NmeaStatusType }
     */
    public void setNmeaStatus(NmeaStatusType value) {
        this.nmeaStatus = value;
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
