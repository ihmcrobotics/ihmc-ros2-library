
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for historyMemoryPolicyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="historyMemoryPolicyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PREALLOCATED"/>
 *     &lt;enumeration value="PREALLOCATED_WITH_REALLOC"/>
 *     &lt;enumeration value="DYNAMIC"/>
 *     &lt;enumeration value="DYNAMIC_REUSABLE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "historyMemoryPolicyType")
@XmlEnum
public enum HistoryMemoryPolicyType {

    PREALLOCATED,
    PREALLOCATED_WITH_REALLOC,
    DYNAMIC,
    DYNAMIC_REUSABLE;

    public String value() {
        return name();
    }

    public static HistoryMemoryPolicyType fromValue(String v) {
        return valueOf(v);
    }

}
