
package de.project.integration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für notesResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="notesResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://integration.project.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="notes" type="{http://integration.project.de/}noteTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "notesResponse", propOrder = {
    "notes"
})
public class NotesResponse
    extends ReturncodeResponse
{

    @XmlElement(nillable = true)
    protected List<NoteTO> notes;

    /**
     * Gets the value of the notes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the notes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNotes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoteTO }
     * 
     * 
     */
    public List<NoteTO> getNotes() {
        if (notes == null) {
            notes = new ArrayList<NoteTO>();
        }
        return this.notes;
    }

}
