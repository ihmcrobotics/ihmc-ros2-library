
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tcpv4LocatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tcpv4LocatorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="port" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint16" minOccurs="0"/>
 *         &lt;element name="physical_port" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint16" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}ipv4Address" minOccurs="0"/>
 *         &lt;element name="unique_lan_id" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" minOccurs="0"/>
 *         &lt;element name="wan_address" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}ipv4AddressFormat" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tcpv4LocatorType", propOrder = {

})
public class Tcpv4LocatorType {

    @XmlSchemaType(name = "unsignedShort")
    protected Integer port;
    @XmlElement(name = "physical_port")
    @XmlSchemaType(name = "unsignedShort")
    protected Integer physicalPort;
    protected String address;
    @XmlElement(name = "unique_lan_id")
    protected String uniqueLanId;
    @XmlElement(name = "wan_address")
    protected String wanAddress;

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
     * Gets the value of the physicalPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPhysicalPort() {
        return physicalPort;
    }

    /**
     * Sets the value of the physicalPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPhysicalPort(Integer value) {
        this.physicalPort = value;
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
     * Gets the value of the uniqueLanId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUniqueLanId() {
        return uniqueLanId;
    }

    /**
     * Sets the value of the uniqueLanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUniqueLanId(String value) {
        this.uniqueLanId = value;
    }

    /**
     * Gets the value of the wanAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWanAddress() {
        return wanAddress;
    }

    /**
     * Sets the value of the wanAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWanAddress(String value) {
        this.wanAddress = value;
    }

}
