
package de.project.integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für projectUserResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="projectUserResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://integration.project.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="session" type="{http://integration.project.de/}projectSessionTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectUserResponse", propOrder = {
    "session"
})
public class ProjectUserResponse
    extends ReturncodeResponse
{

    protected ProjectSessionTO session;

    /**
     * Ruft den Wert der session-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProjectSessionTO }
     *     
     */
    public ProjectSessionTO getSession() {
        return session;
    }

    /**
     * Legt den Wert der session-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectSessionTO }
     *     
     */
    public void setSession(ProjectSessionTO value) {
        this.session = value;
    }

}
