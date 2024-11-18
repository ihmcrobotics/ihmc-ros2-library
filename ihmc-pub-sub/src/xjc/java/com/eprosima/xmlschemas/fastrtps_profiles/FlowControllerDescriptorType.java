
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.math.BigInteger;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flowControllerDescriptorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flowControllerDescriptorType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="name" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string"/>
 *         &lt;element name="scheduler" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}flowControllerSchedulerPolicy" minOccurs="0"/>
 *         &lt;element name="max_bytes_per_period" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
 *         &lt;element name="period_ms" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint64" minOccurs="0"/>
 *         &lt;element name="sender_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flowControllerDescriptorType", propOrder = {

})
public class FlowControllerDescriptorType {

    @XmlElement(required = true)
    protected String name;
    @XmlSchemaType(name = "string")
    protected FlowControllerSchedulerPolicy scheduler;
    @XmlElement(name = "max_bytes_per_period")
    protected Integer maxBytesPerPeriod;
    @XmlElement(name = "period_ms")
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger periodMs;
    @XmlElement(name = "sender_thread")
    protected ThreadSettingsType senderThread;

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
     * Gets the value of the scheduler property.
     * 
     * @return
     *     possible object is
     *     {@link FlowControllerSchedulerPolicy }
     *     
     */
    public FlowControllerSchedulerPolicy getScheduler() {
        return scheduler;
    }

    /**
     * Sets the value of the scheduler property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlowControllerSchedulerPolicy }
     *     
     */
    public void setScheduler(FlowControllerSchedulerPolicy value) {
        this.scheduler = value;
    }

    /**
     * Gets the value of the maxBytesPerPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxBytesPerPeriod() {
        return maxBytesPerPeriod;
    }

    /**
     * Sets the value of the maxBytesPerPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxBytesPerPeriod(Integer value) {
        this.maxBytesPerPeriod = value;
    }

    /**
     * Gets the value of the periodMs property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPeriodMs() {
        return periodMs;
    }

    /**
     * Sets the value of the periodMs property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPeriodMs(BigInteger value) {
        this.periodMs = value;
    }

    /**
     * Gets the value of the senderThread property.
     * 
     * @return
     *     possible object is
     *     {@link ThreadSettingsType }
     *     
     */
    public ThreadSettingsType getSenderThread() {
        return senderThread;
    }

    /**
     * Sets the value of the senderThread property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreadSettingsType }
     *     
     */
    public void setSenderThread(ThreadSettingsType value) {
        this.senderThread = value;
    }

}
