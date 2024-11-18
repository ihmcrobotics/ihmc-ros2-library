
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for memberDcl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="memberDcl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="name" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="type" use="required">
 *         &lt;simpleType>
 *           &lt;union memberTypes=" {http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}primitiveTypes {http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}nonBasicType">
 *           &lt;/union>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="nonBasicTypeName" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="stringMaxLength" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="sequenceMaxLength" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" />
 *       &lt;attribute name="arrayDimensions" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}arrayDim" />
 *       &lt;attribute name="key_type" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="key" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="mapMaxLength" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "memberDcl")
public class MemberDcl {

    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "nonBasicTypeName")
    protected String nonBasicTypeName;
    @XmlAttribute(name = "stringMaxLength")
    protected String stringMaxLength;
    @XmlAttribute(name = "sequenceMaxLength")
    protected Integer sequenceMaxLength;
    @XmlAttribute(name = "arrayDimensions")
    protected String arrayDimensions;
    @XmlAttribute(name = "key_type")
    protected String keyType;
    @XmlAttribute(name = "key")
    protected String key;
    @XmlAttribute(name = "mapMaxLength")
    protected Integer mapMaxLength;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the nonBasicTypeName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonBasicTypeName() {
        return nonBasicTypeName;
    }

    /**
     * Sets the value of the nonBasicTypeName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonBasicTypeName(String value) {
        this.nonBasicTypeName = value;
    }

    /**
     * Gets the value of the stringMaxLength property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStringMaxLength() {
        return stringMaxLength;
    }

    /**
     * Sets the value of the stringMaxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStringMaxLength(String value) {
        this.stringMaxLength = value;
    }

    /**
     * Gets the value of the sequenceMaxLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSequenceMaxLength() {
        return sequenceMaxLength;
    }

    /**
     * Sets the value of the sequenceMaxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSequenceMaxLength(Integer value) {
        this.sequenceMaxLength = value;
    }

    /**
     * Gets the value of the arrayDimensions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArrayDimensions() {
        return arrayDimensions;
    }

    /**
     * Sets the value of the arrayDimensions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArrayDimensions(String value) {
        this.arrayDimensions = value;
    }

    /**
     * Gets the value of the keyType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKeyType() {
        return keyType;
    }

    /**
     * Sets the value of the keyType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKeyType(String value) {
        this.keyType = value;
    }

    /**
     * Gets the value of the key property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the value of the key property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKey(String value) {
        this.key = value;
    }

    /**
     * Gets the value of the mapMaxLength property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMapMaxLength() {
        return mapMaxLength;
    }

    /**
     * Sets the value of the mapMaxLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMapMaxLength(Integer value) {
        this.mapMaxLength = value;
    }

}
