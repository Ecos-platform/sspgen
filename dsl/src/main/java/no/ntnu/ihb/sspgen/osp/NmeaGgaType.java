
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.*;


/**
 * This group represents an NMEA GGA message, and contains exactly 1 NmeaTime, exactly 1 NmeaGgaLatitudeLongitude, and exactly 1 NmeaGgaFix.
 *
 * <p>Java class for NmeaGgaType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="NmeaGgaType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="NmeaTime" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaTimeType"/>
 *         &lt;element name="NmeaGgaLatitudeLongitude" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGgaLatitudeLongitudeType"/>
 *         &lt;element name="NmeaGgaFix" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGgaFixType"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NmeaGgaType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "nmeaTime",
        "nmeaGgaLatitudeLongitude",
        "nmeaGgaFix"
})
public class NmeaGgaType {

    @XmlElement(name = "NmeaTime", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected NmeaTimeType nmeaTime;
    @XmlElement(name = "NmeaGgaLatitudeLongitude", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected NmeaGgaLatitudeLongitudeType nmeaGgaLatitudeLongitude;
    @XmlElement(name = "NmeaGgaFix", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", required = true)
    protected NmeaGgaFixType nmeaGgaFix;
    @XmlAttribute(name = "name", required = true)
    protected String name;

    /**
     * Gets the value of the nmeaTime property.
     *
     * @return possible object is
     * {@link NmeaTimeType }
     */
    public NmeaTimeType getNmeaTime() {
        return nmeaTime;
    }

    /**
     * Sets the value of the nmeaTime property.
     *
     * @param value allowed object is
     *              {@link NmeaTimeType }
     */
    public void setNmeaTime(NmeaTimeType value) {
        this.nmeaTime = value;
    }

    /**
     * Gets the value of the nmeaGgaLatitudeLongitude property.
     *
     * @return possible object is
     * {@link NmeaGgaLatitudeLongitudeType }
     */
    public NmeaGgaLatitudeLongitudeType getNmeaGgaLatitudeLongitude() {
        return nmeaGgaLatitudeLongitude;
    }

    /**
     * Sets the value of the nmeaGgaLatitudeLongitude property.
     *
     * @param value allowed object is
     *              {@link NmeaGgaLatitudeLongitudeType }
     */
    public void setNmeaGgaLatitudeLongitude(NmeaGgaLatitudeLongitudeType value) {
        this.nmeaGgaLatitudeLongitude = value;
    }

    /**
     * Gets the value of the nmeaGgaFix property.
     *
     * @return possible object is
     * {@link NmeaGgaFixType }
     */
    public NmeaGgaFixType getNmeaGgaFix() {
        return nmeaGgaFix;
    }

    /**
     * Sets the value of the nmeaGgaFix property.
     *
     * @param value allowed object is
     *              {@link NmeaGgaFixType }
     */
    public void setNmeaGgaFix(NmeaGgaFixType value) {
        this.nmeaGgaFix = value;
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
