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
import de.project.exception.DiscussionNotExistsException;
import de.project.exception.NotesNotExistException;
import de.project.exception.PermissionDeniedException;
import de.project.exception.ProjectException;
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
		ReturncodeResponse response = new ReturncodeResponse(); 
		LOGGER.info(phoneNumber+" "+projectName);
		try{
			//ProjectSession session = userDAO.getSession(sessionId);
			Project newProject = new Project();
			
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
				LOGGER.info("Project wurde erfolgreich angelegt");*/
			}else {
				LOGGER.info("Project wurde nicht angelegt da die Pflichtfelder nicht gef�llt waren.");
				throw new ProjectValidationException(ReturnCode.ERROR, "Es wurden nicht alle Pflichfelder gef�llt");
			}
			
			}catch(ProjectValidationException ex) {
				response.setReturnCode(ex.getErrorCode());
				response.setMessage(ex.getMessage());
			}
		return response;
	}
	
	public ProjectsResponse getProjectsByPhone(String phonenumber){	
		ProjectsResponse response = new ProjectsResponse();

		try{
			User user = userDAO.findUserByNumber(phonenumber);
			List<Project> projects = user.getProjects();
			
			if(!projects.isEmpty()){
				LOGGER.info(projects.get(0).getProjectName());
			}else{
				LOGGER.info("List projects ist leer!");
			}
			//projectDAO.findProjects(user);
			List<ProjectTO> projectsTO = new ArrayList<ProjectTO>();
			
			for(Project p : projects){
				projectsTO.add(projectassembler.makeDTO(p));
			}
					
			response.setProjects(projectsTO);
			response.setPhonenumber(phonenumber);
			
			if(projectsTO.isEmpty() || projectsTO == null) {
				LOGGER.info("Eine Liste der Projekte f�r den Benutzer mit der Telefonnummer: " + user.getPhoneNumber()+ "konnte nicht erzeugt werden.");
				throw new ProjectNotExistException("Es existieren keine Projekte f�r den benutzer mit der Telefonnummer: " + phonenumber);
			}else{
				LOGGER.info("Eine Liste der Projekte f�r den Benutzer mit der Telefonnummer: " + user.getPhoneNumber()+ "wurde erzeugt.");
			}
		}catch(ProjectNotExistException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
		return response;
	}
	
	public DiscussionResponse getDiscussionsByProject(long projectId){
		DiscussionResponse response = new DiscussionResponse();
		try{
			Project project = projectDAO.getProject(projectId);
			if(!project.getDiscussions().isEmpty() && project != null){
				List<Discussion> discussions = project.getDiscussions();
				List<DiscussionTO> discussionsTO = new ArrayList<DiscussionTO>();
				
				for(Discussion disc : discussions){
					discussionsTO.add(discussionassembler.makeDTO(disc));
				}	
				response.setDiscussions(discussionsTO);
			}else{
				LOGGER.info("Es gibt keine Diskussionen f�r das Projekt.");
				throw new DiscussionNotExistsException("Es existiert keine Diskussion f�r das angefragte Projekt.");
			}
		}catch(ProjectException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}	
		return response;
	}
	
	public ReturncodeResponse addDiscussionToProject(long projectId, String topic){
		ReturncodeResponse response = new ReturncodeResponse();
		try{
			Project project = projectDAO.findProjectById(projectId);
			if(project != null){
				Discussion discussion = new Discussion();
				discussion.setNotes(new ArrayList<Note>());
				discussion.setCreatedAt(new Date());
				discussion.setTopic(topic);
				project.getDiscussions().add(discussion);
				
				LOGGER.info("Eine Diskussion mit der ID " + discussion.getId() + "wurde dem Project mit der ID " + project.getId() + "hinzugef�gt.");
				projectDAO.updateProject(project);
			}else{
				LOGGER.info("Project mit der ID:" + projectId + "existiert nicht.");
				throw new ProjectNotExistException("Die Dikussion konnte nicht erzeugt werden!");
			}				
		}catch(ProjectException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}		
		return response;
	}	
	
	public ReturncodeResponse addNoteToDiscussion(long discussionId, String note, String phonenumber){
		ReturncodeResponse response = new ReturncodeResponse();
		try{
			Discussion discussion = discussionDAO.getDiscussionById(discussionId);
			Note newNote = new Note();
			newNote.setNote(note);
			newNote.setCreatedAt(new Date());
			newNote.setUser(phonenumber);
			
			List<Note> noteList = discussion.getNotes();
			int noteListLength = noteList.size();
			
			discussion.getNotes().add(newNote);
			
			if(discussion.getNotes().isEmpty() || noteListLength == discussion.getNotes().size()){
				LOGGER.info("Der Diskussion mit der ID " + discussion.getId() + "wurde keine Notiz hinterlegt.");
				throw new DiscussionNotExistsException("Es konnte der Diskussion keine Nachricht hinzugef�gt werden oder die Diskussion existiert nicht.");
			}
			LOGGER.info("Es wurde der Diskussion mit der ID " + discussion.getId() + "eine Notiz hinterlegt.");
			discussionDAO.updateDiscussion(discussion);
		}catch(ProjectException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
				
		return response;
	}
		
	public NotesResponse getNotesByDiscussion(long discussionId){
		NotesResponse response = new NotesResponse();
		try{
			Discussion discussion = discussionDAO.getDiscussionById(discussionId);
			List<Note> notes = discussion.getNotes();
			List<NoteTO> notesTO = new ArrayList<NoteTO>();
			
			for(Note n : notes){
				notesTO.add(noteassembler.makeDTO(n));	
			}
			response.setNotes(notesTO);
			
			if(notesTO.isEmpty()){
				LOGGER.info("Es konnten keine Notizen von der Diskussion abgerufen werden oder es existiert keine Notiz.");
				throw new NotesNotExistException("");
			}
			LOGGER.info("Es wurde erfolgreich Notizen aus der Diskussion mit der ID: " + discussionId + "ausgelesen.");
		}catch(ProjectException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
		
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
