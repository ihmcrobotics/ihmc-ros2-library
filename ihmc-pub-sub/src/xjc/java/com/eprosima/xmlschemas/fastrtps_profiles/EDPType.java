
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EDPType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="EDPType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SIMPLE"/>
 *     &lt;enumeration value="STATIC"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "EDPType")
@XmlEnum
public enum EDPType {

    SIMPLE,
    STATIC;

    public String value() {
        return name();
    }

    public static EDPType fromValue(String v) {
        return valueOf(v);
    }

}
