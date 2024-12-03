
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElementRef;
import jakarta.xml.bind.annotation.XmlElementRefs;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for remoteServerAttributesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="remoteServerAttributesType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;sequence>
 *           &lt;element name="metatrafficUnicastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType"/>
 *           &lt;element name="metatrafficMulticastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
 *         &lt;/sequence>
 *         &lt;sequence>
 *           &lt;element name="metatrafficMulticastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType"/>
 *           &lt;element name="metatrafficUnicastLocatorList" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}locatorListType" minOccurs="0"/>
 *         &lt;/sequence>
 *       &lt;/choice>
 *       &lt;attribute name="prefix" use="required" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}guid" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "remoteServerAttributesType", propOrder = {
    "content"
})
public class RemoteServerAttributesType {

    @XmlElementRefs({
        @XmlElementRef(name = "metatrafficMulticastLocatorList", namespace = "http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "metatrafficUnicastLocatorList", namespace = "http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<LocatorListType>> content;
    @XmlAttribute(name = "prefix", required = true)
    protected String prefix;

    /**
     * Gets the rest of the content model. 
     * 
     * <p>
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "MetatrafficMulticastLocatorList" is used by two different parts of a schema. See: 
     * line 723 of file:/home/runner/work/ihmc-ros2-library/ihmc-ros2-library/ihmc-pub-sub/thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd
     * line 720 of file:/home/runner/work/ihmc-ros2-library/ihmc-ros2-library/ihmc-pub-sub/thirdparty/Fast-RTPS/resources/xsd/fastRTPS_profiles.xsd
     * <p>
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link LocatorListType }{@code >}
     * {@link JAXBElement }{@code <}{@link LocatorListType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<LocatorListType>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<LocatorListType>>();
        }
        return this.content;
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

}
