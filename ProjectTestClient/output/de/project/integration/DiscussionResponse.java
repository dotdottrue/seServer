
package de.project.integration;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für discussionResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="discussionResponse">
 *   &lt;complexContent>
 *     &lt;extension base="{http://integration.project.de/}returncodeResponse">
 *       &lt;sequence>
 *         &lt;element name="discussions" type="{http://integration.project.de/}discussionTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "discussionResponse", propOrder = {
    "discussions"
})
public class DiscussionResponse
    extends ReturncodeResponse
{

    @XmlElement(nillable = true)
    protected List<DiscussionTO> discussions;

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

}
