
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ownershipQosKindPolicyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ownershipQosKindPolicyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SHARED"/>
 *     &lt;enumeration value="EXCLUSIVE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ownershipQosKindPolicyType")
@XmlEnum
public enum OwnershipQosKindPolicyType {

    SHARED,
    EXCLUSIVE;

    public String value() {
        return name();
    }

    public static OwnershipQosKindPolicyType fromValue(String v) {
        return valueOf(v);
    }

}
