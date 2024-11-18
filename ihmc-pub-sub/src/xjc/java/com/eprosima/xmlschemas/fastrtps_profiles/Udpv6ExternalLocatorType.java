
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for udpv6ExternalLocatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="udpv6ExternalLocatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="port" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint16" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}ipv6Address" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="externality" default="1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="255"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="cost" default="0">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="0"/>
 *             &lt;maxInclusive value="255"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="mask" default="24">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *             &lt;minInclusive value="1"/>
 *             &lt;maxInclusive value="127"/>
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
@XmlType(name = "udpv6ExternalLocatorType", propOrder = {

})
public class Udpv6ExternalLocatorType {

    @XmlSchemaType(name = "unsignedShort")
    protected Integer port;
    protected String address;
    @XmlAttribute(name = "externality")
    protected Integer externality;
    @XmlAttribute(name = "cost")
    protected Integer cost;
    @XmlAttribute(name = "mask")
    protected Integer mask;

    /**
     * Gets the value of the port property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPort(Integer value) {
        this.port = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the externality property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getExternality() {
        if (externality == null) {
            return  1;
        } else {
            return externality;
        }
    }

    /**
     * Sets the value of the externality property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExternality(Integer value) {
        this.externality = value;
    }

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getCost() {
        if (cost == null) {
            return  0;
        } else {
            return cost;
        }
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCost(Integer value) {
        this.cost = value;
    }

    /**
     * Gets the value of the mask property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getMask() {
        if (mask == null) {
            return  24;
        } else {
            return mask;
        }
    }

    /**
     * Sets the value of the mask property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMask(Integer value) {
        this.mask = value;
    }

}
