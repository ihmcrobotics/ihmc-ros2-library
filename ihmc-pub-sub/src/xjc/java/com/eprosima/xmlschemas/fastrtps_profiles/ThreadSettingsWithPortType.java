
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for threadSettingsWithPortType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="threadSettingsWithPortType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType">
 *       &lt;attribute name="port" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "threadSettingsWithPortType")
public class ThreadSettingsWithPortType
    extends ThreadSettingsType
{

    @XmlAttribute(name = "port", required = true)
    protected long port;

    /**
     * Gets the value of the port property.
     * 
     */
    public long getPort() {
        return port;
    }

    /**
     * Sets the value of the port property.
     * 
     */
    public void setPort(long value) {
        this.port = value;
    }

}
