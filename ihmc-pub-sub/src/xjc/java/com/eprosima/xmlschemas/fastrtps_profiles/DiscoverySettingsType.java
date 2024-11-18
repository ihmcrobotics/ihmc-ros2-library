
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for discoverySettingsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="discoverySettingsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all minOccurs="0">
 *         &lt;element name="discoveryProtocol" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}discoveryProtocolType" minOccurs="0"/>
 *         &lt;element name="discoveryServersList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}discoveryServersListType" minOccurs="0"/>
 *         &lt;element name="ignoreParticipantFlags" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}participantFlagsType" minOccurs="0"/>
 *         &lt;element name="EDP" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}EDPType" minOccurs="0"/>
 *         &lt;element name="simpleEDP" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}simpleEDPType" minOccurs="0"/>
 *         &lt;element name="leaseDuration" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="leaseAnnouncement" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="initialAnnouncements" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}initialAnnouncementsType" minOccurs="0"/>
 *         &lt;element name="clientAnnouncementPeriod" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}durationType" minOccurs="0"/>
 *         &lt;element name="static_edp_xml_config" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discoverySettingsType", propOrder = {

})
public class DiscoverySettingsType {

    @XmlSchemaType(name = "string")
    protected DiscoveryProtocolType discoveryProtocol;
    protected DiscoveryServersListType discoveryServersList;
    protected String ignoreParticipantFlags;
    @XmlElement(name = "EDP")
    @XmlSchemaType(name = "string")
    protected EDPType edp;
    protected SimpleEDPType simpleEDP;
    protected DurationType leaseDuration;
    protected DurationType leaseAnnouncement;
    protected InitialAnnouncementsType initialAnnouncements;
    protected DurationType clientAnnouncementPeriod;
    @XmlElement(name = "static_edp_xml_config")
    protected String staticEdpXmlConfig;

    /**
     * Gets the value of the discoveryProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link DiscoveryProtocolType }
     *     
     */
    public DiscoveryProtocolType getDiscoveryProtocol() {
        return discoveryProtocol;
    }

    /**
     * Sets the value of the discoveryProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscoveryProtocolType }
     *     
     */
    public void setDiscoveryProtocol(DiscoveryProtocolType value) {
        this.discoveryProtocol = value;
    }

    /**
     * Gets the value of the discoveryServersList property.
     * 
     * @return
     *     possible object is
     *     {@link DiscoveryServersListType }
     *     
     */
    public DiscoveryServersListType getDiscoveryServersList() {
        return discoveryServersList;
    }

    /**
     * Sets the value of the discoveryServersList property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiscoveryServersListType }
     *     
     */
    public void setDiscoveryServersList(DiscoveryServersListType value) {
        this.discoveryServersList = value;
    }

    /**
     * Gets the value of the ignoreParticipantFlags property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIgnoreParticipantFlags() {
        return ignoreParticipantFlags;
    }

    /**
     * Sets the value of the ignoreParticipantFlags property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIgnoreParticipantFlags(String value) {
        this.ignoreParticipantFlags = value;
    }

    /**
     * Gets the value of the edp property.
     * 
     * @return
     *     possible object is
     *     {@link EDPType }
     *     
     */
    public EDPType getEDP() {
        return edp;
    }

    /**
     * Sets the value of the edp property.
     * 
     * @param value
     *     allowed object is
     *     {@link EDPType }
     *     
     */
    public void setEDP(EDPType value) {
        this.edp = value;
    }

    /**
     * Gets the value of the simpleEDP property.
     * 
     * @return
     *     possible object is
     *     {@link SimpleEDPType }
     *     
     */
    public SimpleEDPType getSimpleEDP() {
        return simpleEDP;
    }

    /**
     * Sets the value of the simpleEDP property.
     * 
     * @param value
     *     allowed object is
     *     {@link SimpleEDPType }
     *     
     */
    public void setSimpleEDP(SimpleEDPType value) {
        this.simpleEDP = value;
    }

    /**
     * Gets the value of the leaseDuration property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getLeaseDuration() {
        return leaseDuration;
    }

    /**
     * Sets the value of the leaseDuration property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setLeaseDuration(DurationType value) {
        this.leaseDuration = value;
    }

    /**
     * Gets the value of the leaseAnnouncement property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getLeaseAnnouncement() {
        return leaseAnnouncement;
    }

    /**
     * Sets the value of the leaseAnnouncement property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setLeaseAnnouncement(DurationType value) {
        this.leaseAnnouncement = value;
    }

    /**
     * Gets the value of the initialAnnouncements property.
     * 
     * @return
     *     possible object is
     *     {@link InitialAnnouncementsType }
     *     
     */
    public InitialAnnouncementsType getInitialAnnouncements() {
        return initialAnnouncements;
    }

    /**
     * Sets the value of the initialAnnouncements property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitialAnnouncementsType }
     *     
     */
    public void setInitialAnnouncements(InitialAnnouncementsType value) {
        this.initialAnnouncements = value;
    }

    /**
     * Gets the value of the clientAnnouncementPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link DurationType }
     *     
     */
    public DurationType getClientAnnouncementPeriod() {
        return clientAnnouncementPeriod;
    }

    /**
     * Sets the value of the clientAnnouncementPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link DurationType }
     *     
     */
    public void setClientAnnouncementPeriod(DurationType value) {
        this.clientAnnouncementPeriod = value;
    }

    /**
     * Gets the value of the staticEdpXmlConfig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStaticEdpXmlConfig() {
        return staticEdpXmlConfig;
    }

    /**
     * Sets the value of the staticEdpXmlConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStaticEdpXmlConfig(String value) {
        this.staticEdpXmlConfig = value;
    }

}
