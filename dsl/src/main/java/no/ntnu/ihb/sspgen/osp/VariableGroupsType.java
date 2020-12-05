
package no.ntnu.ihb.sspgen.osp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * This element contains all the defined variable groups for the model
 *
 * <p>Java class for VariableGroupsType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VariableGroupsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Generic" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}GenericType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Force" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ForceType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Torque" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}TorqueType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Voltage" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VoltageType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Pressure" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}PressureType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinearVelocity" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}LinearVelocityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AngularVelocity" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularVelocityType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Current" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}CurrentType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="VolumeFlowRate" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VolumeFlowRateType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinearDisplacement" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}LinearDisplacementType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AngularDisplacement" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularDisplacementType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Charge" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ChargeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Volume" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}VolumeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinearAcceleration" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}LinearAccelerationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AngularAcceleration" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularAccelerationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinearMechanicalPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}LinearMechanicalPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AngularMechanicalPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularMechanicalPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ElectromagneticPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ElectromagneticPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HydraulicPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}HydraulicPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="LinearMechanicalQuasiPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}LinearMechanicalQuasiPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AngularMechanicalQuasiPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AngularMechanicalQuasiPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ElectromagneticQuasiPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ElectromagneticQuasiPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="HydraulicQuasiPort" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}HydraulicQuasiPortType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ElectricPower" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ElectricPowerType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Frequency" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}FrequencyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaTime" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaTimeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaStatus" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaStatusType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGgaLatitudeLongitude" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGgaLatitudeLongitudeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGgaFix" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGgaFixType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGga" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGgaType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGstRms" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGstRmsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGstEllipse" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGstEllipseType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGstPositionError" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGstPositionErrorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaGst" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaGstType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaWindDirection" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaWindDirectionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaWindSpeed" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaWindSpeedType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaMwv" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaMwvType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaTrueHeading" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaTrueHeadingType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaThs" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaThsType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="NmeaSxn" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}NmeaSxnType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BatteryFeedback" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}BatteryFeedbackType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="GeneratorFeedback" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}GeneratorFeedbackType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BusFeedback" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}BusFeedbackType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ShaftSpeed" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}ShaftSpeedType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AzimuthAngle" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AzimuthAngleType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="BladePitch" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}BladePitchType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FixedThrusterSetpoint" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}FixedThrusterSetpointType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="FixedThrusterFeedback" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}FixedThrusterFeedbackType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AzimuthThrusterSetpoint" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AzimuthThrusterSetpointType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="AzimuthThrusterFeedback" type="{https://open-simulation-platform.com/OspModelDescription/1.0.0}AzimuthThrusterFeedbackType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VariableGroupsType", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0", propOrder = {
        "generic",
        "force",
        "torque",
        "voltage",
        "pressure",
        "linearVelocity",
        "angularVelocity",
        "current",
        "volumeFlowRate",
        "linearDisplacement",
        "angularDisplacement",
        "charge",
        "volume",
        "linearAcceleration",
        "angularAcceleration",
        "linearMechanicalPort",
        "angularMechanicalPort",
        "electromagneticPort",
        "hydraulicPort",
        "linearMechanicalQuasiPort",
        "angularMechanicalQuasiPort",
        "electromagneticQuasiPort",
        "hydraulicQuasiPort",
        "electricPower",
        "frequency",
        "nmeaTime",
        "nmeaStatus",
        "nmeaGgaLatitudeLongitude",
        "nmeaGgaFix",
        "nmeaGga",
        "nmeaGstRms",
        "nmeaGstEllipse",
        "nmeaGstPositionError",
        "nmeaGst",
        "nmeaWindDirection",
        "nmeaWindSpeed",
        "nmeaMwv",
        "nmeaTrueHeading",
        "nmeaThs",
        "nmeaSxn",
        "batteryFeedback",
        "generatorFeedback",
        "busFeedback",
        "shaftSpeed",
        "azimuthAngle",
        "bladePitch",
        "fixedThrusterSetpoint",
        "fixedThrusterFeedback",
        "azimuthThrusterSetpoint",
        "azimuthThrusterFeedback"
})
public class VariableGroupsType {

