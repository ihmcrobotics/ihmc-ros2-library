
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for allocationConfigType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="allocationConfigType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all minOccurs="0">
 *         &lt;element name="initial" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *         &lt;element name="maximum" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *         &lt;element name="increment" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "allocationConfigType", propOrder = {

})
public class AllocationConfigType {

    @XmlSchemaType(name = "unsignedInt")
    protected Long initial;
    @XmlElement(defaultValue = "0")
    @XmlSchemaType(name = "unsignedInt")
    protected Long maximum;
    @XmlSchemaType(name = "unsignedInt")
    protected Long increment;

    /**
     * Gets the value of the initial property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInitial() {
        return initial;
    }

    /**
     * Sets the value of the initial property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInitial(Long value) {
        this.initial = value;
    }

    /**
     * Gets the value of the maximum property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaximum() {
        return maximum;
    }

    /**
     * Sets the value of the maximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaximum(Long value) {
        this.maximum = value;
    }

    /**
     * Gets the value of the increment property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIncrement() {
        return increment;
    }

    /**
     * Sets the value of the increment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIncrement(Long value) {
        this.increment = value;
    }

}
