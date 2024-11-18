
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for participantProfileType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="participantProfileType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="domainId" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}domainIDType" minOccurs="0"/>
 *         &lt;element name="rtps" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;all>
 *                   &lt;element name="name" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" minOccurs="0"/>
 *                   &lt;element name="defaultUnicastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
 *                   &lt;element name="defaultMulticastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
 *                   &lt;element name="default_external_unicast_locators" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}externalLocatorListType" minOccurs="0"/>
 *                   &lt;element name="ignore_non_matching_locators" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" minOccurs="0"/>
 *                   &lt;element name="sendSocketBufferSize" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                   &lt;element name="listenSocketBufferSize" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *                   &lt;element name="netmask_filter" minOccurs="0">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="OFF"/>
 *                         &lt;enumeration value="AUTO"/>
 *                         &lt;enumeration value="ON"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="builtin" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}builtinAttributesType" minOccurs="0"/>
 *                   &lt;element name="port" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}portType" minOccurs="0"/>
 *                   &lt;element name="participantID" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
 *                   &lt;element name="userTransports" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="transport_id" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" maxOccurs="unbounded"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="useBuiltinTransports" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" minOccurs="0"/>
 *                   &lt;element name="builtinTransports" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}builtinTransportsType" minOccurs="0"/>
 *                   &lt;element name="propertiesPolicy" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}propertyPolicyType" minOccurs="0"/>
 *                   &lt;element name="allocation" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}rtpsParticipantAllocationAttributesType" minOccurs="0"/>
 *                   &lt;element name="userData" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}octectVectorQosPolicyType" minOccurs="0"/>
 *                   &lt;element name="prefix" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}prefixType" minOccurs="0"/>
 *                   &lt;element name="flow_controller_descriptor_list" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}flowControllerDescriptorListType" minOccurs="0"/>
 *                   &lt;element name="builtin_controllers_sender_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *                   &lt;element name="timed_events_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *                   &lt;element name="discovery_server_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *                   &lt;element name="builtin_transports_reception_threads" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *                   &lt;element name="security_log_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
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
@XmlType(name = "participantProfileType", propOrder = {

})
public class ParticipantProfileType {

    @XmlSchemaType(name = "integer")
    protected Integer domainId;
    protected ParticipantProfileType.Rtps rtps;
    @XmlAttribute(name = "profile_name", required = true)
    protected String profileName;
    @XmlAttribute(name = "is_default_profile")
    protected Boolean isDefaultProfile;

    /**
     * Gets the value of the domainId property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDomainId() {
        return domainId;
    }

    /**
     * Sets the value of the domainId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDomainId(Integer value) {
        this.domainId = value;
    }

    /**
     * Gets the value of the rtps property.
     * 
     * @return
     *     possible object is
     *     {@link ParticipantProfileType.Rtps }
     *     
     */
    public ParticipantProfileType.Rtps getRtps() {
        return rtps;
    }

