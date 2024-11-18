
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nonBasicType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="nonBasicType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="nonBasic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "nonBasicType")
@XmlEnum
public enum NonBasicType {

    @XmlEnumValue("nonBasic")
    NON_BASIC("nonBasic");
    private final String value;

    NonBasicType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static NonBasicType fromValue(String v) {
        for (NonBasicType c: NonBasicType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
