
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * Variable group of type AngularDisplacement with exactly 1 Variable, which is meant to represent the blade pitch of propeller blades.
 *
 * <p>Java class for BladePitchType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="BladePitchType">
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
@XmlType(name = "BladePitchType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
public class BladePitchType
        extends AngularDisplacementType {


}
