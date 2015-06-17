package de.project.integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;














import de.project.assembler.DiscussionDTOAssembler;
import de.project.assembler.NoteDTOAssembler;
import de.project.assembler.ProjectDTOAssembler;
import de.project.assembler.UserDTOAssembler;
import de.project.dao.local.ProjectDiscussionDAOLocal;
import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.MilestoneTO;
import de.project.dto.ReturncodeResponse;
import de.project.dto.discussion.DiscussionResponse;
import de.project.dto.discussion.DiscussionTO;
import de.project.dto.note.NoteTO;
import de.project.dto.note.NotesResponse;
import de.project.dto.project.ProjectResponse;
import de.project.dto.project.ProjectsResponse;
import de.project.dto.project.ProjectTO;
import de.project.dto.user.UserTO;
import de.project.dto.user.UsersResponse;
import de.project.entities.Discussion;
import de.project.entities.Milestone;
import de.project.entities.Note;
import de.project.entities.Project;
import de.project.entities.ProjectSession;
import de.project.entities.User;
import de.project.enumerations.ProjectStatus;
import de.project.enumerations.ReturnCode;
import de.project.exception.PermissionDeniedException;
import de.project.exception.ProjectNotExistException;
import de.project.exception.ProjectValidationException;

@WebService
@WebContext(contextRoot = "/project")
@Stateless
public class ProjectIntegration {
	
