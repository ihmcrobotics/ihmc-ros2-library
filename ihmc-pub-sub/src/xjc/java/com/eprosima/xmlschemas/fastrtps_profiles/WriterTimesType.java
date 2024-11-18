
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for writerTimesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="writerTimesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="initialHeartbeatDelay" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="heartbeatPeriod" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="nackResponseDelay" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="nackSupressionDuration" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "writerTimesType", propOrder = {

})
public class WriterTimesType {

    protected DurationType initialHeartbeatDelay;
    protected DurationType heartbeatPeriod;
    protected DurationType nackResponseDelay;
    protected DurationType nackSupressionDuration;

    /**
     * Gets the value of the initialHeartbeatDelay property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getInitialHeartbeatDelay() {
        return initialHeartbeatDelay;
    }

    /**
     * Sets the value of the initialHeartbeatDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setInitialHeartbeatDelay(DurationType value) {
        this.initialHeartbeatDelay = value;
    }

    /**
     * Gets the value of the heartbeatPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getHeartbeatPeriod() {
        return heartbeatPeriod;
    }

    /**
     * Sets the value of the heartbeatPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setHeartbeatPeriod(DurationType value) {
        this.heartbeatPeriod = value;
    }

    /**
     * Gets the value of the nackResponseDelay property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getNackResponseDelay() {
        return nackResponseDelay;
    }

    /**
     * Sets the value of the nackResponseDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setNackResponseDelay(DurationType value) {
        this.nackResponseDelay = value;
    }

    /**
     * Gets the value of the nackSupressionDuration property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getNackSupressionDuration() {
        return nackSupressionDuration;
    }

    /**
     * Sets the value of the nackSupressionDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setNackSupressionDuration(DurationType value) {
        this.nackSupressionDuration = value;
    }

}
