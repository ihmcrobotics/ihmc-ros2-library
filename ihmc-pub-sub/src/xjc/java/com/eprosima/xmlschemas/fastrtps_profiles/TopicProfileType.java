
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for topicProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="topicProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="historyQos" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}historyQosPolicyType" minOccurs="0"/>
 *         &lt;element name="resourceLimitsQos" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="max_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                   &lt;element name="max_instances" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                   &lt;element name="max_samples_per_instance" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                   &lt;element name="allocated_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                   &lt;element name="extra_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                 &lt;/all>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
@XmlType(name = "topicProfileType", propOrder = {

})
public class TopicProfileType {

    protected HistoryQosPolicyType historyQos;
    protected TopicProfileType.ResourceLimitsQos resourceLimitsQos;
    @XmlAttribute(name = "profile_name", required = true)
    protected String profileName;
    @XmlAttribute(name = "is_default_profile")
    protected Boolean isDefaultProfile;

    /**
     * Gets the value of the historyQos property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryQosPolicyType }
     *     
     */
    public HistoryQosPolicyType getHistoryQos() {
        return historyQos;
    }

    /**
     * Sets the value of the historyQos property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryQosPolicyType }
     *     
     */
    public void setHistoryQos(HistoryQosPolicyType value) {
        this.historyQos = value;
    }

    /**
     * Gets the value of the resourceLimitsQos property.
     * 
     * @return
     *     possible object is
     *     {@link TopicProfileType.ResourceLimitsQos }
     *     
     */
    public TopicProfileType.ResourceLimitsQos getResourceLimitsQos() {
        return resourceLimitsQos;
    }

    /**
     * Sets the value of the resourceLimitsQos property.
     * 
     * @param value
     *     allowed object is
     *     {@link TopicProfileType.ResourceLimitsQos }
     *     
     */
    public void setResourceLimitsQos(TopicProfileType.ResourceLimitsQos value) {
        this.resourceLimitsQos = value;
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


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;all>
     *         &lt;element name="max_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *         &lt;element name="max_instances" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *         &lt;element name="max_samples_per_instance" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *         &lt;element name="allocated_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *         &lt;element name="extra_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *       &lt;/all>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {

    })
    public static class ResourceLimitsQos {

        @XmlElement(name = "max_samples")
        @XmlSchemaType(name = "unsignedInt")
        protected Long maxSamples;
        @XmlElement(name = "max_instances")
        @XmlSchemaType(name = "unsignedInt")
        protected Long maxInstances;
        @XmlElement(name = "max_samples_per_instance")
        @XmlSchemaType(name = "unsignedInt")
        protected Long maxSamplesPerInstance;
        @XmlElement(name = "allocated_samples")
        @XmlSchemaType(name = "unsignedInt")
        protected Long allocatedSamples;
        @XmlElement(name = "extra_samples")
        @XmlSchemaType(name = "unsignedInt")
        protected Long extraSamples;

        /**
         * Gets the value of the maxSamples property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getMaxSamples() {
            return maxSamples;
        }

        /**
         * Sets the value of the maxSamples property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setMaxSamples(Long value) {
            this.maxSamples = value;
        }

        /**
         * Gets the value of the maxInstances property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getMaxInstances() {
            return maxInstances;
        }

        /**
         * Sets the value of the maxInstances property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setMaxInstances(Long value) {
            this.maxInstances = value;
        }

        /**
         * Gets the value of the maxSamplesPerInstance property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getMaxSamplesPerInstance() {
            return maxSamplesPerInstance;
        }

        /**
         * Sets the value of the maxSamplesPerInstance property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setMaxSamplesPerInstance(Long value) {
            this.maxSamplesPerInstance = value;
        }

        /**
         * Gets the value of the allocatedSamples property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getAllocatedSamples() {
            return allocatedSamples;
        }

        /**
         * Sets the value of the allocatedSamples property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setAllocatedSamples(Long value) {
            this.allocatedSamples = value;
        }

        /**
         * Gets the value of the extraSamples property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getExtraSamples() {
            return extraSamples;
        }

        /**
         * Sets the value of the extraSamples property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setExtraSamples(Long value) {
            this.extraSamples = value;
        }

    }

}
