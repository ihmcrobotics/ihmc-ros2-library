
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for locatorListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="locatorListType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="locator" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;choice>
 *                   &lt;element name="udpv4" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}udpv4LocatorType" maxOccurs="unbounded"/>
 *                   &lt;element name="udpv6" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}udpv6LocatorType" maxOccurs="unbounded"/>
 *                   &lt;element name="tcpv4" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}tcpv4LocatorType" maxOccurs="unbounded"/>
 *                   &lt;element name="tcpv6" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}tcpv6LocatorType" maxOccurs="unbounded"/>
 *                 &lt;/choice>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locatorListType", propOrder = {
    "locator"
})
public class LocatorListType {

    @XmlElement(required = true)
    protected List<LocatorListType.Locator> locator;

    /**
     * Gets the value of the locator property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locator property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocator().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocatorListType.Locator }
     * 
     * 
     */
    public List<LocatorListType.Locator> getLocator() {
        if (locator == null) {
            locator = new ArrayList<LocatorListType.Locator>();
        }
        return this.locator;
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
     *       &lt;choice>
     *         &lt;element name="udpv4" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}udpv4LocatorType" maxOccurs="unbounded"/>
     *         &lt;element name="udpv6" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}udpv6LocatorType" maxOccurs="unbounded"/>
     *         &lt;element name="tcpv4" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}tcpv4LocatorType" maxOccurs="unbounded"/>
     *         &lt;element name="tcpv6" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}tcpv6LocatorType" maxOccurs="unbounded"/>
     *       &lt;/choice>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "udpv4",
        "udpv6",
        "tcpv4",
        "tcpv6"
    })
    public static class Locator {

        protected List<Udpv4LocatorType> udpv4;
        protected List<Udpv6LocatorType> udpv6;
        protected List<Tcpv4LocatorType> tcpv4;
        protected List<Tcpv6LocatorType> tcpv6;

        /**
         * Gets the value of the udpv4 property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the udpv4 property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUdpv4().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Udpv4LocatorType }
         * 
         * 
         */
        public List<Udpv4LocatorType> getUdpv4() {
            if (udpv4 == null) {
                udpv4 = new ArrayList<Udpv4LocatorType>();
            }
            return this.udpv4;
        }

        /**
         * Gets the value of the udpv6 property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the udpv6 property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getUdpv6().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Udpv6LocatorType }
         * 
         * 
         */
        public List<Udpv6LocatorType> getUdpv6() {
            if (udpv6 == null) {
                udpv6 = new ArrayList<Udpv6LocatorType>();
            }
            return this.udpv6;
        }

        /**
         * Gets the value of the tcpv4 property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tcpv4 property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTcpv4().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Tcpv4LocatorType }
         * 
         * 
         */
        public List<Tcpv4LocatorType> getTcpv4() {
            if (tcpv4 == null) {
                tcpv4 = new ArrayList<Tcpv4LocatorType>();
            }
            return this.tcpv4;
        }

        /**
         * Gets the value of the tcpv6 property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the tcpv6 property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getTcpv6().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Tcpv6LocatorType }
         * 
         * 
         */
        public List<Tcpv6LocatorType> getTcpv6() {
            if (tcpv6 == null) {
                tcpv6 = new ArrayList<Tcpv6LocatorType>();
            }
            return this.tcpv6;
        }

    }

}
