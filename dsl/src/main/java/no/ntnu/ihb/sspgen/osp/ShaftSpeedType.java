
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Variable group of type AngularVelocity with exactly 1 Variable, which is meant to represent the angular velocity of a rotating shaft.
 *
 * <p>Java class for ShaftSpeedType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ShaftSpeedType">
 *   &lt;complexContent>
 *     &lt;restriction base="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularVelocityType">
 *       &lt;sequence>
 *         &lt;element name="Variable" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShaftSpeedType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
public class ShaftSpeedType
        extends AngularVelocityType {


}
