
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

    private final static QName _GetProjectsByPhoneResponse_QNAME = new QName("http://integration.project.de/", "getProjectsByPhoneResponse");
    private final static QName _ComparePhonebook_QNAME = new QName("http://integration.project.de/", "comparePhonebook");
    private final static QName _GetDiscussionsByProjectResponse_QNAME = new QName("http://integration.project.de/", "getDiscussionsByProjectResponse");
    private final static QName _AddNoteToDiscussionResponse_QNAME = new QName("http://integration.project.de/", "addNoteToDiscussionResponse");
    private final static QName _CreateProjectResponse_QNAME = new QName("http://integration.project.de/", "createProjectResponse");
    private final static QName _GetProjectsByPhone_QNAME = new QName("http://integration.project.de/", "getProjectsByPhone");
    private final static QName _RemoveProjectMember_QNAME = new QName("http://integration.project.de/", "removeProjectMember");
    private final static QName _GetNotesByDiscussionResponse_QNAME = new QName("http://integration.project.de/", "getNotesByDiscussionResponse");
    private final static QName _GetDiscussionsByProject_QNAME = new QName("http://integration.project.de/", "getDiscussionsByProject");
    private final static QName _UpdateProject_QNAME = new QName("http://integration.project.de/", "updateProject");
    private final static QName _CreateProject_QNAME = new QName("http://integration.project.de/", "createProject");
    private final static QName _AddAppointmentToProject_QNAME = new QName("http://integration.project.de/", "addAppointmentToProject");
    private final static QName _AddUserToProject_QNAME = new QName("http://integration.project.de/", "addUserToProject");
    private final static QName _UpdateProjectResponse_QNAME = new QName("http://integration.project.de/", "updateProjectResponse");
    private final static QName _GetAppointmentsByProjectResponse_QNAME = new QName("http://integration.project.de/", "getAppointmentsByProjectResponse");
    private final static QName _ComparePhonebookResponse_QNAME = new QName("http://integration.project.de/", "comparePhonebookResponse");
    private final static QName _AddNoteToDiscussion_QNAME = new QName("http://integration.project.de/", "addNoteToDiscussion");
    private final static QName _AddAppointmentToProjectResponse_QNAME = new QName("http://integration.project.de/", "addAppointmentToProjectResponse");
    private final static QName _RemoveProjectDiscussion_QNAME = new QName("http://integration.project.de/", "removeProjectDiscussion");
    private final static QName _AddDiscussionToProject_QNAME = new QName("http://integration.project.de/", "addDiscussionToProject");
    private final static QName _GetNotesByDiscussion_QNAME = new QName("http://integration.project.de/", "getNotesByDiscussion");
    private final static QName _RemoveProjectMemberResponse_QNAME = new QName("http://integration.project.de/", "removeProjectMemberResponse");
    private final static QName _AddDiscussionToProjectResponse_QNAME = new QName("http://integration.project.de/", "addDiscussionToProjectResponse");
    private final static QName _AddUserToProjectResponse_QNAME = new QName("http://integration.project.de/", "addUserToProjectResponse");
    private final static QName _GetAppointmentsByProject_QNAME = new QName("http://integration.project.de/", "getAppointmentsByProject");
    private final static QName _RemoveProjectDiscussionResponse_QNAME = new QName("http://integration.project.de/", "removeProjectDiscussionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.project.integration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddNoteToDiscussion }
     * 
     */
    public AddNoteToDiscussion createAddNoteToDiscussion() {
        return new AddNoteToDiscussion();
    }

    /**
     * Create an instance of {@link RemoveProjectDiscussion }
     * 
     */
    public RemoveProjectDiscussion createRemoveProjectDiscussion() {
        return new RemoveProjectDiscussion();
    }

    /**
     * Create an instance of {@link AddAppointmentToProjectResponse }
     * 
     */
    public AddAppointmentToProjectResponse createAddAppointmentToProjectResponse() {
        return new AddAppointmentToProjectResponse();
    }

    /**
     * Create an instance of {@link AddUserToProject }
     * 
     */
    public AddUserToProject createAddUserToProject() {
        return new AddUserToProject();
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
     * Create an instance of {@link AddAppointmentToProject }
     * 
     */
    public AddAppointmentToProject createAddAppointmentToProject() {
        return new AddAppointmentToProject();
    }

    /**
     * Create an instance of {@link ComparePhonebookResponse }
     * 
     */
    public ComparePhonebookResponse createComparePhonebookResponse() {
        return new ComparePhonebookResponse();
    }

    /**
     * Create an instance of {@link GetAppointmentsByProjectResponse }
     * 
     */
    public GetAppointmentsByProjectResponse createGetAppointmentsByProjectResponse() {
        return new GetAppointmentsByProjectResponse();
    }

    /**
     * Create an instance of {@link RemoveProjectDiscussionResponse }
     * 
     */
    public RemoveProjectDiscussionResponse createRemoveProjectDiscussionResponse() {
        return new RemoveProjectDiscussionResponse();
    }

    /**
     * Create an instance of {@link AddUserToProjectResponse }
     * 
     */
    public AddUserToProjectResponse createAddUserToProjectResponse() {
        return new AddUserToProjectResponse();
    }

    /**
     * Create an instance of {@link GetAppointmentsByProject }
     * 
     */
    public GetAppointmentsByProject createGetAppointmentsByProject() {
        return new GetAppointmentsByProject();
    }

    /**
     * Create an instance of {@link AddDiscussionToProject }
     * 
     */
    public AddDiscussionToProject createAddDiscussionToProject() {
        return new AddDiscussionToProject();
    }

    /**
     * Create an instance of {@link GetNotesByDiscussion }
     * 
     */
    public GetNotesByDiscussion createGetNotesByDiscussion() {
        return new GetNotesByDiscussion();
    }

    /**
     * Create an instance of {@link AddDiscussionToProjectResponse }
     * 
     */
    public AddDiscussionToProjectResponse createAddDiscussionToProjectResponse() {
        return new AddDiscussionToProjectResponse();
    }

    /**
     * Create an instance of {@link RemoveProjectMemberResponse }
     * 
     */
    public RemoveProjectMemberResponse createRemoveProjectMemberResponse() {
        return new RemoveProjectMemberResponse();
    }

    /**
     * Create an instance of {@link ComparePhonebook }
     * 
     */
    public ComparePhonebook createComparePhonebook() {
        return new ComparePhonebook();
    }

    /**
     * Create an instance of {@link GetDiscussionsByProjectResponse }
     * 
     */
    public GetDiscussionsByProjectResponse createGetDiscussionsByProjectResponse() {
        return new GetDiscussionsByProjectResponse();
    }

    /**
     * Create an instance of {@link AddNoteToDiscussionResponse }
     * 
     */
    public AddNoteToDiscussionResponse createAddNoteToDiscussionResponse() {
        return new AddNoteToDiscussionResponse();
    }

    /**
     * Create an instance of {@link GetProjectsByPhoneResponse }
     * 
     */
    public GetProjectsByPhoneResponse createGetProjectsByPhoneResponse() {
        return new GetProjectsByPhoneResponse();
    }

    /**
     * Create an instance of {@link GetNotesByDiscussionResponse }
     * 
     */
    public GetNotesByDiscussionResponse createGetNotesByDiscussionResponse() {
        return new GetNotesByDiscussionResponse();
    }

    /**
     * Create an instance of {@link GetDiscussionsByProject }
     * 
     */
    public GetDiscussionsByProject createGetDiscussionsByProject() {
        return new GetDiscussionsByProject();
    }

    /**
     * Create an instance of {@link UpdateProject }
     * 
     */
    public UpdateProject createUpdateProject() {
        return new UpdateProject();
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
     * Create an instance of {@link RemoveProjectMember }
     * 
     */
    public RemoveProjectMember createRemoveProjectMember() {
        return new RemoveProjectMember();
    }

    /**
     * Create an instance of {@link UsersResponse }
     * 
     */
    public UsersResponse createUsersResponse() {
        return new UsersResponse();
    }

    /**
     * Create an instance of {@link MilestoneTO }
     * 
     */
    public MilestoneTO createMilestoneTO() {
        return new MilestoneTO();
    }

    /**
     * Create an instance of {@link ProjectsResponse }
     * 
     */
    public ProjectsResponse createProjectsResponse() {
        return new ProjectsResponse();
    }

    /**
     * Create an instance of {@link DiscussionTO }
     * 
     */
    public DiscussionTO createDiscussionTO() {
        return new DiscussionTO();
    }

    /**
     * Create an instance of {@link AppointmentResponse }
     * 
     */
    public AppointmentResponse createAppointmentResponse() {
        return new AppointmentResponse();
    }

    /**
     * Create an instance of {@link NotesResponse }
     * 
     */
    public NotesResponse createNotesResponse() {
        return new NotesResponse();
    }

    /**
     * Create an instance of {@link DiscussionResponse }
     * 
     */
    public DiscussionResponse createDiscussionResponse() {
        return new DiscussionResponse();
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
     * Create an instance of {@link AppointmentTO }
     * 
     */
    public AppointmentTO createAppointmentTO() {
        return new AppointmentTO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectsByPhoneResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getProjectsByPhoneResponse")
    public JAXBElement<GetProjectsByPhoneResponse> createGetProjectsByPhoneResponse(GetProjectsByPhoneResponse value) {
        return new JAXBElement<GetProjectsByPhoneResponse>(_GetProjectsByPhoneResponse_QNAME, GetProjectsByPhoneResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComparePhonebook }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "comparePhonebook")
    public JAXBElement<ComparePhonebook> createComparePhonebook(ComparePhonebook value) {
        return new JAXBElement<ComparePhonebook>(_ComparePhonebook_QNAME, ComparePhonebook.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiscussionsByProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getDiscussionsByProjectResponse")
    public JAXBElement<GetDiscussionsByProjectResponse> createGetDiscussionsByProjectResponse(GetDiscussionsByProjectResponse value) {
        return new JAXBElement<GetDiscussionsByProjectResponse>(_GetDiscussionsByProjectResponse_QNAME, GetDiscussionsByProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNoteToDiscussionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addNoteToDiscussionResponse")
    public JAXBElement<AddNoteToDiscussionResponse> createAddNoteToDiscussionResponse(AddNoteToDiscussionResponse value) {
        return new JAXBElement<AddNoteToDiscussionResponse>(_AddNoteToDiscussionResponse_QNAME, AddNoteToDiscussionResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProjectsByPhone }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getProjectsByPhone")
    public JAXBElement<GetProjectsByPhone> createGetProjectsByPhone(GetProjectsByPhone value) {
        return new JAXBElement<GetProjectsByPhone>(_GetProjectsByPhone_QNAME, GetProjectsByPhone.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProjectMember }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "removeProjectMember")
    public JAXBElement<RemoveProjectMember> createRemoveProjectMember(RemoveProjectMember value) {
        return new JAXBElement<RemoveProjectMember>(_RemoveProjectMember_QNAME, RemoveProjectMember.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotesByDiscussionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getNotesByDiscussionResponse")
    public JAXBElement<GetNotesByDiscussionResponse> createGetNotesByDiscussionResponse(GetNotesByDiscussionResponse value) {
        return new JAXBElement<GetNotesByDiscussionResponse>(_GetNotesByDiscussionResponse_QNAME, GetNotesByDiscussionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiscussionsByProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getDiscussionsByProject")
    public JAXBElement<GetDiscussionsByProject> createGetDiscussionsByProject(GetDiscussionsByProject value) {
        return new JAXBElement<GetDiscussionsByProject>(_GetDiscussionsByProject_QNAME, GetDiscussionsByProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "updateProject")
    public JAXBElement<UpdateProject> createUpdateProject(UpdateProject value) {
        return new JAXBElement<UpdateProject>(_UpdateProject_QNAME, UpdateProject.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppointmentToProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addAppointmentToProject")
    public JAXBElement<AddAppointmentToProject> createAddAppointmentToProject(AddAppointmentToProject value) {
        return new JAXBElement<AddAppointmentToProject>(_AddAppointmentToProject_QNAME, AddAppointmentToProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserToProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addUserToProject")
    public JAXBElement<AddUserToProject> createAddUserToProject(AddUserToProject value) {
        return new JAXBElement<AddUserToProject>(_AddUserToProject_QNAME, AddUserToProject.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppointmentsByProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getAppointmentsByProjectResponse")
    public JAXBElement<GetAppointmentsByProjectResponse> createGetAppointmentsByProjectResponse(GetAppointmentsByProjectResponse value) {
        return new JAXBElement<GetAppointmentsByProjectResponse>(_GetAppointmentsByProjectResponse_QNAME, GetAppointmentsByProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ComparePhonebookResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "comparePhonebookResponse")
    public JAXBElement<ComparePhonebookResponse> createComparePhonebookResponse(ComparePhonebookResponse value) {
        return new JAXBElement<ComparePhonebookResponse>(_ComparePhonebookResponse_QNAME, ComparePhonebookResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddNoteToDiscussion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addNoteToDiscussion")
    public JAXBElement<AddNoteToDiscussion> createAddNoteToDiscussion(AddNoteToDiscussion value) {
        return new JAXBElement<AddNoteToDiscussion>(_AddNoteToDiscussion_QNAME, AddNoteToDiscussion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddAppointmentToProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addAppointmentToProjectResponse")
    public JAXBElement<AddAppointmentToProjectResponse> createAddAppointmentToProjectResponse(AddAppointmentToProjectResponse value) {
        return new JAXBElement<AddAppointmentToProjectResponse>(_AddAppointmentToProjectResponse_QNAME, AddAppointmentToProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProjectDiscussion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "removeProjectDiscussion")
    public JAXBElement<RemoveProjectDiscussion> createRemoveProjectDiscussion(RemoveProjectDiscussion value) {
        return new JAXBElement<RemoveProjectDiscussion>(_RemoveProjectDiscussion_QNAME, RemoveProjectDiscussion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDiscussionToProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addDiscussionToProject")
    public JAXBElement<AddDiscussionToProject> createAddDiscussionToProject(AddDiscussionToProject value) {
        return new JAXBElement<AddDiscussionToProject>(_AddDiscussionToProject_QNAME, AddDiscussionToProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetNotesByDiscussion }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getNotesByDiscussion")
    public JAXBElement<GetNotesByDiscussion> createGetNotesByDiscussion(GetNotesByDiscussion value) {
        return new JAXBElement<GetNotesByDiscussion>(_GetNotesByDiscussion_QNAME, GetNotesByDiscussion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProjectMemberResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "removeProjectMemberResponse")
    public JAXBElement<RemoveProjectMemberResponse> createRemoveProjectMemberResponse(RemoveProjectMemberResponse value) {
        return new JAXBElement<RemoveProjectMemberResponse>(_RemoveProjectMemberResponse_QNAME, RemoveProjectMemberResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddDiscussionToProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addDiscussionToProjectResponse")
    public JAXBElement<AddDiscussionToProjectResponse> createAddDiscussionToProjectResponse(AddDiscussionToProjectResponse value) {
        return new JAXBElement<AddDiscussionToProjectResponse>(_AddDiscussionToProjectResponse_QNAME, AddDiscussionToProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddUserToProjectResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "addUserToProjectResponse")
    public JAXBElement<AddUserToProjectResponse> createAddUserToProjectResponse(AddUserToProjectResponse value) {
        return new JAXBElement<AddUserToProjectResponse>(_AddUserToProjectResponse_QNAME, AddUserToProjectResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAppointmentsByProject }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "getAppointmentsByProject")
    public JAXBElement<GetAppointmentsByProject> createGetAppointmentsByProject(GetAppointmentsByProject value) {
        return new JAXBElement<GetAppointmentsByProject>(_GetAppointmentsByProject_QNAME, GetAppointmentsByProject.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveProjectDiscussionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "removeProjectDiscussionResponse")
    public JAXBElement<RemoveProjectDiscussionResponse> createRemoveProjectDiscussionResponse(RemoveProjectDiscussionResponse value) {
        return new JAXBElement<RemoveProjectDiscussionResponse>(_RemoveProjectDiscussionResponse_QNAME, RemoveProjectDiscussionResponse.class, null, value);
    }

}
