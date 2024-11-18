
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for subscriberProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="subscriberProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all minOccurs="0">
 *         &lt;element name="topic" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}topicElementType" minOccurs="0"/>
 *         &lt;element name="qos" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}dataReaderQosPoliciesType" minOccurs="0"/>
 *         &lt;element name="times" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}readerTimesType" minOccurs="0"/>
 *         &lt;element name="unicastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
 *         &lt;element name="multicastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
 *         &lt;element name="external_unicast_locators" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}externalLocatorListType" minOccurs="0"/>
 *         &lt;element name="ignore_non_matching_locators" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" minOccurs="0"/>
 *         &lt;element name="expectsInlineQos" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" minOccurs="0"/>
 *         &lt;element name="historyMemoryPolicy" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}historyMemoryPolicyType" minOccurs="0"/>
 *         &lt;element name="propertiesPolicy" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}propertyPolicyType" minOccurs="0"/>
 *         &lt;element name="userDefinedID" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int16" minOccurs="0"/>
 *         &lt;element name="entityID" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int16" minOccurs="0"/>
 *         &lt;element name="matchedPublishersAllocation" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}allocationConfigType" minOccurs="0"/>
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
@XmlType(name = "subscriberProfileType", propOrder = {

})
public class SubscriberProfileType {

    protected TopicElementType topic;
    protected DataReaderQosPoliciesType qos;
    protected ReaderTimesType times;
    protected LocatorListType unicastLocatorList;
    protected LocatorListType multicastLocatorList;
    @XmlElement(name = "external_unicast_locators")
    protected ExternalLocatorListType externalUnicastLocators;
    @XmlElement(name = "ignore_non_matching_locators")
    protected Boolean ignoreNonMatchingLocators;
    protected Boolean expectsInlineQos;
    @XmlSchemaType(name = "string")
    protected HistoryMemoryPolicyType historyMemoryPolicy;
    protected PropertyPolicyType propertiesPolicy;
    protected Short userDefinedID;
    protected Short entityID;
    protected AllocationConfigType matchedPublishersAllocation;
    @XmlAttribute(name = "profile_name", required = true)
    protected String profileName;
    @XmlAttribute(name = "is_default_profile")
    protected Boolean isDefaultProfile;

    /**
     * Gets the value of the topic property.
     * 
     * @return
     *     possible object is
     *     {@link TopicElementType }
     *     
     */
    public TopicElementType getTopic() {
        return topic;
    }

    /**
     * Sets the value of the topic property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopicElementType }
     *     
     */
    public void setTopic(TopicElementType value) {
        this.topic = value;
    }

    /**
     * Gets the value of the qos property.
     * 
     * @return
     *     possible object is
     *     {@link DataReaderQosPoliciesType }
     *     
     */
    public DataReaderQosPoliciesType getQos() {
        return qos;
    }

    /**
     * Sets the value of the qos property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataReaderQosPoliciesType }
     *     
     */
    public void setQos(DataReaderQosPoliciesType value) {
        this.qos = value;
    }

    /**
     * Gets the value of the times property.
     * 
     * @return
     *     possible object is
     *     {@link ReaderTimesType }
     *     
     */
    public ReaderTimesType getTimes() {
        return times;
    }

    /**
     * Sets the value of the times property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReaderTimesType }
     *     
     */
    public void setTimes(ReaderTimesType value) {
        this.times = value;
    }

    /**
     * Gets the value of the unicastLocatorList property.
     * 
     * @return
     *     possible object is
     *     {@link LocatorListType }
     *     
     */
    public LocatorListType getUnicastLocatorList() {
        return unicastLocatorList;
    }

    /**
     * Sets the value of the unicastLocatorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocatorListType }
     *     
     */
    public void setUnicastLocatorList(LocatorListType value) {
        this.unicastLocatorList = value;
    }

    /**
     * Gets the value of the multicastLocatorList property.
     * 
     * @return
     *     possible object is
     *     {@link LocatorListType }
     *     
     */
    public LocatorListType getMulticastLocatorList() {
        return multicastLocatorList;
    }

    /**
     * Sets the value of the multicastLocatorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocatorListType }
     *     
     */
    public void setMulticastLocatorList(LocatorListType value) {
        this.multicastLocatorList = value;
    }

    /**
     * Gets the value of the externalUnicastLocators property.
     * 
     * @return
     *     possible object is
     *     {@link ExternalLocatorListType }
     *     
     */
    public ExternalLocatorListType getExternalUnicastLocators() {
        return externalUnicastLocators;
    }

    /**
     * Sets the value of the externalUnicastLocators property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExternalLocatorListType }
     *     
     */
    public void setExternalUnicastLocators(ExternalLocatorListType value) {
        this.externalUnicastLocators = value;
    }

    /**
     * Gets the value of the ignoreNonMatchingLocators property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIgnoreNonMatchingLocators() {
        return ignoreNonMatchingLocators;
    }

    /**
     * Sets the value of the ignoreNonMatchingLocators property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIgnoreNonMatchingLocators(Boolean value) {
        this.ignoreNonMatchingLocators = value;
    }

    /**
     * Gets the value of the expectsInlineQos property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isExpectsInlineQos() {
        return expectsInlineQos;
    }

    /**
     * Sets the value of the expectsInlineQos property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setExpectsInlineQos(Boolean value) {
        this.expectsInlineQos = value;
    }

    /**
     * Gets the value of the historyMemoryPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryMemoryPolicyType }
     *     
     */
    public HistoryMemoryPolicyType getHistoryMemoryPolicy() {
        return historyMemoryPolicy;
    }

    /**
     * Sets the value of the historyMemoryPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryMemoryPolicyType }
     *     
     */
    public void setHistoryMemoryPolicy(HistoryMemoryPolicyType value) {
        this.historyMemoryPolicy = value;
    }

    /**
     * Gets the value of the propertiesPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link PropertyPolicyType }
     *     
     */
    public PropertyPolicyType getPropertiesPolicy() {
        return propertiesPolicy;
    }

    /**
     * Sets the value of the propertiesPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link PropertyPolicyType }
     *     
     */
    public void setPropertiesPolicy(PropertyPolicyType value) {
        this.propertiesPolicy = value;
    }

    /**
     * Gets the value of the userDefinedID property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getUserDefinedID() {
        return userDefinedID;
    }

    /**
     * Sets the value of the userDefinedID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setUserDefinedID(Short value) {
        this.userDefinedID = value;
    }

    /**
     * Gets the value of the entityID property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getEntityID() {
        return entityID;
    }

    /**
     * Sets the value of the entityID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setEntityID(Short value) {
        this.entityID = value;
    }

    /**
     * Gets the value of the matchedPublishersAllocation property.
     * 
     * @return
     *     possible object is
     *     {@link AllocationConfigType }
     *     
     */
    public AllocationConfigType getMatchedPublishersAllocation() {
        return matchedPublishersAllocation;
    }

    /**
     * Sets the value of the matchedPublishersAllocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllocationConfigType }
     *     
     */
    public void setMatchedPublishersAllocation(AllocationConfigType value) {
        this.matchedPublishersAllocation = value;
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
