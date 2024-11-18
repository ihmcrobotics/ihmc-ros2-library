
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for discoveryServersListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="discoveryServersListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="remoteServer" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}remoteServerAttributesType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discoveryServersListType", propOrder = {
    "remoteServer"
})
public class DiscoveryServersListType {

    @XmlElement(required = true)
    protected List<RemoteServerAttributesType> remoteServer;

    /**
     * Gets the value of the remoteServer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the remoteServer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRemoteServer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RemoteServerAttributesType }
     * 
     * 
     */
    public List<RemoteServerAttributesType> getRemoteServer() {
        if (remoteServer == null) {
            remoteServer = new ArrayList<RemoteServerAttributesType>();
        }
        return this.remoteServer;
    }

}
