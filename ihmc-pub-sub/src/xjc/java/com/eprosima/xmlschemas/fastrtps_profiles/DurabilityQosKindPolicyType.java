
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for durabilityQosKindPolicyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="durabilityQosKindPolicyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VOLATILE"/>
 *     &lt;enumeration value="TRANSIENT_LOCAL"/>
 *     &lt;enumeration value="TRANSIENT"/>
 *     &lt;enumeration value="PERSISTENT"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "durabilityQosKindPolicyType")
@XmlEnum
public enum DurabilityQosKindPolicyType {

    VOLATILE,
    TRANSIENT_LOCAL,
    TRANSIENT,
    PERSISTENT;

    public String value() {
        return name();
    }

    public static DurabilityQosKindPolicyType fromValue(String v) {
        return valueOf(v);
    }

}