	@EJB(beanName = "ProjectProjectDAO", beanInterface = ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	@EJB(beanName = "ProjectUserDAO", beanInterface = ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	@EJB(beanName = "ProjectDiscussionDAO", beanInterface = ProjectDiscussionDAOLocal.class)
	private ProjectDiscussionDAOLocal discussionDAO;
	
	@EJB
	private ProjectDTOAssembler projectassembler;
	
	@EJB
	private DiscussionDTOAssembler discussionassembler;
	
	@EJB
	private NoteDTOAssembler noteassembler;
	
	@EJB
	private UserDTOAssembler userassembler;

	private static final Logger LOGGER = Logger.getLogger(ProjectIntegration.class);

	
	public ReturncodeResponse createProject(String phoneNumber, String projectName, String description /*, int sessionId*/ ) {
		//ReturncodeResponse response = new ReturncodeResponse(); 
		LOGGER.info(phoneNumber+" "+projectName);
		try{
			//ProjectSession session = userDAO.getSession(sessionId);
			Project newProject = new Project();
			
			//List<User> users = new ArrayList<User>();
			
			User owner = userDAO.findUserByNumber(phoneNumber);
			
			if(owner != null){
			
			List<User> members = new ArrayList<User>();
			List<Discussion> discussions = new ArrayList<Discussion>();
			
			members.add(owner);
			
			newProject.setOwner(owner);
			newProject.setDescription(description);
			newProject.setProjectName(projectName);
			newProject.setUpdatedOn(new Date());
			newProject.setMembers(members);
			newProject.setDiscussions(discussions);
			
			projectDAO.createProject(newProject);
			
			}
			
			
			
			
			/*List<UserTO> usersTO = new ArrayList<UserTO>();
			
			for(UserTO userTO : usersTO) {
				User u = new User();
				u.setPhoneNumber(userTO.getPhoneNumber());
				u.setFirstName(userTO.getFirstName());
				u.setLastName(userTO.getLastName());
				users.add(u);
			}*/
			
			
			//List<Milestone> milestones = new ArrayList<Milestone>();
			//List<MilestoneTO> milestonesTO = new ArrayList<MilestoneTO>();
			
			/*for(MilestoneTO milestoneTO : milestonesTO) {
				Milestone m = new Milestone();
				m.setId(milestoneTO.getId());
				m.setMilestoneName(milestoneTO.getMilestoneName());
				m.setStatus(milestoneTO.getStatus());			
			}
			
			newProject.setMembers(users);
			newProject.setOwner(session.getUser());
			newProject.setMilestones(milestones);
			newProject.setProjectName(projectName);
			newProject.setProjectStatus(ProjectStatus.INTIME);
			newProject.setUpdatedOn(new Date());
			
			if(newProject.projectValidation()) {
				projectDAO.createProject(newProject);
				LOGGER.info("Project wurde erfolgreich angelegt");
			}else {
				LOGGER.info("Project wurde nicht angelegt da die Pflichtfelder nicht gef�llt waren.");
				throw new ProjectValidationException(ReturnCode.ERROR, "Es wurden nicht alle Pflichfelder gef�llt");
			}
			*/
			}catch(Exception ex) {
				//response.setReturnCode(ex.getErrorCode());
				//response.setMessage(ex.getMessage());
			}
		return new ReturncodeResponse();
	}
	
	public ProjectsResponse getProjectsByPhone(String phonenumber){
		
		ProjectsResponse response = new ProjectsResponse();
	
		User user = userDAO.findUserByNumber(phonenumber);
		List<Project> projects = user.getProjects();
		
		if(!projects.isEmpty()) LOGGER.info(projects.get(0).getProjectName());
		else LOGGER.info("is empty");
				//projectDAO.findProjects(user);
		List<ProjectTO> projectsTO = new ArrayList<ProjectTO>();
		
		for(Project p : projects){
			projectsTO.add(projectassembler.makeDTO(p));
		}
				
		response.setProjects(projectsTO);
		response.setPhonenumber(phonenumber);
		if(projectsTO.isEmpty()) {
			LOGGER.info("Eine Liste der Projekte f�r den Benutzer mit der Telefonnummer: " + user.getPhoneNumber()+ "konnte nicht erzeugt werden.");
			return new ProjectsResponse();
		}else{
			LOGGER.info("Eine Liste der Projekte f�r den Benutzer mit der Telefonnummer: " + user.getPhoneNumber()+ "wurde erzeugt.");
		}
		
		return response;		
	}
	
	public DiscussionResponse getDiscussionsByProject(long projectId){
		
		DiscussionResponse response = new DiscussionResponse();
		Project project = projectDAO.getProject(projectId);
		List<Discussion> discussions = project.getDiscussions();
		List<DiscussionTO> discussionsTO = new ArrayList<DiscussionTO>();
		
		for(Discussion disc : discussions){
			discussionsTO.add(discussionassembler.makeDTO(disc));
		}
		
		response.setDiscussions(discussionsTO);
		
		return response;
	}
	
	public ReturncodeResponse addDiscussionToProject(long projectId, String topic){
		
		Project project = projectDAO.findProjectById(projectId);
		
		Discussion discussion = new Discussion();
		discussion.setNotes(new ArrayList<Note>());
		discussion.setCreatedAt(new Date());
		discussion.setTopic(topic);
		project.getDiscussions().add(discussion);
		
		projectDAO.updateProject(project);
			
		return new ReturncodeResponse();
	}
	
	
	public ReturncodeResponse addNoteToDiscussion(long discussionId, String note, String phonenumber){
		Discussion discussion = discussionDAO.getDisccusionById(discussionId);
		Note newNote = new Note();
		newNote.setNote(note);
		newNote.setCreatedAt(new Date());
		newNote.setUser(phonenumber);
		discussion.getNotes().add(newNote);
		discussionDAO.updateDiscussion(discussion);
				
		return new ReturncodeResponse();
	}
	
	
	public NotesResponse getNotesByDiscussion(long discussionId){
		NotesResponse response = new NotesResponse();
		Discussion discusssion = discussionDAO.getDisccusionById(discussionId);
		List<Note> notes = discusssion.getNotes();
		List<NoteTO> notesTO = new ArrayList<NoteTO>();
		
		for(Note n : notes){
			notesTO.add(noteassembler.makeDTO(n));
			
		}
		response.setNotes(notesTO);
		
		return response;
	}
	
	public UsersResponse comparePhonebook (String ...params){
		
		List<User> usersServer = userDAO.findAllUsers();
		List<User> comparedUsers = new ArrayList<User>();
		
		for(int i = 0; i < params.length; i++){
			
			for(User u : usersServer){
				if(u.getPhoneNumber().equals(params[i])){
					comparedUsers.add(u);
					break;
				}
			}
		}
		List<UserTO> comparedTO = new ArrayList<UserTO>();
		for(User u : comparedUsers){
			comparedTO.add(userassembler.makeDTO(u));
		}
		UsersResponse response = new UsersResponse();
		response.setUsers(comparedTO);
		
		return response;
		
	}
	
	
	
	public ProjectResponse updateProject(long id, String projectName, String projectDescription, int sessionId) {
		
		ProjectResponse response = new ProjectResponse();
		
		try {
			Project project = projectDAO.findProjectById(id);
			
			if(project == null){
				LOGGER.info("Es wurde kein Project mit der ID: " + id + "gefunden.");
				throw new ProjectNotExistException("Es gibt kein Project mit der angefragten ID.");
			}
			
			ProjectSession session = userDAO.getSession(sessionId);
			ArrayList<User> members = new ArrayList<User>();
			if((project.getOwner().equals(session.getUser())) || members.contains(session.getUser())){
				project.setProjectName(projectName);
				project.setDescription(projectDescription);
				projectDAO.updateProject(project);
				
				LOGGER.info("Project mit der id " + project.getId() + "wurde aktualisiert.");
			}else{
				LOGGER.info("Zugriff f�r den Benutzer verweigert.");
				throw new PermissionDeniedException("Zugriff verweigert!");
			}
			
			
		}catch(ProjectNotExistException | PermissionDeniedException ex ){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());	
		}
		
		return response;		
	}
	
}
