
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Using same method to define units as in fmi2Unit.xsd, but have extended it with one more BaseUnit: percent.
 *
 * <p>Java class for UnitType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UnitType">
 *   &lt;complexContent>
 *     &lt;extension base="{https://open-simulation-platform.com/OspModelDescription/1.0.0}fmi2Unit">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UnitType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
public class UnitType
        extends Fmi2Unit {


}
