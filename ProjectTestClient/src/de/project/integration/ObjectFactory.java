
package de.project.integration;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.project.integration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateProject_QNAME = new QName("http://integration.project.de/", "createProject");
    private final static QName _CreateProjectResponse_QNAME = new QName("http://integration.project.de/", "createProjectResponse");
    private final static QName _UpdateProjectResponse_QNAME = new QName("http://integration.project.de/", "updateProjectResponse");
    private final static QName _GetProjectsByPhone_QNAME = new QName("http://integration.project.de/", "getProjectsByPhone");
    private final static QName _GetProjectsByPhoneResponse_QNAME = new QName("http://integration.project.de/", "getProjectsByPhoneResponse");
    private final static QName _UpdateProject_QNAME = new QName("http://integration.project.de/", "updateProject");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.project.integration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateProject }
     * 
     */
    public UpdateProject createUpdateProject() {
        return new UpdateProject();
    }

    /**
     * Create an instance of {@link UpdateProjectResponse }
     * 
     */
    public UpdateProjectResponse createUpdateProjectResponse() {
        return new UpdateProjectResponse();
    }

    /**
     * Create an instance of {@link CreateProject }
     * 
     */
    public CreateProject createCreateProject() {
        return new CreateProject();
    }

    /**
     * Create an instance of {@link CreateProjectResponse }
     * 
     */
    public CreateProjectResponse createCreateProjectResponse() {
        return new CreateProjectResponse();
    }

    /**
     * Create an instance of {@link GetProjectsByPhone }
     * 
     */
    public GetProjectsByPhone createGetProjectsByPhone() {
        return new GetProjectsByPhone();
    }

    /**
     * Create an instance of {@link GetProjectsByPhoneResponse }
     * 
     */
    public GetProjectsByPhoneResponse createGetProjectsByPhoneResponse() {
        return new GetProjectsByPhoneResponse();
    }

    /**
     * Create an instance of {@link MilestoneTO }
     * 
     */
    public MilestoneTO createMilestoneTO() {
        return new MilestoneTO();
    }

    /**
     * Create an instance of {@link NoteTO }
     * 
     */
    public NoteTO createNoteTO() {
        return new NoteTO();
    }

    /**
     * Create an instance of {@link UserTO }
     * 
     */
    public UserTO createUserTO() {
        return new UserTO();
    }

    /**
     * Create an instance of {@link ProjectResponse }
     * 
     */
    public ProjectResponse createProjectResponse() {
        return new ProjectResponse();
    }

    /**
     * Create an instance of {@link ProjectsResponse }
     * 
     */
    public ProjectsResponse createProjectsResponse() {
        return new ProjectsResponse();
    }

    /**
     * Create an instance of {@link AppointmentTO }
     * 
     */
    public AppointmentTO createAppointmentTO() {
        return new AppointmentTO();
    }

    /**
     * Create an instance of {@link DiscussionTO }
     * 
     */
    public DiscussionTO createDiscussionTO() {
        return new DiscussionTO();
    }

    /**
     * Create an instance of {@link ReturncodeResponse }
     * 
     */
    public ReturncodeResponse createReturncodeResponse() {
        return new ReturncodeResponse();
    }

    /**
     * Create an instance of {@link ProjectTO }
     * 
     */
    public ProjectTO createProjectTO() {
        return new ProjectTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "createProject")
    public JAXBElement<CreateProject> createCreateProject(CreateProject value) {
        return new JAXBElement<CreateProject>(_CreateProject_QNAME, CreateProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "createProjectResponse")
    public JAXBElement<CreateProjectResponse> createCreateProjectResponse(CreateProjectResponse value) {
        return new JAXBElement<CreateProjectResponse>(_CreateProjectResponse_QNAME, CreateProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "updateProjectResponse")
    public JAXBElement<UpdateProjectResponse> createUpdateProjectResponse(UpdateProjectResponse value) {
        return new JAXBElement<UpdateProjectResponse>(_UpdateProjectResponse_QNAME, UpdateProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectsByPhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getProjectsByPhone")
    public JAXBElement<GetProjectsByPhone> createGetProjectsByPhone(GetProjectsByPhone value) {
        return new JAXBElement<GetProjectsByPhone>(_GetProjectsByPhone_QNAME, GetProjectsByPhone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectsByPhoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getProjectsByPhoneResponse")
    public JAXBElement<GetProjectsByPhoneResponse> createGetProjectsByPhoneResponse(GetProjectsByPhoneResponse value) {
        return new JAXBElement<GetProjectsByPhoneResponse>(_GetProjectsByPhoneResponse_QNAME, GetProjectsByPhoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "updateProject")
    public JAXBElement<UpdateProject> createUpdateProject(UpdateProject value) {
        return new JAXBElement<UpdateProject>(_UpdateProject_QNAME, UpdateProject.class, null, value);
    }

}
