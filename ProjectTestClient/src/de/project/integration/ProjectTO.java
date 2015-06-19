
package de.project.integration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für projectTO complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="projectTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="appointments" type="{http://integration.project.de/}appointmentTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="discussions" type="{http://integration.project.de/}discussionTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="members" type="{http://integration.project.de/}userTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="milestones" type="{http://integration.project.de/}milestoneTO" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="owner" type="{http://integration.project.de/}userTO" minOccurs="0"/>
 *         &lt;element name="projectName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="projectStatus" type="{http://integration.project.de/}projectStatus" minOccurs="0"/>
 *         &lt;element name="updatedOn" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "projectTO", propOrder = {
    "appointments",
    "description",
    "discussions",
    "id",
    "members",
    "milestones",
    "owner",
    "projectName",
    "projectStatus",
    "updatedOn"
})
public class ProjectTO {

    @XmlElement(nillable = true)
    protected List<AppointmentTO> appointments;
    protected String description;
    @XmlElement(nillable = true)
    protected List<DiscussionTO> discussions;
    protected long id;
    @XmlElement(nillable = true)
    protected List<UserTO> members;
    @XmlElement(nillable = true)
    protected List<MilestoneTO> milestones;
    protected UserTO owner;
    protected String projectName;
    protected ProjectStatus projectStatus;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar updatedOn;

    /**
     * Gets the value of the appointments property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the appointments property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAppointments().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AppointmentTO }
     * 
     * 
     */
    public List<AppointmentTO> getAppointments() {
        if (appointments == null) {
            appointments = new ArrayList<AppointmentTO>();
        }
        return this.appointments;
    }

    /**
     * Ruft den Wert der description-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Legt den Wert der description-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the discussions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the discussions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDiscussions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DiscussionTO }
     * 
     * 
     */
    public List<DiscussionTO> getDiscussions() {
        if (discussions == null) {
            discussions = new ArrayList<DiscussionTO>();
        }
        return this.discussions;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the members property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the members property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMembers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserTO }
     * 
     * 
     */
    public List<UserTO> getMembers() {
        if (members == null) {
            members = new ArrayList<UserTO>();
        }
        return this.members;
    }

    /**
     * Gets the value of the milestones property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the milestones property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMilestones().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MilestoneTO }
     * 
     * 
     */
    public List<MilestoneTO> getMilestones() {
        if (milestones == null) {
            milestones = new ArrayList<MilestoneTO>();
        }
        return this.milestones;
    }

    /**
     * Ruft den Wert der owner-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link UserTO }
     *     
     */
    public UserTO getOwner() {
        return owner;
    }

    /**
     * Legt den Wert der owner-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTO }
     *     
     */
    public void setOwner(UserTO value) {
        this.owner = value;
    }

    /**
     * Ruft den Wert der projectName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Legt den Wert der projectName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProjectName(String value) {
        this.projectName = value;
    }

    /**
     * Ruft den Wert der projectStatus-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ProjectStatus }
     *     
     */
    public ProjectStatus getProjectStatus() {
        return projectStatus;
    }

    /**
     * Legt den Wert der projectStatus-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ProjectStatus }
     *     
     */
    public void setProjectStatus(ProjectStatus value) {
        this.projectStatus = value;
    }

    /**
     * Ruft den Wert der updatedOn-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getUpdatedOn() {
        return updatedOn;
    }

    /**
     * Legt den Wert der updatedOn-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setUpdatedOn(XMLGregorianCalendar value) {
        this.updatedOn = value;
    }

}
