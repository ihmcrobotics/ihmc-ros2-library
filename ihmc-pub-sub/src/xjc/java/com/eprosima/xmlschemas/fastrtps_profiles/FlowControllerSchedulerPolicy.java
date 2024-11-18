
package com.eprosima.xmlschemas.fastrtps_profiles;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for flowControllerSchedulerPolicy.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="flowControllerSchedulerPolicy">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="FIFO"/>
 *     &lt;enumeration value="ROUND_ROBIN"/>
 *     &lt;enumeration value="HIGH_PRIORITY"/>
 *     &lt;enumeration value="PRIORITY_WITH_RESERVATION"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "flowControllerSchedulerPolicy")
@XmlEnum
public enum FlowControllerSchedulerPolicy {

    FIFO,
    ROUND_ROBIN,
    HIGH_PRIORITY,
    PRIORITY_WITH_RESERVATION;

    public String value() {
        return name();
    }

    public static FlowControllerSchedulerPolicy fromValue(String v) {
        return valueOf(v);
    }

}
