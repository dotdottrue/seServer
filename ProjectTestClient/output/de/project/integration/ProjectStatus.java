
package de.project.integration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für projectStatus.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="projectStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INTIME"/>
 *     &lt;enumeration value="DELAYED"/>
 *     &lt;enumeration value="OUTOFTIME"/>
 *     &lt;enumeration value="FINISHED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "projectStatus")
@XmlEnum
public enum ProjectStatus {

    INTIME,
    DELAYED,
    OUTOFTIME,
    FINISHED;

    public String value() {
        return name();
    }

    public static ProjectStatus fromValue(String v) {
        return valueOf(v);
    }

}
