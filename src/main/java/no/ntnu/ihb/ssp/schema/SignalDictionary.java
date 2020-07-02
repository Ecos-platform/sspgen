
package no.ntnu.ihb.ssp.schema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DictionaryEntry" type="{http://ssp-standard.org/SSP1/SystemStructureSignalDictionary}TDictionaryEntry" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Enumerations" type="{http://ssp-standard.org/SSP1/SystemStructureCommon}TEnumerations" minOccurs="0"/>
 *         &lt;element name="Units" type="{http://ssp-standard.org/SSP1/SystemStructureCommon}TUnits" minOccurs="0"/>
 *         &lt;element name="Annotations" type="{http://ssp-standard.org/SSP1/SystemStructureCommon}TAnnotations" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ssp-standard.org/SSP1/SystemStructureCommon}ABaseElement"/>
 *       &lt;attGroup ref="{http://ssp-standard.org/SSP1/SystemStructureCommon}ATopLevelMetaData"/>
 *       &lt;attribute name="version" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *             &lt;pattern value="1[.][0-9]+(-.*)?"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dictionaryEntry",
    "enumerations",
    "units",
    "annotations"
})
@XmlRootElement(name = "SignalDictionary", namespace = "http://ssp-standard.org/SSP1/SystemStructureSignalDictionary")
public class SignalDictionary {

    @XmlElement(name = "DictionaryEntry", namespace = "http://ssp-standard.org/SSP1/SystemStructureSignalDictionary")
    protected List<TDictionaryEntry> dictionaryEntry;
    @XmlElement(name = "Enumerations", namespace = "http://ssp-standard.org/SSP1/SystemStructureSignalDictionary")
    protected TEnumerations enumerations;
    @XmlElement(name = "Units", namespace = "http://ssp-standard.org/SSP1/SystemStructureSignalDictionary")
    protected TUnits units;
    @XmlElement(name = "Annotations", namespace = "http://ssp-standard.org/SSP1/SystemStructureSignalDictionary")
    protected TAnnotations annotations;
    @XmlAttribute(name = "version", required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String version;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "description")
    protected String description;
    @XmlAttribute(name = "author")
    protected String author;
    @XmlAttribute(name = "fileversion")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String fileversion;
    @XmlAttribute(name = "copyright")
    protected String copyright;
    @XmlAttribute(name = "license")
    protected String license;
    @XmlAttribute(name = "generationTool")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    @XmlSchemaType(name = "normalizedString")
    protected String generationTool;
    @XmlAttribute(name = "generationDateAndTime")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar generationDateAndTime;

    /**
     * Gets the value of the dictionaryEntry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dictionaryEntry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDictionaryEntry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDictionaryEntry }
     * 
     * 
     */
    public List<TDictionaryEntry> getDictionaryEntry() {
        if (dictionaryEntry == null) {
            dictionaryEntry = new ArrayList<TDictionaryEntry>();
        }
        return this.dictionaryEntry;
    }

    /**
     * Gets the value of the enumerations property.
     * 
     * @return
     *     possible object is
     *     {@link TEnumerations }
     *     
     */
    public TEnumerations getEnumerations() {
        return enumerations;
    }

    /**
     * Sets the value of the enumerations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TEnumerations }
     *     
     */
    public void setEnumerations(TEnumerations value) {
        this.enumerations = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link TUnits }
     *     
     */
    public TUnits getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link TUnits }
     *     
     */
    public void setUnits(TUnits value) {
        this.units = value;
    }

    /**
     * Gets the value of the annotations property.
     * 
     * @return
     *     possible object is
     *     {@link TAnnotations }
     *     
     */
    public TAnnotations getAnnotations() {
        return annotations;
    }

    /**
     * Sets the value of the annotations property.
     * 
     * @param value
     *     allowed object is
     *     {@link TAnnotations }
     *     
     */
    public void setAnnotations(TAnnotations value) {
        this.annotations = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the fileversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFileversion() {
        return fileversion;
    }

    /**
     * Sets the value of the fileversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFileversion(String value) {
        this.fileversion = value;
    }

    /**
     * Gets the value of the copyright property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * Sets the value of the copyright property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyright(String value) {
        this.copyright = value;
    }

    /**
     * Gets the value of the license property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLicense() {
        return license;
    }

    /**
     * Sets the value of the license property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLicense(String value) {
        this.license = value;
    }

    /**
     * Gets the value of the generationTool property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGenerationTool() {
        return generationTool;
    }

    /**
     * Sets the value of the generationTool property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGenerationTool(String value) {
        this.generationTool = value;
    }

    /**
     * Gets the value of the generationDateAndTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getGenerationDateAndTime() {
        return generationDateAndTime;
    }

    /**
     * Sets the value of the generationDateAndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setGenerationDateAndTime(XMLGregorianCalendar value) {
        this.generationDateAndTime = value;
    }

}
