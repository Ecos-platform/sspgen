
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * This element contains a list of Unit elements which is defined according to fmi2Unit.xsd. Variables in variable groups can refer to units defined here, or to units defined in the fmi modelDescription.xml, if it is version FMI 2.0 or greater.
 *
 * <p>Java class for UnitDefinitionsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UnitDefinitionsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="Unit" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}UnitType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitDefinitionsType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "unit"
})
public class UnitDefinitionsType {

    @XmlElement(name = "Unit", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<UnitType> unit;

    /**
     * Gets the value of the unit property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the unit property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUnit().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UnitType }
     */
    public List<UnitType> getUnit() {
        if (unit == null) {
            unit = new ArrayList<UnitType>();
        }
        return this.unit;
    }

}
