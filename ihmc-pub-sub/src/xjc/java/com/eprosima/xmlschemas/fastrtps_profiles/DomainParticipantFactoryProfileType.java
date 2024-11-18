
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for domainParticipantFactoryProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="domainParticipantFactoryProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="qos" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}domainParticipantFactoryQosPoliciesType" minOccurs="0"/>
 *       &lt;/all>
 *       &lt;attribute name="profile_name" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" />
 *       &lt;attribute name="is_default_profile" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "domainParticipantFactoryProfileType", propOrder = {

})
public class DomainParticipantFactoryProfileType {

    protected DomainParticipantFactoryQosPoliciesType qos;
    @XmlAttribute(name = "profile_name", required = true)
    protected String profileName;
    @XmlAttribute(name = "is_default_profile")
    protected Boolean isDefaultProfile;

    /**
     * Gets the value of the qos property.
     * 
     * @return
     *     possible object is
     *     {@link DomainParticipantFactoryQosPoliciesType }
     *     
     */
    public DomainParticipantFactoryQosPoliciesType getQos() {
        return qos;
    }

    /**
     * Sets the value of the qos property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainParticipantFactoryQosPoliciesType }
     *     
     */
    public void setQos(DomainParticipantFactoryQosPoliciesType value) {
        this.qos = value;
    }

    /**
     * Gets the value of the profileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * Sets the value of the profileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProfileName(String value) {
        this.profileName = value;
    }

    /**
     * Gets the value of the isDefaultProfile property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsDefaultProfile() {
        return isDefaultProfile;
    }

    /**
     * Sets the value of the isDefaultProfile property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsDefaultProfile(Boolean value) {
        this.isDefaultProfile = value;
    }

}