    @XmlElement(name = "Generic", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<GenericType> generic;
    @XmlElement(name = "Force", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<ForceType> force;
    @XmlElement(name = "Torque", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<TorqueType> torque;
    @XmlElement(name = "Voltage", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<VoltageType> voltage;
    @XmlElement(name = "Pressure", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<PressureType> pressure;
    @XmlElement(name = "LinearVelocity", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<LinearVelocityType> linearVelocity;
    @XmlElement(name = "AngularVelocity", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AngularVelocityType> angularVelocity;
    @XmlElement(name = "Current", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<CurrentType> current;
    @XmlElement(name = "VolumeFlowRate", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<VolumeFlowRateType> volumeFlowRate;
    @XmlElement(name = "LinearDisplacement", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<LinearDisplacementType> linearDisplacement;
    @XmlElement(name = "AngularDisplacement", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AngularDisplacementType> angularDisplacement;
    @XmlElement(name = "Charge", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<ChargeType> charge;
    @XmlElement(name = "Volume", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<VolumeType> volume;
    @XmlElement(name = "LinearAcceleration", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<LinearAccelerationType> linearAcceleration;
    @XmlElement(name = "AngularAcceleration", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AngularAccelerationType> angularAcceleration;
    @XmlElement(name = "LinearMechanicalPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<LinearMechanicalPortType> linearMechanicalPort;
    @XmlElement(name = "AngularMechanicalPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AngularMechanicalPortType> angularMechanicalPort;
    @XmlElement(name = "ElectromagneticPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<ElectromagneticPortType> electromagneticPort;
    @XmlElement(name = "HydraulicPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<HydraulicPortType> hydraulicPort;
    @XmlElement(name = "LinearMechanicalQuasiPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<LinearMechanicalQuasiPortType> linearMechanicalQuasiPort;
    @XmlElement(name = "AngularMechanicalQuasiPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AngularMechanicalQuasiPortType> angularMechanicalQuasiPort;
    @XmlElement(name = "ElectromagneticQuasiPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<ElectromagneticQuasiPortType> electromagneticQuasiPort;
    @XmlElement(name = "HydraulicQuasiPort", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<HydraulicQuasiPortType> hydraulicQuasiPort;
    @XmlElement(name = "ElectricPower", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<ElectricPowerType> electricPower;
    @XmlElement(name = "Frequency", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<FrequencyType> frequency;
    @XmlElement(name = "NmeaTime", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaTimeType> nmeaTime;
    @XmlElement(name = "NmeaStatus", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaStatusType> nmeaStatus;
    @XmlElement(name = "NmeaGgaLatitudeLongitude", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGgaLatitudeLongitudeType> nmeaGgaLatitudeLongitude;
    @XmlElement(name = "NmeaGgaFix", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGgaFixType> nmeaGgaFix;
    @XmlElement(name = "NmeaGga", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGgaType> nmeaGga;
    @XmlElement(name = "NmeaGstRms", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGstRmsType> nmeaGstRms;
    @XmlElement(name = "NmeaGstEllipse", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGstEllipseType> nmeaGstEllipse;
    @XmlElement(name = "NmeaGstPositionError", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGstPositionErrorType> nmeaGstPositionError;
    @XmlElement(name = "NmeaGst", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaGstType> nmeaGst;
    @XmlElement(name = "NmeaWindDirection", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaWindDirectionType> nmeaWindDirection;
    @XmlElement(name = "NmeaWindSpeed", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaWindSpeedType> nmeaWindSpeed;
    @XmlElement(name = "NmeaMwv", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaMwvType> nmeaMwv;
    @XmlElement(name = "NmeaTrueHeading", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaTrueHeadingType> nmeaTrueHeading;
    @XmlElement(name = "NmeaThs", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaThsType> nmeaThs;
    @XmlElement(name = "NmeaSxn", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<NmeaSxnType> nmeaSxn;
    @XmlElement(name = "BatteryFeedback", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<BatteryFeedbackType> batteryFeedback;
    @XmlElement(name = "GeneratorFeedback", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<GeneratorFeedbackType> generatorFeedback;
    @XmlElement(name = "BusFeedback", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<BusFeedbackType> busFeedback;
    @XmlElement(name = "ShaftSpeed", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<ShaftSpeedType> shaftSpeed;
    @XmlElement(name = "AzimuthAngle", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AzimuthAngleType> azimuthAngle;
    @XmlElement(name = "BladePitch", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<BladePitchType> bladePitch;
    @XmlElement(name = "FixedThrusterSetpoint", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<FixedThrusterSetpointType> fixedThrusterSetpoint;
    @XmlElement(name = "FixedThrusterFeedback", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<FixedThrusterFeedbackType> fixedThrusterFeedback;
    @XmlElement(name = "AzimuthThrusterSetpoint", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AzimuthThrusterSetpointType> azimuthThrusterSetpoint;
    @XmlElement(name = "AzimuthThrusterFeedback", namespace = "https://open-simulation-platform.com/OspModelDescription/1.0.0")
    protected List<AzimuthThrusterFeedbackType> azimuthThrusterFeedback;

    /**
     * Gets the value of the generic property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generic property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneric().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericType }
     */
    public List<GenericType> getGeneric() {
        if (generic == null) {
            generic = new ArrayList<GenericType>();
        }
        return this.generic;
    }

    /**
     * Gets the value of the force property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the force property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForce().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ForceType }
     */
    public List<ForceType> getForce() {
        if (force == null) {
            force = new ArrayList<ForceType>();
        }
        return this.force;
    }

    /**
     * Gets the value of the torque property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the torque property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTorque().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TorqueType }
     */
    public List<TorqueType> getTorque() {
        if (torque == null) {
            torque = new ArrayList<TorqueType>();
        }
        return this.torque;
    }

    /**
     * Gets the value of the voltage property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the voltage property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVoltage().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VoltageType }
     */
    public List<VoltageType> getVoltage() {
        if (voltage == null) {
            voltage = new ArrayList<VoltageType>();
        }
        return this.voltage;
    }

    /**
     * Gets the value of the pressure property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pressure property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPressure().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PressureType }
     */
    public List<PressureType> getPressure() {
        if (pressure == null) {
            pressure = new ArrayList<PressureType>();
        }
        return this.pressure;
    }

    /**
     * Gets the value of the linearVelocity property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearVelocity property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearVelocity().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinearVelocityType }
     */
    public List<LinearVelocityType> getLinearVelocity() {
        if (linearVelocity == null) {
            linearVelocity = new ArrayList<LinearVelocityType>();
        }
        return this.linearVelocity;
    }

    /**
     * Gets the value of the angularVelocity property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the angularVelocity property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAngularVelocity().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AngularVelocityType }
     */
    public List<AngularVelocityType> getAngularVelocity() {
        if (angularVelocity == null) {
            angularVelocity = new ArrayList<AngularVelocityType>();
        }
        return this.angularVelocity;
    }

    /**
     * Gets the value of the current property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the current property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCurrent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CurrentType }
     */
    public List<CurrentType> getCurrent() {
        if (current == null) {
            current = new ArrayList<CurrentType>();
        }
        return this.current;
    }

    /**
     * Gets the value of the volumeFlowRate property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the volumeFlowRate property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVolumeFlowRate().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VolumeFlowRateType }
     */
    public List<VolumeFlowRateType> getVolumeFlowRate() {
        if (volumeFlowRate == null) {
            volumeFlowRate = new ArrayList<VolumeFlowRateType>();
        }
        return this.volumeFlowRate;
    }

    /**
     * Gets the value of the linearDisplacement property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearDisplacement property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearDisplacement().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinearDisplacementType }
     */
    public List<LinearDisplacementType> getLinearDisplacement() {
        if (linearDisplacement == null) {
            linearDisplacement = new ArrayList<LinearDisplacementType>();
        }
        return this.linearDisplacement;
    }

    /**
     * Gets the value of the angularDisplacement property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the angularDisplacement property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAngularDisplacement().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AngularDisplacementType }
     */
    public List<AngularDisplacementType> getAngularDisplacement() {
        if (angularDisplacement == null) {
            angularDisplacement = new ArrayList<AngularDisplacementType>();
        }
        return this.angularDisplacement;
    }

    /**
     * Gets the value of the charge property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the charge property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCharge().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChargeType }
     */
    public List<ChargeType> getCharge() {
        if (charge == null) {
            charge = new ArrayList<ChargeType>();
        }
        return this.charge;
    }

    /**
     * Gets the value of the volume property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the volume property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVolume().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VolumeType }
     */
    public List<VolumeType> getVolume() {
        if (volume == null) {
            volume = new ArrayList<VolumeType>();
        }
        return this.volume;
    }

    /**
     * Gets the value of the linearAcceleration property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearAcceleration property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearAcceleration().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinearAccelerationType }
     */
    public List<LinearAccelerationType> getLinearAcceleration() {
        if (linearAcceleration == null) {
            linearAcceleration = new ArrayList<LinearAccelerationType>();
        }
        return this.linearAcceleration;
    }

    /**
     * Gets the value of the angularAcceleration property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the angularAcceleration property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAngularAcceleration().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AngularAccelerationType }
     */
    public List<AngularAccelerationType> getAngularAcceleration() {
        if (angularAcceleration == null) {
            angularAcceleration = new ArrayList<AngularAccelerationType>();
        }
        return this.angularAcceleration;
    }

    /**
     * Gets the value of the linearMechanicalPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearMechanicalPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearMechanicalPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinearMechanicalPortType }
     */
    public List<LinearMechanicalPortType> getLinearMechanicalPort() {
        if (linearMechanicalPort == null) {
            linearMechanicalPort = new ArrayList<LinearMechanicalPortType>();
        }
        return this.linearMechanicalPort;
    }

    /**
     * Gets the value of the angularMechanicalPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the angularMechanicalPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAngularMechanicalPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AngularMechanicalPortType }
     */
    public List<AngularMechanicalPortType> getAngularMechanicalPort() {
        if (angularMechanicalPort == null) {
            angularMechanicalPort = new ArrayList<AngularMechanicalPortType>();
        }
        return this.angularMechanicalPort;
    }

    /**
     * Gets the value of the electromagneticPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electromagneticPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectromagneticPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectromagneticPortType }
     */
    public List<ElectromagneticPortType> getElectromagneticPort() {
        if (electromagneticPort == null) {
            electromagneticPort = new ArrayList<ElectromagneticPortType>();
        }
        return this.electromagneticPort;
    }

    /**
     * Gets the value of the hydraulicPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hydraulicPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHydraulicPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HydraulicPortType }
     */
    public List<HydraulicPortType> getHydraulicPort() {
        if (hydraulicPort == null) {
            hydraulicPort = new ArrayList<HydraulicPortType>();
        }
        return this.hydraulicPort;
    }

    /**
     * Gets the value of the linearMechanicalQuasiPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linearMechanicalQuasiPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinearMechanicalQuasiPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LinearMechanicalQuasiPortType }
     */
    public List<LinearMechanicalQuasiPortType> getLinearMechanicalQuasiPort() {
        if (linearMechanicalQuasiPort == null) {
            linearMechanicalQuasiPort = new ArrayList<LinearMechanicalQuasiPortType>();
        }
        return this.linearMechanicalQuasiPort;
    }

    /**
     * Gets the value of the angularMechanicalQuasiPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the angularMechanicalQuasiPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAngularMechanicalQuasiPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AngularMechanicalQuasiPortType }
     */
    public List<AngularMechanicalQuasiPortType> getAngularMechanicalQuasiPort() {
        if (angularMechanicalQuasiPort == null) {
            angularMechanicalQuasiPort = new ArrayList<AngularMechanicalQuasiPortType>();
        }
        return this.angularMechanicalQuasiPort;
    }

    /**
     * Gets the value of the electromagneticQuasiPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electromagneticQuasiPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectromagneticQuasiPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectromagneticQuasiPortType }
     */
    public List<ElectromagneticQuasiPortType> getElectromagneticQuasiPort() {
        if (electromagneticQuasiPort == null) {
            electromagneticQuasiPort = new ArrayList<ElectromagneticQuasiPortType>();
        }
        return this.electromagneticQuasiPort;
    }

    /**
     * Gets the value of the hydraulicQuasiPort property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the hydraulicQuasiPort property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHydraulicQuasiPort().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link HydraulicQuasiPortType }
     */
    public List<HydraulicQuasiPortType> getHydraulicQuasiPort() {
        if (hydraulicQuasiPort == null) {
            hydraulicQuasiPort = new ArrayList<HydraulicQuasiPortType>();
        }
        return this.hydraulicQuasiPort;
    }

    /**
     * Gets the value of the electricPower property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the electricPower property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getElectricPower().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ElectricPowerType }
     */
    public List<ElectricPowerType> getElectricPower() {
        if (electricPower == null) {
            electricPower = new ArrayList<ElectricPowerType>();
        }
        return this.electricPower;
    }

    /**
     * Gets the value of the frequency property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the frequency property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFrequency().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FrequencyType }
     */
    public List<FrequencyType> getFrequency() {
        if (frequency == null) {
            frequency = new ArrayList<FrequencyType>();
        }
        return this.frequency;
    }

    /**
     * Gets the value of the nmeaTime property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaTime property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaTime().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaTimeType }
     */
    public List<NmeaTimeType> getNmeaTime() {
        if (nmeaTime == null) {
            nmeaTime = new ArrayList<NmeaTimeType>();
        }
        return this.nmeaTime;
    }

    /**
     * Gets the value of the nmeaStatus property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaStatus property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaStatus().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaStatusType }
     */
    public List<NmeaStatusType> getNmeaStatus() {
        if (nmeaStatus == null) {
            nmeaStatus = new ArrayList<NmeaStatusType>();
        }
        return this.nmeaStatus;
    }

    /**
     * Gets the value of the nmeaGgaLatitudeLongitude property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGgaLatitudeLongitude property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGgaLatitudeLongitude().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGgaLatitudeLongitudeType }
     */
    public List<NmeaGgaLatitudeLongitudeType> getNmeaGgaLatitudeLongitude() {
        if (nmeaGgaLatitudeLongitude == null) {
            nmeaGgaLatitudeLongitude = new ArrayList<NmeaGgaLatitudeLongitudeType>();
        }
        return this.nmeaGgaLatitudeLongitude;
    }

    /**
     * Gets the value of the nmeaGgaFix property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGgaFix property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGgaFix().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGgaFixType }
     */
    public List<NmeaGgaFixType> getNmeaGgaFix() {
        if (nmeaGgaFix == null) {
            nmeaGgaFix = new ArrayList<NmeaGgaFixType>();
        }
        return this.nmeaGgaFix;
    }

    /**
     * Gets the value of the nmeaGga property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGga property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGga().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGgaType }
     */
    public List<NmeaGgaType> getNmeaGga() {
        if (nmeaGga == null) {
            nmeaGga = new ArrayList<NmeaGgaType>();
        }
        return this.nmeaGga;
    }

    /**
     * Gets the value of the nmeaGstRms property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGstRms property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGstRms().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGstRmsType }
     */
    public List<NmeaGstRmsType> getNmeaGstRms() {
        if (nmeaGstRms == null) {
            nmeaGstRms = new ArrayList<NmeaGstRmsType>();
        }
        return this.nmeaGstRms;
    }

    /**
     * Gets the value of the nmeaGstEllipse property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGstEllipse property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGstEllipse().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGstEllipseType }
     */
    public List<NmeaGstEllipseType> getNmeaGstEllipse() {
        if (nmeaGstEllipse == null) {
            nmeaGstEllipse = new ArrayList<NmeaGstEllipseType>();
        }
        return this.nmeaGstEllipse;
    }

    /**
     * Gets the value of the nmeaGstPositionError property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGstPositionError property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGstPositionError().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGstPositionErrorType }
     */
    public List<NmeaGstPositionErrorType> getNmeaGstPositionError() {
        if (nmeaGstPositionError == null) {
            nmeaGstPositionError = new ArrayList<NmeaGstPositionErrorType>();
        }
        return this.nmeaGstPositionError;
    }

    /**
     * Gets the value of the nmeaGst property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaGst property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaGst().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaGstType }
     */
    public List<NmeaGstType> getNmeaGst() {
        if (nmeaGst == null) {
            nmeaGst = new ArrayList<NmeaGstType>();
        }
        return this.nmeaGst;
    }

    /**
     * Gets the value of the nmeaWindDirection property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaWindDirection property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaWindDirection().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaWindDirectionType }
     */
    public List<NmeaWindDirectionType> getNmeaWindDirection() {
        if (nmeaWindDirection == null) {
            nmeaWindDirection = new ArrayList<NmeaWindDirectionType>();
        }
        return this.nmeaWindDirection;
    }

    /**
     * Gets the value of the nmeaWindSpeed property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaWindSpeed property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaWindSpeed().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaWindSpeedType }
     */
    public List<NmeaWindSpeedType> getNmeaWindSpeed() {
        if (nmeaWindSpeed == null) {
            nmeaWindSpeed = new ArrayList<NmeaWindSpeedType>();
        }
        return this.nmeaWindSpeed;
    }

    /**
     * Gets the value of the nmeaMwv property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaMwv property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaMwv().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaMwvType }
     */
    public List<NmeaMwvType> getNmeaMwv() {
        if (nmeaMwv == null) {
            nmeaMwv = new ArrayList<NmeaMwvType>();
        }
        return this.nmeaMwv;
    }

    /**
     * Gets the value of the nmeaTrueHeading property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaTrueHeading property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaTrueHeading().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaTrueHeadingType }
     */
    public List<NmeaTrueHeadingType> getNmeaTrueHeading() {
        if (nmeaTrueHeading == null) {
            nmeaTrueHeading = new ArrayList<NmeaTrueHeadingType>();
        }
        return this.nmeaTrueHeading;
    }

    /**
     * Gets the value of the nmeaThs property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaThs property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaThs().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaThsType }
     */
    public List<NmeaThsType> getNmeaThs() {
        if (nmeaThs == null) {
            nmeaThs = new ArrayList<NmeaThsType>();
        }
        return this.nmeaThs;
    }

    /**
     * Gets the value of the nmeaSxn property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nmeaSxn property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNmeaSxn().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NmeaSxnType }
     */
    public List<NmeaSxnType> getNmeaSxn() {
        if (nmeaSxn == null) {
            nmeaSxn = new ArrayList<NmeaSxnType>();
        }
        return this.nmeaSxn;
    }

    /**
     * Gets the value of the batteryFeedback property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the batteryFeedback property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBatteryFeedback().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BatteryFeedbackType }
     */
    public List<BatteryFeedbackType> getBatteryFeedback() {
        if (batteryFeedback == null) {
            batteryFeedback = new ArrayList<BatteryFeedbackType>();
        }
        return this.batteryFeedback;
    }

    /**
     * Gets the value of the generatorFeedback property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the generatorFeedback property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getGeneratorFeedback().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GeneratorFeedbackType }
     */
    public List<GeneratorFeedbackType> getGeneratorFeedback() {
        if (generatorFeedback == null) {
            generatorFeedback = new ArrayList<GeneratorFeedbackType>();
        }
        return this.generatorFeedback;
    }

    /**
     * Gets the value of the busFeedback property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the busFeedback property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusFeedback().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BusFeedbackType }
     */
    public List<BusFeedbackType> getBusFeedback() {
        if (busFeedback == null) {
            busFeedback = new ArrayList<BusFeedbackType>();
        }
        return this.busFeedback;
    }

    /**
     * Gets the value of the shaftSpeed property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the shaftSpeed property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getShaftSpeed().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ShaftSpeedType }
     */
    public List<ShaftSpeedType> getShaftSpeed() {
        if (shaftSpeed == null) {
            shaftSpeed = new ArrayList<ShaftSpeedType>();
        }
        return this.shaftSpeed;
    }

    /**
     * Gets the value of the azimuthAngle property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the azimuthAngle property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAzimuthAngle().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AzimuthAngleType }
     */
    public List<AzimuthAngleType> getAzimuthAngle() {
        if (azimuthAngle == null) {
            azimuthAngle = new ArrayList<AzimuthAngleType>();
        }
        return this.azimuthAngle;
    }

    /**
     * Gets the value of the bladePitch property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bladePitch property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBladePitch().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BladePitchType }
     */
    public List<BladePitchType> getBladePitch() {
        if (bladePitch == null) {
            bladePitch = new ArrayList<BladePitchType>();
        }
        return this.bladePitch;
    }

    /**
     * Gets the value of the fixedThrusterSetpoint property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fixedThrusterSetpoint property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFixedThrusterSetpoint().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FixedThrusterSetpointType }
     */
    public List<FixedThrusterSetpointType> getFixedThrusterSetpoint() {
        if (fixedThrusterSetpoint == null) {
            fixedThrusterSetpoint = new ArrayList<FixedThrusterSetpointType>();
        }
        return this.fixedThrusterSetpoint;
    }

    /**
     * Gets the value of the fixedThrusterFeedback property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fixedThrusterFeedback property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFixedThrusterFeedback().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FixedThrusterFeedbackType }
     */
    public List<FixedThrusterFeedbackType> getFixedThrusterFeedback() {
        if (fixedThrusterFeedback == null) {
            fixedThrusterFeedback = new ArrayList<FixedThrusterFeedbackType>();
        }
        return this.fixedThrusterFeedback;
    }

    /**
     * Gets the value of the azimuthThrusterSetpoint property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the azimuthThrusterSetpoint property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAzimuthThrusterSetpoint().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AzimuthThrusterSetpointType }
     */
    public List<AzimuthThrusterSetpointType> getAzimuthThrusterSetpoint() {
        if (azimuthThrusterSetpoint == null) {
            azimuthThrusterSetpoint = new ArrayList<AzimuthThrusterSetpointType>();
        }
        return this.azimuthThrusterSetpoint;
    }

    /**
     * Gets the value of the azimuthThrusterFeedback property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the azimuthThrusterFeedback property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAzimuthThrusterFeedback().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AzimuthThrusterFeedbackType }
     */
    public List<AzimuthThrusterFeedbackType> getAzimuthThrusterFeedback() {
        if (azimuthThrusterFeedback == null) {
            azimuthThrusterFeedback = new ArrayList<AzimuthThrusterFeedbackType>();
        }
        return this.azimuthThrusterFeedback;
    }

}
