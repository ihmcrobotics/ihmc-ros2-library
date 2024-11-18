
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bitmaskDcl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bitmaskDcl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bit_value" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *                 &lt;attribute name="position">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *                       &lt;minInclusive value="0"/>
 *                       &lt;maxInclusive value="63"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;attribute name="bit_bound">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="64"/>
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
@XmlType(name = "bitmaskDcl", propOrder = {
    "bitValue"
})
public class BitmaskDcl {

    @XmlElement(name = "bit_value")
    protected List<BitmaskDcl.BitValue> bitValue;
    @XmlAttribute(name = "name", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String name;
    @XmlAttribute(name = "bit_bound")
    protected Short bitBound;

    /**
     * Gets the value of the bitValue property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bitValue property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBitValue().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BitmaskDcl.BitValue }
     * 
     * 
     */
    public List<BitmaskDcl.BitValue> getBitValue() {
        if (bitValue == null) {
            bitValue = new ArrayList<BitmaskDcl.BitValue>();
        }
        return this.bitValue;
    }

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
     * Gets the value of the bitBound property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getBitBound() {
        return bitBound;
    }

    /**
     * Sets the value of the bitBound property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setBitBound(Short value) {
        this.bitBound = value;
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
     *       &lt;attribute name="name" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
     *       &lt;attribute name="position">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
     *             &lt;minInclusive value="0"/>
     *             &lt;maxInclusive value="63"/>
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
    @XmlType(name = "")
    public static class BitValue {

        @XmlAttribute(name = "name", required = true)
        protected String name;
        @XmlAttribute(name = "position")
        protected Integer position;

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
         * Gets the value of the position property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getPosition() {
            return position;
        }

        /**
         * Sets the value of the position property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setPosition(Integer value) {
            this.position = value;
        }

    }

}
