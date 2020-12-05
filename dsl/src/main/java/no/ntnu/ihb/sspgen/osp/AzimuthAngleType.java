
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Variable group of type AngularDisplacement with exactly 1 Variable, which is meant to represent the angle of a azimuth thruster.
 *
 * <p>Java class for AzimuthAngleType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AzimuthAngleType">
 *   &lt;complexContent>
 *     &lt;restriction base="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularDisplacementType">
 *       &lt;sequence>
 *         &lt;element name="Variable" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VariableType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AzimuthAngleType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
public class AzimuthAngleType
        extends AngularDisplacementType {


}
