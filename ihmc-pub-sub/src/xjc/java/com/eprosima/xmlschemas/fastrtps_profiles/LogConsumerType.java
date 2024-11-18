
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for logConsumerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="logConsumerType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice>
 *           &lt;element name="class" minOccurs="0">
 *             &lt;simpleType>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                 &lt;enumeration value="StdoutConsumer"/>
 *                 &lt;enumeration value="StdoutErrConsumer"/>
 *                 &lt;enumeration value="FileConsumer"/>
 *               &lt;/restriction>
 *             &lt;/simpleType>
 *           &lt;/element>
 *           &lt;element name="property" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}logConsumerPropertyType" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "logConsumerType", propOrder = {
    "clazzOrProperty"
})
public class LogConsumerType {

    @XmlElements({
        @XmlElement(name = "class", type = String.class),
        @XmlElement(name = "property", type = LogConsumerPropertyType.class)
    })
    protected List<Object> clazzOrProperty;

    /**
     * Gets the value of the clazzOrProperty property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clazzOrProperty property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClazzOrProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * {@link LogConsumerPropertyType }
     * 
     * 
     */
    public List<Object> getClazzOrProperty() {
        if (clazzOrProperty == null) {
            clazzOrProperty = new ArrayList<Object>();
        }
        return this.clazzOrProperty;
    }

}
