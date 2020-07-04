
package no.ntnu.ihb.sspgen.schema;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for TMappingEntry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TMappingEntry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{http://ssp-standard.org/SSP1/SystemStructureCommon}GTransformationChoice" minOccurs="0"/>
 *         &lt;element name="Annotations" type="{http://ssp-standard.org/SSP1/SystemStructureCommon}TAnnotations" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://ssp-standard.org/SSP1/SystemStructureCommon}ABaseElement"/>
 *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="suppressUnitConversion" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TMappingEntry", namespace = "http://ssp-standard.org/SSP1/SystemStructureParameterMapping", propOrder = {
    "linearTransformation",
    "booleanMappingTransformation",
    "integerMappingTransformation",
    "enumerationMappingTransformation",
    "annotations"
})
public class TMappingEntry {

    @XmlElement(name = "LinearTransformation", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon")
    protected LinearTransformation linearTransformation;
    @XmlElement(name = "BooleanMappingTransformation", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon")
    protected BooleanMappingTransformation booleanMappingTransformation;
    @XmlElement(name = "IntegerMappingTransformation", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon")
    protected IntegerMappingTransformation integerMappingTransformation;
    @XmlElement(name = "EnumerationMappingTransformation", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon")
    protected EnumerationMappingTransformation enumerationMappingTransformation;
    @XmlElement(name = "Annotations", namespace = "http://ssp-standard.org/SSP1/SystemStructureParameterMapping")
    protected TAnnotations annotations;
    @XmlAttribute(name = "source", required = true)
    protected String source;
    @XmlAttribute(name = "target", required = true)
    protected String target;
    @XmlAttribute(name = "suppressUnitConversion")
    protected Boolean suppressUnitConversion;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "description")
    protected String description;

    /**
     * Gets the value of the linearTransformation property.
     *
     * @return possible object is
     * {@link LinearTransformation }
     */
    public LinearTransformation getLinearTransformation() {
        return linearTransformation;
    }

    /**
     * Sets the value of the linearTransformation property.
     *
     * @param value
     *     allowed object is
     *     {@link LinearTransformation }
     *
     */
    public void setLinearTransformation(LinearTransformation value) {
        this.linearTransformation = value;
    }

    /**
     * Gets the value of the booleanMappingTransformation property.
     *
     * @return
     *     possible object is
     *     {@link BooleanMappingTransformation }
     *
     */
    public BooleanMappingTransformation getBooleanMappingTransformation() {
        return booleanMappingTransformation;
    }

    /**
     * Sets the value of the booleanMappingTransformation property.
     *
     * @param value
     *     allowed object is
     *     {@link BooleanMappingTransformation }
     *
     */
    public void setBooleanMappingTransformation(BooleanMappingTransformation value) {
        this.booleanMappingTransformation = value;
    }

    /**
     * Gets the value of the integerMappingTransformation property.
     *
     * @return
     *     possible object is
     *     {@link IntegerMappingTransformation }
     *
     */
    public IntegerMappingTransformation getIntegerMappingTransformation() {
        return integerMappingTransformation;
    }

    /**
     * Sets the value of the integerMappingTransformation property.
     *
     * @param value
     *     allowed object is
     *     {@link IntegerMappingTransformation }
     *
     */
    public void setIntegerMappingTransformation(IntegerMappingTransformation value) {
        this.integerMappingTransformation = value;
    }

    /**
     * Gets the value of the enumerationMappingTransformation property.
     *
     * @return
     *     possible object is
     *     {@link EnumerationMappingTransformation }
     *
     */
    public EnumerationMappingTransformation getEnumerationMappingTransformation() {
        return enumerationMappingTransformation;
    }

    /**
     * Sets the value of the enumerationMappingTransformation property.
     *
     * @param value
     *     allowed object is
     *     {@link EnumerationMappingTransformation }
     *
     */
    public void setEnumerationMappingTransformation(EnumerationMappingTransformation value) {
        this.enumerationMappingTransformation = value;
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
     * Gets the value of the source property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSource() {
        return source;
    }

    /**
     * Sets the value of the source property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSource(String value) {
        this.source = value;
    }

    /**
     * Gets the value of the target property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTarget() {
        return target;
    }

    /**
     * Sets the value of the target property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTarget(String value) {
        this.target = value;
    }

    /**
     * Gets the value of the suppressUnitConversion property.
     *
     * @return
     *     possible object is
     *     {@link Boolean }
     *
     */
    public boolean isSuppressUnitConversion() {
        if (suppressUnitConversion == null) {
            return false;
        } else {
            return suppressUnitConversion;
        }
    }

    /**
     * Sets the value of the suppressUnitConversion property.
     *
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *
     */
    public void setSuppressUnitConversion(Boolean value) {
        this.suppressUnitConversion = value;
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
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="MapEntry" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *                 &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mapEntry"
    })
    public static class BooleanMappingTransformation {

        @XmlElement(name = "MapEntry", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon", required = true)
        protected List<MapEntry> mapEntry;

        /**
         * Gets the value of the mapEntry property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mapEntry property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMapEntry().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MapEntry }
         *
         *
         */
        public List<MapEntry> getMapEntry() {
            if (mapEntry == null) {
                mapEntry = new ArrayList<MapEntry>();
            }
            return this.mapEntry;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MapEntry {

            @XmlAttribute(name = "source", required = true)
            protected boolean source;
            @XmlAttribute(name = "target", required = true)
            protected boolean target;

            /**
             * Gets the value of the source property.
             *
             */
            public boolean isSource() {
                return source;
            }

            /**
             * Sets the value of the source property.
             *
             */
            public void setSource(boolean value) {
                this.source = value;
            }

            /**
             * Gets the value of the target property.
             *
             */
            public boolean isTarget() {
                return target;
            }

            /**
             * Sets the value of the target property.
             *
             */
            public void setTarget(boolean value) {
                this.target = value;
            }

        }

    }


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
     *         &lt;element name="MapEntry" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *                 &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mapEntry"
    })
    public static class EnumerationMappingTransformation {

        @XmlElement(name = "MapEntry", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon", required = true)
        protected List<MapEntry> mapEntry;

        /**
         * Gets the value of the mapEntry property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mapEntry property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMapEntry().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MapEntry }
         *
         *
         */
        public List<MapEntry> getMapEntry() {
            if (mapEntry == null) {
                mapEntry = new ArrayList<MapEntry>();
            }
            return this.mapEntry;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         *
         *
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MapEntry {

            @XmlAttribute(name = "source", required = true)
            protected String source;
            @XmlAttribute(name = "target", required = true)
            protected String target;

            /**
             * Gets the value of the source property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getSource() {
                return source;
            }

            /**
             * Sets the value of the source property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setSource(String value) {
                this.source = value;
            }

            /**
             * Gets the value of the target property.
             *
             * @return
             *     possible object is
             *     {@link String }
             *
             */
            public String getTarget() {
                return target;
            }

            /**
             * Sets the value of the target property.
             *
             * @param value
             *     allowed object is
             *     {@link String }
             *
             */
            public void setTarget(String value) {
                this.target = value;
            }

        }

    }


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
     *         &lt;element name="MapEntry" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *                 &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "mapEntry"
    })
    public static class IntegerMappingTransformation {

        @XmlElement(name = "MapEntry", namespace = "http://ssp-standard.org/SSP1/SystemStructureCommon", required = true)
        protected List<MapEntry> mapEntry;

        /**
         * Gets the value of the mapEntry property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the mapEntry property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getMapEntry().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link MapEntry }
         *
         *
         */
        public List<MapEntry> getMapEntry() {
            if (mapEntry == null) {
                mapEntry = new ArrayList<MapEntry>();
            }
            return this.mapEntry;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;attribute name="source" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
         *       &lt;attribute name="target" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class MapEntry {

            @XmlAttribute(name = "source", required = true)
            protected int source;
            @XmlAttribute(name = "target", required = true)
            protected int target;

            /**
             * Gets the value of the source property.
             * 
             */
            public int getSource() {
                return source;
            }

            /**
             * Sets the value of the source property.
             * 
             */
            public void setSource(int value) {
                this.source = value;
            }

            /**
             * Gets the value of the target property.
             * 
             */
            public int getTarget() {
                return target;
            }

            /**
             * Sets the value of the target property.
             * 
             */
            public void setTarget(int value) {
                this.target = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;attribute name="factor" type="{http://www.w3.org/2001/XMLSchema}double" default="1.0" />
     *       &lt;attribute name="offset" type="{http://www.w3.org/2001/XMLSchema}double" default="0.0" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class LinearTransformation {

        @XmlAttribute(name = "factor")
        protected Double factor;
        @XmlAttribute(name = "offset")
        protected Double offset;

        /**
         * Gets the value of the factor property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public double getFactor() {
            if (factor == null) {
                return  1.0D;
            } else {
                return factor;
            }
        }

        /**
         * Sets the value of the factor property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setFactor(Double value) {
            this.factor = value;
        }

        /**
         * Gets the value of the offset property.
         * 
         * @return
         *     possible object is
         *     {@link Double }
         *     
         */
        public double getOffset() {
            if (offset == null) {
                return  0.0D;
            } else {
                return offset;
            }
        }

        /**
         * Sets the value of the offset property.
         * 
         * @param value
         *     allowed object is
         *     {@link Double }
         *     
         */
        public void setOffset(Double value) {
            this.offset = value;
        }

    }

}
