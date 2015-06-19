
package de.project.integration;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für milestoneStatus.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="milestoneStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CREATED"/>
 *     &lt;enumeration value="INPROGRESS"/>
 *     &lt;enumeration value="DONE"/>
 *     &lt;enumeration value="DELAYED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "milestoneStatus")
@XmlEnum
public enum MilestoneStatus {

    CREATED,
    INPROGRESS,
    DONE,
    DELAYED;

    public String value() {
        return name();
    }

    public static MilestoneStatus fromValue(String v) {
        return valueOf(v);
    }

}
