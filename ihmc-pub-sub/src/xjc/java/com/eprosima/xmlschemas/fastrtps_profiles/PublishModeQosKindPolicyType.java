
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for publishModeQosKindPolicyType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="publishModeQosKindPolicyType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SYNCHRONOUS"/>
 *     &lt;enumeration value="ASYNCHRONOUS"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "publishModeQosKindPolicyType")
@XmlEnum
public enum PublishModeQosKindPolicyType {

    SYNCHRONOUS,
    ASYNCHRONOUS;

    public String value() {
        return name();
    }

    public static PublishModeQosKindPolicyType fromValue(String v) {
        return valueOf(v);
    }

}
