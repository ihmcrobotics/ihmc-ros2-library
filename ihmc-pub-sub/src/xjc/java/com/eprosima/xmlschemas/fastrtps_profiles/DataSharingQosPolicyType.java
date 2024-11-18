
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataSharingQosPolicyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataSharingQosPolicyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="kind">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="AUTOMATIC"/>
 *               &lt;enumeration value="ON"/>
 *               &lt;enumeration value="OFF"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="shared_dir" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}string" minOccurs="0"/>
 *         &lt;element name="domain_ids" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="domainId" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="max_domains" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" minOccurs="0"/>
 *         &lt;element name="data_sharing_listener_thread" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}threadSettingsType" minOccurs="0"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataSharingQosPolicyType", propOrder = {

})
public class DataSharingQosPolicyType {

    @XmlElement(required = true)
    protected String kind;
    @XmlElement(name = "shared_dir")
    protected String sharedDir;
    @XmlElement(name = "domain_ids")
    protected DataSharingQosPolicyType.DomainIds domainIds;
    @XmlElement(name = "max_domains")
    @XmlSchemaType(name = "unsignedInt")
    protected Long maxDomains;
    @XmlElement(name = "data_sharing_listener_thread")
    protected ThreadSettingsType dataSharingListenerThread;

    /**
     * Gets the value of the kind property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKind() {
        return kind;
    }

    /**
     * Sets the value of the kind property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKind(String value) {
        this.kind = value;
    }

    /**
     * Gets the value of the sharedDir property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSharedDir() {
        return sharedDir;
    }

    /**
     * Sets the value of the sharedDir property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSharedDir(String value) {
        this.sharedDir = value;
    }

    /**
     * Gets the value of the domainIds property.
     * 
     * @return
     *     possible object is
     *     {@link DataSharingQosPolicyType.DomainIds }
     *     
     */
    public DataSharingQosPolicyType.DomainIds getDomainIds() {
        return domainIds;
    }

    /**
     * Sets the value of the domainIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataSharingQosPolicyType.DomainIds }
     *     
     */
    public void setDomainIds(DataSharingQosPolicyType.DomainIds value) {
        this.domainIds = value;
    }

    /**
     * Gets the value of the maxDomains property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxDomains() {
        return maxDomains;
    }

    /**
     * Sets the value of the maxDomains property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxDomains(Long value) {
        this.maxDomains = value;
    }

    /**
     * Gets the value of the dataSharingListenerThread property.
     * 
     * @return
     *     possible object is
     *     {@link ThreadSettingsType }
     *     
     */
    public ThreadSettingsType getDataSharingListenerThread() {
        return dataSharingListenerThread;
    }

    /**
     * Sets the value of the dataSharingListenerThread property.
     * 
     * @param value
     *     allowed object is
     *     {@link ThreadSettingsType }
     *     
     */
    public void setDataSharingListenerThread(ThreadSettingsType value) {
        this.dataSharingListenerThread = value;
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
     *         &lt;element name="domainId" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}uint32" maxOccurs="unbounded" minOccurs="0"/>
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
        "domainId"
    })
    public static class DomainIds {

        @XmlElement(type = Long.class)
        @XmlSchemaType(name = "unsignedInt")
        protected List<Long> domainId;

        /**
         * Gets the value of the domainId property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the domainId property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDomainId().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Long }
         * 
         * 
         */
        public List<Long> getDomainId() {
            if (domainId == null) {
                domainId = new ArrayList<Long>();
            }
            return this.domainId;
        }

    }

}
