
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for readerTimesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="readerTimesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="initialAcknackDelay" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="heartbeatResponseDelay" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readerTimesType", propOrder = {

})
public class ReaderTimesType {

    protected DurationType initialAcknackDelay;
    protected DurationType heartbeatResponseDelay;

    /**
     * Gets the value of the initialAcknackDelay property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getInitialAcknackDelay() {
        return initialAcknackDelay;
    }

    /**
     * Sets the value of the initialAcknackDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setInitialAcknackDelay(DurationType value) {
        this.initialAcknackDelay = value;
    }

    /**
     * Gets the value of the heartbeatResponseDelay property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getHeartbeatResponseDelay() {
        return heartbeatResponseDelay;
    }

    /**
     * Sets the value of the heartbeatResponseDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setHeartbeatResponseDelay(DurationType value) {
        this.heartbeatResponseDelay = value;
    }

}
