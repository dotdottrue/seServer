
package de.project.integration;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für projectResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="projectResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://integration.project.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="project" type="{http://integration.project.de/}projectTO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectResponse", propOrder = {
    "project"
})
public class ProjectResponse
    extends ReturncodeResponse
{

    protected ProjectTO project;

    /**
     * Ruft den Wert der project-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProjectTO }
     *     
     */
    public ProjectTO getProject() {
        return project;
    }

    /**
     * Legt den Wert der project-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectTO }
     *     
     */
    public void setProject(ProjectTO value) {
        this.project = value;
    }

}
