
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group represents an NMEA THS message and contains exactly 1 NmeaTrueHeading and exactly 1 NmeaStatus.
 *
 * <p>Java class for NmeaThsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NmeaThsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NmeaTrueHeading" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaTrueHeadingType"/>
 *         &lt;element name="NmeaStatus" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaStatusType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NmeaThsType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "nmeaTrueHeading",
        "nmeaStatus"
})
public class NmeaThsType {

    @XmlElement(name = "NmeaTrueHeading", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected NmeaTrueHeadingType nmeaTrueHeading;
    @XmlElement(name = "NmeaStatus", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected NmeaStatusType nmeaStatus;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the nmeaTrueHeading property.
     *
     * @return possible object is
     * {@link NmeaTrueHeadingType }
     */
    public NmeaTrueHeadingType getNmeaTrueHeading() {
        return nmeaTrueHeading;
    }

    /**
     * Sets the value of the nmeaTrueHeading property.
     *
     * @param value allowed object is
     *              {@link NmeaTrueHeadingType }
     */
    public void setNmeaTrueHeading(NmeaTrueHeadingType value) {
        this.nmeaTrueHeading = value;
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
