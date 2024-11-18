
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for timeBasedFilterQosPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="timeBasedFilterQosPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="minimum_separation" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "timeBasedFilterQosPolicyType", propOrder = {

})
public class TimeBasedFilterQosPolicyType {

    @XmlElement(name = "minimum_separation")
    protected DurationType minimumSeparation;

    /**
     * Gets the value of the minimumSeparation property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getMinimumSeparation() {
        return minimumSeparation;
    }

    /**
     * Sets the value of the minimumSeparation property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setMinimumSeparation(DurationType value) {
        this.minimumSeparation = value;
    }

}
