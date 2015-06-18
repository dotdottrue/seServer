
package de.project.integration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für appointmentResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="appointmentResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://integration.project.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="appointments" type="{http://integration.project.de/}appointmentTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "appointmentResponse", propOrder = {
    "appointments"
})
public class AppointmentResponse
    extends ReturncodeResponse
{

    @XmlElement(nillable = true)
    protected List<AppointmentTO> appointments;

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

}
