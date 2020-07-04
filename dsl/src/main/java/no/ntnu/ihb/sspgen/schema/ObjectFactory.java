
package no.ntnu.ihb.sspgen.schema;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the no.ntnu.ihb.ssp.schema package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: no.ntnu.ihb.ssp.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TEnumeration }
     * 
     */
    public TEnumeration createTEnumeration() {
        return new TEnumeration();
    }

    /**
     * Create an instance of {@link TUnit }
     * 
     */
    public TUnit createTUnit() {
        return new TUnit();
    }

    /**
     * Create an instance of {@link TAnnotations }
     * 
     */
    public TAnnotations createTAnnotations() {
        return new TAnnotations();
    }

    /**
     * Create an instance of {@link TDictionaryEntry }
     * 
     */
    public TDictionaryEntry createTDictionaryEntry() {
        return new TDictionaryEntry();
    }

    /**
     * Create an instance of {@link SignalDictionary }
     * 
     */
    public SignalDictionary createSignalDictionary() {
        return new SignalDictionary();
    }

    /**
     * Create an instance of {@link TEnumerations }
     * 
     */
    public TEnumerations createTEnumerations() {
        return new TEnumerations();
    }

    /**
     * Create an instance of {@link TUnits }
     * 
     */
    public TUnits createTUnits() {
        return new TUnits();
    }

    /**
     * Create an instance of {@link TEnumeration.Item }
     * 
     */
    public TEnumeration.Item createTEnumerationItem() {
        return new TEnumeration.Item();
    }

    /**
     * Create an instance of {@link TUnit.BaseUnit }
     * 
     */
    public TUnit.BaseUnit createTUnitBaseUnit() {
        return new TUnit.BaseUnit();
    }

    /**
     * Create an instance of {@link TAnnotations.Annotation }
     * 
     */
    public TAnnotations.Annotation createTAnnotationsAnnotation() {
        return new TAnnotations.Annotation();
    }

    /**
     * Create an instance of {@link TDictionaryEntry.Real }
     * 
     */
    public TDictionaryEntry.Real createTDictionaryEntryReal() {
        return new TDictionaryEntry.Real();
    }

    /**
     * Create an instance of {@link TDictionaryEntry.Integer }
     * 
     */
    public TDictionaryEntry.Integer createTDictionaryEntryInteger() {
        return new TDictionaryEntry.Integer();
    }

    /**
     * Create an instance of {@link TDictionaryEntry.Boolean }
     * 
     */
    public TDictionaryEntry.Boolean createTDictionaryEntryBoolean() {
        return new TDictionaryEntry.Boolean();
    }

    /**
     * Create an instance of {@link TDictionaryEntry.String }
     * 
     */
    public TDictionaryEntry.String createTDictionaryEntryString() {
        return new TDictionaryEntry.String();
    }

    /**
     * Create an instance of {@link TDictionaryEntry.Enumeration }
     * 
     */
    public TDictionaryEntry.Enumeration createTDictionaryEntryEnumeration() {
        return new TDictionaryEntry.Enumeration();
    }

    /**
     * Create an instance of {@link TDictionaryEntry.Binary }
     * 
     */
    public TDictionaryEntry.Binary createTDictionaryEntryBinary() {
        return new TDictionaryEntry.Binary();
    }

}
