
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for logType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="logType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice>
 *           &lt;element name="use_default" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}booleanCaps" minOccurs="0"/>
 *           &lt;element name="consumer" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}logConsumerType" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;element name="thread_settings" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "logType", propOrder = {
    "useDefaultOrConsumerOrThreadSettings"
})
public class LogType {

    @XmlElements({
        @XmlElement(name = "use_default", type = String.class),
        @XmlElement(name = "consumer", type = LogConsumerType.class),
        @XmlElement(name = "thread_settings", type = ThreadSettingsType.class)
    })
    protected List<Object> useDefaultOrConsumerOrThreadSettings;

    /**
     * Gets the value of the useDefaultOrConsumerOrThreadSettings property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the useDefaultOrConsumerOrThreadSettings property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUseDefaultOrConsumerOrThreadSettings().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link LogConsumerType }
     * {@link ThreadSettingsType }
     * 
     * 
     */
    public List<Object> getUseDefaultOrConsumerOrThreadSettings() {
        if (useDefaultOrConsumerOrThreadSettings == null) {
            useDefaultOrConsumerOrThreadSettings = new ArrayList<Object>();
        }
        return this.useDefaultOrConsumerOrThreadSettings;
    }

}
