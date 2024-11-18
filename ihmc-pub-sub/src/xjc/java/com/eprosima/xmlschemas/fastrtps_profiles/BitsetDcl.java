
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for bitsetDcl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bitsetDcl">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bitfield" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;attribute name="name" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *                 &lt;attribute name="type" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}IntPrimitiveTypes" />
 *                 &lt;attribute name="bit_bound" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}short">
 *                       &lt;minInclusive value="1"/>
 *                       &lt;maxInclusive value="64"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="name" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="baseType" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bitsetDcl", propOrder = {
    "bitfield"
})
public class BitsetDcl {

    @XmlElement(required = true)
    protected List<BitsetDcl.Bitfield> bitfield;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "baseType")
    protected String baseType;

    /**
     * Gets the value of the bitfield property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the bitfield property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBitfield().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BitsetDcl.Bitfield }
     * 
     * 
     */
    public List<BitsetDcl.Bitfield> getBitfield() {
        if (bitfield == null) {
            bitfield = new ArrayList<BitsetDcl.Bitfield>();
        }
        return this.bitfield;
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
     * Gets the value of the baseType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseType() {
        return baseType;
    }

    /**
     * Sets the value of the baseType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseType(String value) {
        this.baseType = value;
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
     *       &lt;attribute name="name" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
     *       &lt;attribute name="type" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}IntPrimitiveTypes" />
     *       &lt;attribute name="bit_bound" use="required">
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
    @XmlType(name = "")
    public static class Bitfield {

        @XmlAttribute(name = "name")
        protected String name;
        @XmlAttribute(name = "type")
        protected IntPrimitiveTypes type;
        @XmlAttribute(name = "bit_bound", required = true)
        protected short bitBound;

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
         *     {@link IntPrimitiveTypes }
         *     
         */
        public IntPrimitiveTypes getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link IntPrimitiveTypes }
         *     
         */
        public void setType(IntPrimitiveTypes value) {
            this.type = value;
        }

        /**
         * Gets the value of the bitBound property.
         * 
         */
        public short getBitBound() {
            return bitBound;
        }

        /**
         * Sets the value of the bitBound property.
         * 
         */
        public void setBitBound(short value) {
            this.bitBound = value;
        }

    }

}
