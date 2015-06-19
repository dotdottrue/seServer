package de.project.integration;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.13
 * 2015-06-20T00:12:39.434+02:00
 * Generated source version: 2.7.13
 * 
 */
@WebService(targetNamespace = "http://integration.project.de/", name = "ProjectIntegration")
@XmlSeeAlso({ObjectFactory.class})
public interface ProjectIntegration {

    @WebMethod
    @RequestWrapper(localName = "createProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.CreateProject")
    @ResponseWrapper(localName = "createProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.CreateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse createProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @RequestWrapper(localName = "addAppointmentToProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddAppointmentToProject")
    @ResponseWrapper(localName = "addAppointmentToProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddAppointmentToProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse addAppointmentToProject(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        long arg3
    );

    @WebMethod
    @RequestWrapper(localName = "addUserToProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddUserToProject")
    @ResponseWrapper(localName = "addUserToProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddUserToProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse addUserToProject(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        long arg1
    );

    @WebMethod
    @RequestWrapper(localName = "addNoteToDiscussion", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddNoteToDiscussion")
    @ResponseWrapper(localName = "addNoteToDiscussionResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddNoteToDiscussionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse addNoteToDiscussion(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @RequestWrapper(localName = "comparePhonebook", targetNamespace = "http://integration.project.de/", className = "de.project.integration.ComparePhonebook")
    @ResponseWrapper(localName = "comparePhonebookResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.ComparePhonebookResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.UsersResponse comparePhonebook(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.util.List<java.lang.String> arg1
    );

    @WebMethod
    @RequestWrapper(localName = "removeProjectDiscussion", targetNamespace = "http://integration.project.de/", className = "de.project.integration.RemoveProjectDiscussion")
    @ResponseWrapper(localName = "removeProjectDiscussionResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.RemoveProjectDiscussionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse removeProjectDiscussion(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        long arg1
    );

    @WebMethod
    @RequestWrapper(localName = "addDiscussionToProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddDiscussionToProject")
    @ResponseWrapper(localName = "addDiscussionToProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.AddDiscussionToProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse addDiscussionToProject(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @RequestWrapper(localName = "getNotesByDiscussion", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetNotesByDiscussion")
    @ResponseWrapper(localName = "getNotesByDiscussionResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetNotesByDiscussionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.NotesResponse getNotesByDiscussion(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getProjectsByPhone", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetProjectsByPhone")
    @ResponseWrapper(localName = "getProjectsByPhoneResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetProjectsByPhoneResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ProjectsResponse getProjectsByPhone(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @RequestWrapper(localName = "removeProjectAppointment", targetNamespace = "http://integration.project.de/", className = "de.project.integration.RemoveProjectAppointment")
    @ResponseWrapper(localName = "removeProjectAppointmentResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.RemoveProjectAppointmentResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse removeProjectAppointment(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        long arg1
    );

    @WebMethod
    @RequestWrapper(localName = "removeProjectMember", targetNamespace = "http://integration.project.de/", className = "de.project.integration.RemoveProjectMember")
    @ResponseWrapper(localName = "removeProjectMemberResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.RemoveProjectMemberResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ReturncodeResponse removeProjectMember(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @RequestWrapper(localName = "getDiscussionsByProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetDiscussionsByProject")
    @ResponseWrapper(localName = "getDiscussionsByProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetDiscussionsByProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.DiscussionResponse getDiscussionsByProject(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0
    );

    @WebMethod
    @RequestWrapper(localName = "getAppointmentsByProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetAppointmentsByProject")
    @ResponseWrapper(localName = "getAppointmentsByProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.GetAppointmentsByProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.AppointmentResponse getAppointmentsByProject(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0
    );

    @WebMethod
    @RequestWrapper(localName = "updateProject", targetNamespace = "http://integration.project.de/", className = "de.project.integration.UpdateProject")
    @ResponseWrapper(localName = "updateProjectResponse", targetNamespace = "http://integration.project.de/", className = "de.project.integration.UpdateProjectResponse")
    @WebResult(name = "return", targetNamespace = "")
    public de.project.integration.ProjectResponse updateProject(
        @WebParam(name = "arg0", targetNamespace = "")
        long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.lang.String arg3
    );
}
