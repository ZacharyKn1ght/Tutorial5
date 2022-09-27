//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.09.27 at 02:57:34 PM NZDT 
//


package nz.ac.massey.cs.sdc.parsers;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CloudProtocol.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="CloudProtocol"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="xml-rpc"/&gt;
 *     &lt;enumeration value="http-post"/&gt;
 *     &lt;enumeration value="soap"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CloudProtocol")
@XmlEnum
public enum CloudProtocol {

    @XmlEnumValue("xml-rpc")
    XML_RPC("xml-rpc"),
    @XmlEnumValue("http-post")
    HTTP_POST("http-post"),
    @XmlEnumValue("soap")
    SOAP("soap");
    private final String value;

    CloudProtocol(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CloudProtocol fromValue(String v) {
        for (CloudProtocol c: CloudProtocol.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