    /**
     * Sets the value of the rtps property.
     * 
     * @param value
     *     allowed object is
     *     {@link ParticipantProfileType.Rtps }
     *     
     */
    public void setRtps(ParticipantProfileType.Rtps value) {
        this.rtps = value;
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
     *         &lt;element name="name" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" minOccurs="0"/>
     *         &lt;element name="defaultUnicastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
     *         &lt;element name="defaultMulticastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
     *         &lt;element name="default_external_unicast_locators" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}externalLocatorListType" minOccurs="0"/>
     *         &lt;element name="ignore_non_matching_locators" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" minOccurs="0"/>
     *         &lt;element name="sendSocketBufferSize" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *         &lt;element name="listenSocketBufferSize" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
     *         &lt;element name="netmask_filter" minOccurs="0">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="OFF"/>
     *               &lt;enumeration value="AUTO"/>
     *               &lt;enumeration value="ON"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="builtin" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}builtinAttributesType" minOccurs="0"/>
     *         &lt;element name="port" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}portType" minOccurs="0"/>
     *         &lt;element name="participantID" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}int32" minOccurs="0"/>
     *         &lt;element name="userTransports" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="transport_id" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" maxOccurs="unbounded"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="useBuiltinTransports" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}boolean" minOccurs="0"/>
     *         &lt;element name="builtinTransports" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}builtinTransportsType" minOccurs="0"/>
     *         &lt;element name="propertiesPolicy" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}propertyPolicyType" minOccurs="0"/>
     *         &lt;element name="allocation" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}rtpsParticipantAllocationAttributesType" minOccurs="0"/>
     *         &lt;element name="userData" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}octectVectorQosPolicyType" minOccurs="0"/>
     *         &lt;element name="prefix" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}prefixType" minOccurs="0"/>
     *         &lt;element name="flow_controller_descriptor_list" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}flowControllerDescriptorListType" minOccurs="0"/>
     *         &lt;element name="builtin_controllers_sender_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
     *         &lt;element name="timed_events_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
     *         &lt;element name="discovery_server_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
     *         &lt;element name="builtin_transports_reception_threads" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
     *         &lt;element name="security_log_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
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
    public static class Rtps {

        protected String name;
        protected LocatorListType defaultUnicastLocatorList;
        protected LocatorListType defaultMulticastLocatorList;
        @XmlElement(name = "default_external_unicast_locators")
        protected ExternalLocatorListType defaultExternalUnicastLocators;
        @XmlElement(name = "ignore_non_matching_locators")
        protected Boolean ignoreNonMatchingLocators;
        @XmlSchemaType(name = "unsignedInt")
        protected Long sendSocketBufferSize;
        @XmlSchemaType(name = "unsignedInt")
        protected Long listenSocketBufferSize;
        @XmlElement(name = "netmask_filter")
        protected String netmaskFilter;
        protected BuiltinAttributesType builtin;
        protected PortType port;
        protected Integer participantID;
        protected ParticipantProfileType.Rtps.UserTransports userTransports;
        protected Boolean useBuiltinTransports;
        protected BuiltinTransportsType builtinTransports;
        protected PropertyPolicyType propertiesPolicy;
        protected RtpsParticipantAllocationAttributesType allocation;
        protected OctectVectorQosPolicyType userData;
        protected String prefix;
        @XmlElement(name = "flow_controller_descriptor_list")
        protected FlowControllerDescriptorListType flowControllerDescriptorList;
        @XmlElement(name = "builtin_controllers_sender_thread")
        protected ThreadSettingsType builtinControllersSenderThread;
        @XmlElement(name = "timed_events_thread")
        protected ThreadSettingsType timedEventsThread;
        @XmlElement(name = "discovery_server_thread")
        protected ThreadSettingsType discoveryServerThread;
        @XmlElement(name = "builtin_transports_reception_threads")
        protected ThreadSettingsType builtinTransportsReceptionThreads;
        @XmlElement(name = "security_log_thread")
        protected ThreadSettingsType securityLogThread;

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
         * Gets the value of the defaultUnicastLocatorList property.
         * 
         * @return
         *     possible object is
         *     {@link LocatorListType }
         *     
         */
        public LocatorListType getDefaultUnicastLocatorList() {
            return defaultUnicastLocatorList;
        }

        /**
         * Sets the value of the defaultUnicastLocatorList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocatorListType }
         *     
         */
        public void setDefaultUnicastLocatorList(LocatorListType value) {
            this.defaultUnicastLocatorList = value;
        }

        /**
         * Gets the value of the defaultMulticastLocatorList property.
         * 
         * @return
         *     possible object is
         *     {@link LocatorListType }
         *     
         */
        public LocatorListType getDefaultMulticastLocatorList() {
            return defaultMulticastLocatorList;
        }

        /**
         * Sets the value of the defaultMulticastLocatorList property.
         * 
         * @param value
         *     allowed object is
         *     {@link LocatorListType }
         *     
         */
        public void setDefaultMulticastLocatorList(LocatorListType value) {
            this.defaultMulticastLocatorList = value;
        }

        /**
         * Gets the value of the defaultExternalUnicastLocators property.
         * 
         * @return
         *     possible object is
         *     {@link ExternalLocatorListType }
         *     
         */
        public ExternalLocatorListType getDefaultExternalUnicastLocators() {
            return defaultExternalUnicastLocators;
        }

        /**
         * Sets the value of the defaultExternalUnicastLocators property.
         * 
         * @param value
         *     allowed object is
         *     {@link ExternalLocatorListType }
         *     
         */
        public void setDefaultExternalUnicastLocators(ExternalLocatorListType value) {
            this.defaultExternalUnicastLocators = value;
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
         * Gets the value of the sendSocketBufferSize property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getSendSocketBufferSize() {
            return sendSocketBufferSize;
        }

        /**
         * Sets the value of the sendSocketBufferSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setSendSocketBufferSize(Long value) {
            this.sendSocketBufferSize = value;
        }

        /**
         * Gets the value of the listenSocketBufferSize property.
         * 
         * @return
         *     possible object is
         *     {@link Long }
         *     
         */
        public Long getListenSocketBufferSize() {
            return listenSocketBufferSize;
        }

        /**
         * Sets the value of the listenSocketBufferSize property.
         * 
         * @param value
         *     allowed object is
         *     {@link Long }
         *     
         */
        public void setListenSocketBufferSize(Long value) {
            this.listenSocketBufferSize = value;
        }

        /**
         * Gets the value of the netmaskFilter property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getNetmaskFilter() {
            return netmaskFilter;
        }

        /**
         * Sets the value of the netmaskFilter property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setNetmaskFilter(String value) {
            this.netmaskFilter = value;
        }

        /**
         * Gets the value of the builtin property.
         * 
         * @return
         *     possible object is
         *     {@link BuiltinAttributesType }
         *     
         */
        public BuiltinAttributesType getBuiltin() {
            return builtin;
        }

        /**
         * Sets the value of the builtin property.
         * 
         * @param value
         *     allowed object is
         *     {@link BuiltinAttributesType }
         *     
         */
        public void setBuiltin(BuiltinAttributesType value) {
            this.builtin = value;
        }

        /**
         * Gets the value of the port property.
         * 
         * @return
         *     possible object is
         *     {@link PortType }
         *     
         */
        public PortType getPort() {
            return port;
        }

        /**
         * Sets the value of the port property.
         * 
         * @param value
         *     allowed object is
         *     {@link PortType }
         *     
         */
        public void setPort(PortType value) {
            this.port = value;
        }

        /**
         * Gets the value of the participantID property.
         * 
         * @return
         *     possible object is
         *     {@link Integer }
         *     
         */
        public Integer getParticipantID() {
            return participantID;
        }

        /**
         * Sets the value of the participantID property.
         * 
         * @param value
         *     allowed object is
         *     {@link Integer }
         *     
         */
        public void setParticipantID(Integer value) {
            this.participantID = value;
        }

        /**
         * Gets the value of the userTransports property.
         * 
         * @return
         *     possible object is
         *     {@link ParticipantProfileType.Rtps.UserTransports }
         *     
         */
        public ParticipantProfileType.Rtps.UserTransports getUserTransports() {
            return userTransports;
        }

        /**
         * Sets the value of the userTransports property.
         * 
         * @param value
         *     allowed object is
         *     {@link ParticipantProfileType.Rtps.UserTransports }
         *     
         */
        public void setUserTransports(ParticipantProfileType.Rtps.UserTransports value) {
            this.userTransports = value;
        }

        /**
         * Gets the value of the useBuiltinTransports property.
         * 
         * @return
         *     possible object is
         *     {@link Boolean }
         *     
         */
        public Boolean isUseBuiltinTransports() {
            return useBuiltinTransports;
        }

        /**
         * Sets the value of the useBuiltinTransports property.
         * 
         * @param value
         *     allowed object is
         *     {@link Boolean }
         *     
         */
        public void setUseBuiltinTransports(Boolean value) {
            this.useBuiltinTransports = value;
        }

        /**
         * Gets the value of the builtinTransports property.
         * 
         * @return
         *     possible object is
         *     {@link BuiltinTransportsType }
         *     
         */
        public BuiltinTransportsType getBuiltinTransports() {
            return builtinTransports;
        }

        /**
         * Sets the value of the builtinTransports property.
         * 
         * @param value
         *     allowed object is
         *     {@link BuiltinTransportsType }
         *     
         */
        public void setBuiltinTransports(BuiltinTransportsType value) {
            this.builtinTransports = value;
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
         * Gets the value of the allocation property.
         * 
         * @return
         *     possible object is
         *     {@link RtpsParticipantAllocationAttributesType }
         *     
         */
        public RtpsParticipantAllocationAttributesType getAllocation() {
            return allocation;
        }

        /**
         * Sets the value of the allocation property.
         * 
         * @param value
         *     allowed object is
         *     {@link RtpsParticipantAllocationAttributesType }
         *     
         */
        public void setAllocation(RtpsParticipantAllocationAttributesType value) {
            this.allocation = value;
        }

        /**
         * Gets the value of the userData property.
         * 
         * @return
         *     possible object is
         *     {@link OctectVectorQosPolicyType }
         *     
         */
        public OctectVectorQosPolicyType getUserData() {
            return userData;
        }

        /**
         * Sets the value of the userData property.
         * 
         * @param value
         *     allowed object is
         *     {@link OctectVectorQosPolicyType }
         *     
         */
        public void setUserData(OctectVectorQosPolicyType value) {
            this.userData = value;
        }

        /**
         * Gets the value of the prefix property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getPrefix() {
            return prefix;
        }

        /**
         * Sets the value of the prefix property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setPrefix(String value) {
            this.prefix = value;
        }

        /**
         * Gets the value of the flowControllerDescriptorList property.
         * 
         * @return
         *     possible object is
         *     {@link FlowControllerDescriptorListType }
         *     
         */
        public FlowControllerDescriptorListType getFlowControllerDescriptorList() {
            return flowControllerDescriptorList;
        }

        /**
         * Sets the value of the flowControllerDescriptorList property.
         * 
         * @param value
         *     allowed object is
         *     {@link FlowControllerDescriptorListType }
         *     
         */
        public void setFlowControllerDescriptorList(FlowControllerDescriptorListType value) {
            this.flowControllerDescriptorList = value;
        }

        /**
         * Gets the value of the builtinControllersSenderThread property.
         * 
         * @return
         *     possible object is
         *     {@link ThreadSettingsType }
         *     
         */
        public ThreadSettingsType getBuiltinControllersSenderThread() {
            return builtinControllersSenderThread;
        }

        /**
         * Sets the value of the builtinControllersSenderThread property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThreadSettingsType }
         *     
         */
        public void setBuiltinControllersSenderThread(ThreadSettingsType value) {
            this.builtinControllersSenderThread = value;
        }

        /**
         * Gets the value of the timedEventsThread property.
         * 
         * @return
         *     possible object is
         *     {@link ThreadSettingsType }
         *     
         */
        public ThreadSettingsType getTimedEventsThread() {
            return timedEventsThread;
        }

        /**
         * Sets the value of the timedEventsThread property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThreadSettingsType }
         *     
         */
        public void setTimedEventsThread(ThreadSettingsType value) {
            this.timedEventsThread = value;
        }

        /**
         * Gets the value of the discoveryServerThread property.
         * 
         * @return
         *     possible object is
         *     {@link ThreadSettingsType }
         *     
         */
        public ThreadSettingsType getDiscoveryServerThread() {
            return discoveryServerThread;
        }

        /**
         * Sets the value of the discoveryServerThread property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThreadSettingsType }
         *     
         */
        public void setDiscoveryServerThread(ThreadSettingsType value) {
            this.discoveryServerThread = value;
        }

        /**
         * Gets the value of the builtinTransportsReceptionThreads property.
         * 
         * @return
         *     possible object is
         *     {@link ThreadSettingsType }
         *     
         */
        public ThreadSettingsType getBuiltinTransportsReceptionThreads() {
            return builtinTransportsReceptionThreads;
        }

        /**
         * Sets the value of the builtinTransportsReceptionThreads property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThreadSettingsType }
         *     
         */
        public void setBuiltinTransportsReceptionThreads(ThreadSettingsType value) {
            this.builtinTransportsReceptionThreads = value;
        }

        /**
         * Gets the value of the securityLogThread property.
         * 
         * @return
         *     possible object is
         *     {@link ThreadSettingsType }
         *     
         */
        public ThreadSettingsType getSecurityLogThread() {
            return securityLogThread;
        }

        /**
         * Sets the value of the securityLogThread property.
         * 
         * @param value
         *     allowed object is
         *     {@link ThreadSettingsType }
         *     
         */
        public void setSecurityLogThread(ThreadSettingsType value) {
            this.securityLogThread = value;
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
         *       &lt;sequence>
         *         &lt;element name="transport_id" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" maxOccurs="unbounded"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "transportId"
        })
        public static class UserTransports {

            @XmlElement(name = "transport_id", required = true)
            protected List<String> transportId;

            /**
             * Gets the value of the transportId property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the transportId property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getTransportId().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link String }
             * 
             * 
             */
            public List<String> getTransportId() {
                if (transportId == null) {
                    transportId = new ArrayList<String>();
                }
                return this.transportId;
            }

        }

    }

}
