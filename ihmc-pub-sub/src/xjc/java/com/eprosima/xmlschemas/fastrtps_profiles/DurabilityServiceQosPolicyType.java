
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for durabilityServiceQosPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="durabilityServiceQosPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="service_cleanup_delay" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="history_kind" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}historyQosKindPolicyType" minOccurs="0"/>
 *         &lt;element name="history_depth" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
 *         &lt;element name="max_samples" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
 *         &lt;element name="max_instances" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
 *         &lt;element name="max_samples_per_instance" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "durabilityServiceQosPolicyType", propOrder = {

})
public class DurabilityServiceQosPolicyType {

    @XmlElement(name = "service_cleanup_delay")
    protected DurationType serviceCleanupDelay;
    @XmlElement(name = "history_kind")
    @XmlSchemaType(name = "string")
    protected HistoryQosKindPolicyType historyKind;
    @XmlElement(name = "history_depth")
    protected Integer historyDepth;
    @XmlElement(name = "max_samples")
    protected Integer maxSamples;
    @XmlElement(name = "max_instances")
    protected Integer maxInstances;
    @XmlElement(name = "max_samples_per_instance")
    protected Integer maxSamplesPerInstance;

    /**
     * Gets the value of the serviceCleanupDelay property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getServiceCleanupDelay() {
        return serviceCleanupDelay;
    }

    /**
     * Sets the value of the serviceCleanupDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setServiceCleanupDelay(DurationType value) {
        this.serviceCleanupDelay = value;
    }

    /**
     * Gets the value of the historyKind property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryQosKindPolicyType }
     *     
     */
    public HistoryQosKindPolicyType getHistoryKind() {
        return historyKind;
    }

    /**
     * Sets the value of the historyKind property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryQosKindPolicyType }
     *     
     */
    public void setHistoryKind(HistoryQosKindPolicyType value) {
        this.historyKind = value;
    }

    /**
     * Gets the value of the historyDepth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHistoryDepth() {
        return historyDepth;
    }

    /**
     * Sets the value of the historyDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHistoryDepth(Integer value) {
        this.historyDepth = value;
    }

    /**
     * Gets the value of the maxSamples property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSamples() {
        return maxSamples;
    }

    /**
     * Sets the value of the maxSamples property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSamples(Integer value) {
        this.maxSamples = value;
    }

    /**
     * Gets the value of the maxInstances property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxInstances() {
        return maxInstances;
    }

    /**
     * Sets the value of the maxInstances property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxInstances(Integer value) {
        this.maxInstances = value;
    }

    /**
     * Gets the value of the maxSamplesPerInstance property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxSamplesPerInstance() {
        return maxSamplesPerInstance;
    }

    /**
     * Sets the value of the maxSamplesPerInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxSamplesPerInstance(Integer value) {
        this.maxSamplesPerInstance = value;
    }

}
