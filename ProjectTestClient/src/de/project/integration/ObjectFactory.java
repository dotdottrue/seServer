
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

    private final static QName _RegisterUser_QNAME = new QName("http://integration.project.de/", "registerUser");
    private final static QName _RegisterUserResponse_QNAME = new QName("http://integration.project.de/", "registerUserResponse");
    private final static QName _Login_QNAME = new QName("http://integration.project.de/", "login");
    private final static QName _Logout_QNAME = new QName("http://integration.project.de/", "logout");
    private final static QName _LoginResponse_QNAME = new QName("http://integration.project.de/", "loginResponse");
    private final static QName _LogoutResponse_QNAME = new QName("http://integration.project.de/", "logoutResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.project.integration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Logout }
     * 
     */
    public Logout createLogout() {
        return new Logout();
    }

    /**
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link LogoutResponse }
     * 
     */
    public LogoutResponse createLogoutResponse() {
        return new LogoutResponse();
    }

    /**
     * Create an instance of {@link RegisterUser }
     * 
     */
    public RegisterUser createRegisterUser() {
        return new RegisterUser();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link RegisterUserResponse }
     * 
     */
    public RegisterUserResponse createRegisterUserResponse() {
        return new RegisterUserResponse();
    }

    /**
     * Create an instance of {@link ProjectUserResponse }
     * 
     */
    public ProjectUserResponse createProjectUserResponse() {
        return new ProjectUserResponse();
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
     * Create an instance of {@link ProjectSessionTO }
     * 
     */
    public ProjectSessionTO createProjectSessionTO() {
        return new ProjectSessionTO();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "registerUser")
    public JAXBElement<RegisterUser> createRegisterUser(RegisterUser value) {
        return new JAXBElement<RegisterUser>(_RegisterUser_QNAME, RegisterUser.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "registerUserResponse")
    public JAXBElement<RegisterUserResponse> createRegisterUserResponse(RegisterUserResponse value) {
        return new JAXBElement<RegisterUserResponse>(_RegisterUserResponse_QNAME, RegisterUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Logout }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "logout")
    public JAXBElement<Logout> createLogout(Logout value) {
        return new JAXBElement<Logout>(_Logout_QNAME, Logout.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LogoutResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://integration.project.de/", name = "logoutResponse")
    public JAXBElement<LogoutResponse> createLogoutResponse(LogoutResponse value) {
        return new JAXBElement<LogoutResponse>(_LogoutResponse_QNAME, LogoutResponse.class, null, value);
    }

}
