
package com.eprosima.xmlschemas.fastrtps_profiles;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for typeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="typeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice>
 *           &lt;element name="enum" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}enumDcl" maxOccurs="unbounded"/>
 *           &lt;element name="typedef" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}typedefDcl" maxOccurs="unbounded"/>
 *           &lt;element name="struct" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}structDcl" maxOccurs="unbounded"/>
 *           &lt;element name="union" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}unionDcl" maxOccurs="unbounded"/>
 *           &lt;element name="bitset" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}bitsetDcl" maxOccurs="unbounded"/>
 *           &lt;element name="bitmask" type="{http://www.eprosima.com/XMLSchemas/fastRTPS_Profiles}bitmaskDcl" maxOccurs="unbounded"/>
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
@XmlType(name = "typeType", propOrder = {
    "enumOrTypedefOrStruct"
})
public class TypeType {

    @XmlElements({
        @XmlElement(name = "enum", type = EnumDcl.class),
        @XmlElement(name = "typedef", type = TypedefDcl.class),
        @XmlElement(name = "struct", type = StructDcl.class),
        @XmlElement(name = "union", type = UnionDcl.class),
        @XmlElement(name = "bitset", type = BitsetDcl.class),
        @XmlElement(name = "bitmask", type = BitmaskDcl.class)
    })
    protected List<Object> enumOrTypedefOrStruct;

    /**
     * Gets the value of the enumOrTypedefOrStruct property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the enumOrTypedefOrStruct property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnumOrTypedefOrStruct().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EnumDcl }
     * {@link TypedefDcl }
     * {@link StructDcl }
     * {@link UnionDcl }
     * {@link BitsetDcl }
     * {@link BitmaskDcl }
     * 
     * 
     */
    public List<Object> getEnumOrTypedefOrStruct() {
        if (enumOrTypedefOrStruct == null) {
            enumOrTypedefOrStruct = new ArrayList<Object>();
        }
        return this.enumOrTypedefOrStruct;
    }

}
