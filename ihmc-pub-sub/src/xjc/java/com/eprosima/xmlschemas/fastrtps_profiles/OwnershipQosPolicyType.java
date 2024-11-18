
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ownershipQosPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ownershipQosPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="kind" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}ownershipQosKindPolicyType"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ownershipQosPolicyType", propOrder = {

})
public class OwnershipQosPolicyType {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected OwnershipQosKindPolicyType kind;

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link OwnershipQosKindPolicyType }
     *     
     */
    public OwnershipQosKindPolicyType getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link OwnershipQosKindPolicyType }
     *     
     */
    public void setKind(OwnershipQosKindPolicyType value) {
        this.kind = value;
    }

}
