package de.project.integration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.jboss.logging.Logger;
import org.jboss.ws.api.annotation.WebContext;

import de.project.assembler.AppointmentDTOAssembler;
import de.project.assembler.DiscussionDTOAssembler;
import de.project.assembler.NoteDTOAssembler;
import de.project.assembler.ProjectDTOAssembler;
import de.project.assembler.UserDTOAssembler;
import de.project.dao.local.ProjectAppointmentDAOLocal;
import de.project.dao.local.ProjectDiscussionDAOLocal;
import de.project.dao.local.ProjectProjectDAOLocal;
import de.project.dao.local.ProjectUserDAOLocal;
import de.project.dto.ReturncodeResponse;
import de.project.dto.appointment.AppointmentResponse;
import de.project.dto.appointment.AppointmentTO;
import de.project.dto.discussion.DiscussionResponse;
import de.project.dto.discussion.DiscussionTO;
import de.project.dto.note.NoteTO;
import de.project.dto.note.NotesResponse;
import de.project.dto.project.ProjectResponse;
import de.project.dto.project.ProjectsResponse;
import de.project.dto.project.ProjectTO;
import de.project.dto.user.UserTO;
import de.project.dto.user.UsersResponse;
import de.project.entities.Appointment;
import de.project.entities.Discussion;
import de.project.entities.Note;
import de.project.entities.Project;
import de.project.entities.User;
import de.project.enumerations.ProjectStatus;
import de.project.enumerations.ReturnCode;
import de.project.exception.CompareUsersNotExistException;
import de.project.exception.DiscussionNotExistsException;
import de.project.exception.NotesNotExistException;
import de.project.exception.ProjectException;
import de.project.exception.ProjectNotExistException;
import de.project.exception.ProjectValidationException;
/**
 * 
 * @author Tobias Kappert | Eduard Schartner
 *
 *Diese Klasse haelt die Schnittstellen/Methoden fuer die Projektsperifischen UseCases bereit.
 *
 */
@WebService
@WebContext(contextRoot = "/project")
@Stateless
public class ProjectIntegration {
	
	/**
	 * Referenz auf die EJB wird via Dependency Injection erzeugt. Die EJB ist fï¿½r Datenbankabfragen gedacht.
	 */
	@EJB(beanName = "ProjectProjectDAO", beanInterface = ProjectProjectDAOLocal.class)
	private ProjectProjectDAOLocal projectDAO;
	
	/**
	 * Referenz auf die EJB wird via Dependency Injection erzeugt. Die EJB ist fuer Datenbankabfragen gedacht.
	 */
	@EJB(beanName = "ProjectUserDAO", beanInterface = ProjectUserDAOLocal.class)
	private ProjectUserDAOLocal userDAO;
	
	/**
	 * Referenz auf die EJB wird via Dependency Injection erzeugt. Die EJB ist fuer Datenbankabfragen gedacht.
	 */
	@EJB(beanName = "ProjectDiscussionDAO", beanInterface = ProjectDiscussionDAOLocal.class)
	private ProjectDiscussionDAOLocal discussionDAO;
	
	/**
	 * Referenz auf die EJB wird via Dependency Injection erzeugt. Die EJB ist fuer Datenbankabfragen gedacht.
	 */	
	@EJB(beanName = "ProjectAppointmentDAO", beanInterface = ProjectAppointmentDAOLocal.class)
	private ProjectAppointmentDAOLocal appointmentDAO;
	/**
	 * DataTransferObject wird via EJB erzeugt.
	 */
	@EJB
	private ProjectDTOAssembler projectassembler;
	
	/**
	 * DataTransferObject wird via EJB erzeugt.
	 */
	@EJB
	private DiscussionDTOAssembler discussionassembler;
	
	/**
	 * DataTransferObject wird via EJB erzeugt.
	 */
	@EJB
	private NoteDTOAssembler noteassembler;
	
	@EJB
	private UserDTOAssembler userassembler;
	
	@EJB
	private AppointmentDTOAssembler appointmentassembler;

	private static final Logger LOGGER = Logger.getLogger(ProjectIntegration.class);

	/**
	 * Die Methode erzeugt ein Projekt. Falls es den Benutzer nicht gibt wird eine Exception geschmissen.
	 * @param phoneNumber = Telefonnummer des Appanwenders.
	 * @param projectName = Name des zu erstellenden Projektes.
	 * @param description = Beschreibung des Projektes.
	 * @return = Rueckgabe des StatusCodes.
	 */
	public ReturncodeResponse createProject(String phoneNumber, String projectName, String description /*, int sessionId*/ ) {
		ReturncodeResponse response = new ReturncodeResponse(); 
		LOGGER.info(phoneNumber+" "+projectName);
		try{
			Project newProject = new Project();
			
			User owner = userDAO.findUserByNumber(phoneNumber);
			
			if(owner != null){
			
				List<User> members = new ArrayList<User>();
				List<Discussion> discussions = new ArrayList<Discussion>();
				List<Appointment> appointments = new ArrayList<Appointment>();
				
				members.add(owner);
				
				newProject.setOwner(owner);
				newProject.setDescription(description);
				newProject.setProjectName(projectName);
				newProject.setUpdatedOn(new Date());
				newProject.setMembers(members);
				newProject.setDiscussions(discussions);
				newProject.setAppointments(appointments);
				
				projectDAO.createProject(newProject);
				
			}else {
				LOGGER.info("Project wurde nicht angelegt da die Pflichtfelder nicht gefï¿½llt waren.");
				throw new ProjectValidationException(ReturnCode.ERROR, "Es wurden nicht alle Pflichfelder gefï¿½llt");
			}
			
			}catch(ProjectValidationException ex) {
				response.setReturnCode(ex.getErrorCode());
				response.setMessage(ex.getMessage());
			}
		return response;
	}
	
	
	/**
	 * Diese Methode erzegt eine Liste aller Projekte die einem Benutzer zugeordnet sind.
	 * @param phonenumber = Uebergabeparameter ist die Telefonnummer des App-Anwenders.
	 * @return = Es wird eine Liste der Projekte an den AppAnwender zurueckgegeben.
	 */
	public ProjectsResponse getProjectsByPhone(String phonenumber){	
		ProjectsResponse response = new ProjectsResponse();

		try{
			User user = userDAO.findUserByNumber(phonenumber);
			if(user == null) {
				LOGGER.info("Eine Liste der Projekte fï¿½r den Benutzer mit der Telefonnummer: " + phonenumber + " konnte nicht erzeugt werden.");
				throw new ProjectNotExistException("Es existieren keine Projekte fï¿½r den benutzer mit der Telefonnummer: " + phonenumber);		
			}else{
				List<Project> projects = user.getProjects();
				
				if(!projects.isEmpty() || user == null){
					LOGGER.info(projects.get(0).getProjectName());
				}else{
					LOGGER.info("Projektliste ist leer!");
				}
				List<ProjectTO> projectsTO = new ArrayList<ProjectTO>();
				
				for(Project p : projects){
					projectsTO.add(projectassembler.makeDTO(p));
				}
						
				response.setProjects(projectsTO);
				response.setPhonenumber(phonenumber);
				
				LOGGER.info("Eine Liste der Projekte fï¿½r den Benutzer mit der Telefonnummer: " + user.getPhoneNumber()+ " wurde erzeugt.");
			}
		}catch(ProjectNotExistException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
		return response;
	}
	
	/**
	 * Diese Methode erzeugt bei Anfrage eine Liste aller Diskussionen eines Objektes.
	 * @param projectId = Dort wird eine Projektnummer/Id von App-Anwender uebergeben
	 * @return = Die Rueckgabe enthaelt eine Liste von Diskussionen im Projekt.
	 */
	public DiscussionResponse getDiscussionsByProject(long projectId){
		DiscussionResponse response = new DiscussionResponse();
		try{
			Project project = projectDAO.findProjectById(projectId);
			if(project != null){
				List<Discussion> discussions = project.getDiscussions();
				List<DiscussionTO> discussionsTO = new ArrayList<DiscussionTO>();
				
				for(Discussion disc : discussions){
					discussionsTO.add(discussionassembler.makeDTO(disc));
				}	
				response.setDiscussions(discussionsTO);
			}else{
				LOGGER.info("Es gibt keine Diskussionen fï¿½r das Projekt.");
				throw new DiscussionNotExistsException("Es existiert keine Diskussion fï¿½r das angefragte Projekt.");
			}
		}catch(DiscussionNotExistsException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}	
		return response;
	}
	
	/**
	 * Diese Schnittstelle/Methode fuegt eine Diskussion zu einem Projekt hinzu.
	 * @param projectId = Dort wird eine Projektnummer/Id von App-Anwender uebergeben
	 * @param topic = Beinhaltet die Ueberschrift einer Diskussion.
	 * @return = Beim erfolgreichen Anlegen wird ein OK-Code gesendet ansonstne ein Error-Code.
	 */
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
				
				LOGGER.info("Eine Diskussion mit der ID " + discussion.getId() + " wurde dem Project mit der ID " + project.getId() + "hinzugefuegt.");
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
	
	/**
	 * Methode/Schnittstelle zum entfernen einer Diskussion aus einem Projekt
	 * @param projectId = Parameter zum bestimmen zu welchem Projekt die Diskussiong gehoert.
	 * @param discussionId = Die ID der jeweiligen Diskussion.
	 * @return = Es wird bei Erfolg der ReturnCode OK bei misserfolg der ReturnCode Error zurueckgegeben.
	 */
	public ReturncodeResponse removeProjectDiscussion(long projectId, long discussionId){
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			Project project = projectDAO.findProjectById(projectId);
			Discussion discussion = discussionDAO.getDiscussionById(discussionId);
			if(project == null || discussion == null){
				LOGGER.info("Es gibt kein Projekt mit der Id: " + projectId);
				throw new ProjectNotExistException("Es gibt kein Projekt mit der ID: " + projectId);
			} 
			List<Discussion> discussions = project.getDiscussions();
			discussions.remove(discussion);
			projectDAO.updateProject(project);
		} catch (ProjectNotExistException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Diese Schnittstelle/Methode erstellt eine Notiz bei der jeweiligen Diskussion die ausgewaehlt wurde bzw geoeffnet ist.
	 * @param discussionId = Diskussionsnummer um die richtige Diskussion anzusprechen.
	 * @param note = Die Notiz die geschrieben wurde.
	 * @param phonenumber = Telefonnummerdes Benutzers.
	 * @return = Bei erfolgreicher Erstellung wird ein OK-Code beim Fehler ein Error-Code gesendet.
	 */
	public ReturncodeResponse addNoteToDiscussion(long discussionId, String note, String phonenumber){
		ReturncodeResponse response = new ReturncodeResponse();
		try{
			Discussion discussion = discussionDAO.getDiscussionById(discussionId);
			
			if(discussion == null){
				LOGGER.info("Der Diskussion mit der ID " + discussionId + " wurde keine Notiz hinterlegt.");
				throw new DiscussionNotExistsException("Es konnte der Diskussion keine Nachricht hinzugefï¿½gt werden oder die Diskussion existiert nicht.");
			}

			Note newNote = new Note();
			newNote.setNote(note);
			newNote.setCreatedAt(new Date());
			newNote.setUser(phonenumber);
			
			discussion.getNotes().add(newNote);
			
			LOGGER.info("Es wurde der Diskussion mit der ID " + discussion.getId() + "eine Notiz hinterlegt.");
			discussionDAO.updateDiscussion(discussion);
		}catch(ProjectException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
				
		return response;
	}
	
	/**
	 * Mit dieser Methode werden die Beitraege in einer Diskussion ausder Datenbank geholt und dem Client uebergeben.
	 * @param discussionId = Diskussionsnummer um die richtige Diskussion anzusprechen.
	 * @return = Als Rueckgabe wird ein ReturnCorde geschickt und eine Liste an Notizen/Beitraegen. Im Fehlerfall eine Nachricht und ein Fehlercode.
	 */
	public NotesResponse getNotesByDiscussion(long discussionId){
		NotesResponse response = new NotesResponse();
		try{
			Discussion discussion = discussionDAO.getDiscussionById(discussionId);
			
			if(discussion == null){
				LOGGER.info("Es konnten keine Notizen von der Diskussion abgerufen werden oder es existiert keine Diskussion.");
				throw new NotesNotExistException("Es konnte keine Notiz von einer nicht Existenten Diskussion abgerufen werden.");
			}
			
			List<Note> notes = discussion.getNotes();
			List<NoteTO> notesTO = new ArrayList<NoteTO>();
			
			for(Note n : notes){
				notesTO.add(noteassembler.makeDTO(n));	
			}
			
			response.setNotes(notesTO);
			LOGGER.info("Es wurde erfolgreich Notizen aus der Diskussion mit der ID: " + discussionId + " ausgelesen.");
		}catch(NotesNotExistException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
		}
		return response;
	}
	
	/**
	 * Diese Methode/Schnitttelle vergleicht die Kontakte des Handybenutzers mit den Kontakten in der Datenbank.
	 * @param params = der Parameter Params enthaelt ein String Array welches eine dynamische Laenge von String  parametern fassen kann.
	 * @return = Alle Kontakte aus dem Telefonbuch welche auch diese App benutzen.
	 */
	public UsersResponse comparePhonebook (long projectId, String ...params){
		UsersResponse response = new UsersResponse();
		try {
			Project project = projectDAO.findProjectById(projectId);
			if(params == null || project == null){
				LOGGER.info("Es wurden keine Kontakte/Parameter ï¿½bergeben! Oder die ï¿½bergabe war Fehlerhaft!");
				throw new CompareUsersNotExistException("Es gab keine Benutzer zu vergleichen!");
			}
			List<User> usersServer = userDAO.findAllUsers();
			List<User> comparedUsers = new ArrayList<User>();
			
			for(int i = 0; i < params.length; i++){
				for(User u : usersServer){
					LOGGER.info(params[i]+"("+params[i].length()+") = "+u.getPhoneNumber()+"("+u.getPhoneNumber().length()+")");
					if(u.getPhoneNumber().equals(params[i]) && !project.getMembers().contains(u)){
						comparedUsers.add(u);
						break;
					}
				}
			} 
			
			List<UserTO> comparedTO = new ArrayList<UserTO>();
			for(User u : comparedUsers){
				comparedTO.add(userassembler.makeDTO(u));
			}
			
			response.setUsers(comparedTO);
		} catch (CompareUsersNotExistException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Diese Schnittstelle erlaubt das hinzufuegen eines Benutzers/Users zu dem Projekt.
	 * @param phoneNumber = Uebergabeparameter Telefonnummer fï¿½r den zu speichernden Benutzer.
	 * @param projectId = Uebergabe parameter ProjektId zur Bestimmung des Projektes.
	 * @return = Gibt einen OK-Code bei erfolgreichem Anlegen zurueck und einen Error-Code falls was nicht klappt.
	 */
	public ReturncodeResponse addUserToProject(String phoneNumber, long projectId){
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			Project project = projectDAO.findProjectById(projectId);
			if(project == null){
				LOGGER.info("Es gibt kein Projekt mit der Id: " + projectId);
				throw new ProjectNotExistException("Es gibt kein Projekt mit der ID: " + projectId);
			} 
			
			User user = userDAO.findUserByNumber(phoneNumber);
			List<User> members = project.getMembers();
			members.add(user);
			projectDAO.updateProject(project);
		}catch (ProjectNotExistException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Diese Methode/Schnittstelle fuegt einen Termin bei einem Projekt hinzu.
	 * @param projectId = Indentifizierung zu welchem Projekt der Termin hinzugefuegt werden soll.
	 * @param topic = Bezeichnung des Termins.
	 * @param description = Beschreibung des Termins
	 * @param date = Datum des Termins.
	 * @return = Rueckgabe bei Erfolg OK-Code bei Fehler ERROR-Code.
	 */
	public ReturncodeResponse addAppointmentToProject(long projectId, String topic, String description, long date){
		ReturncodeResponse response = new ReturncodeResponse();
		try {	
			Project project = projectDAO.findProjectById(projectId);
			if(project == null){
				LOGGER.info("Es gibt kein Projekt mit der Id: " + projectId);
				throw new ProjectNotExistException("Es gibt kein Projekt mit der ID: " + projectId);
			} 
			List<Appointment> appointments = project.getAppointments();
			Appointment appointment = new Appointment();
			appointment.setTopic(topic);
			appointment.setDescription(description);
			Date newdate = new Date();
			newdate.setTime(date);
			appointment.setAppointmentDate(newdate);
			appointments.add(appointment);
			projectDAO.updateProject(project);
		
		}catch (ProjectNotExistException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Abrufen des Termins im jeweiligen Projekt.
	 * @param projectId = Aufruf eines Projektes wo der Termin enthalten ist.
	 * @return = Uebergabe der Termine.
	 */
	public AppointmentResponse getAppointmentsByProject(long projectId){	
		AppointmentResponse response = new AppointmentResponse();
		try {
			Project project = projectDAO.findProjectById(projectId);
			if(project == null){
				LOGGER.info("Es gibt kein Projekt mit der Id: " + projectId);
				throw new ProjectNotExistException("Es gibt kein Projekt mit der ID: " + projectId);
			} 
			List<Appointment> appointments = project.getAppointments();
			List<AppointmentTO> appointmentsTO = new ArrayList<AppointmentTO>();
			
			for(Appointment a : appointments){
				appointmentsTO.add(appointmentassembler.makeDTO(a));
			}
			response.setAppointments(appointmentsTO);
		
		}catch (ProjectNotExistException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Diese Methode entfernt einen Termin/Meilenstein aus dem Projekt.
	 * @param projectId = †bergabeparameter welcher das Projekt identifiziert.
	 * @param appointmentId = †bergabeparameter welcher das Termin Objekt identifiziert.
	 * @return = Ein Statuscode welche entweder OK oder ERROR beinhaltet.
	 */
	public ReturncodeResponse removeProjectAppointment(long projectId, long appointmentId){
		ReturncodeResponse response = new ReturncodeResponse();
		try{
			Project project = projectDAO.findProjectById(projectId);
			Appointment appointment = appointmentDAO.findAppointmentById(appointmentId);
			if(project == null || appointment == null){
				LOGGER.info("Das Projekt oder den Termin gibt es nicht");
				throw new ProjectNotExistException("Projekt oder Termin nicht vorhanden");
			}
			List<Appointment> appointments = project.getAppointments();
			appointments.remove(appointment);
			projectDAO.updateProject(project);
			
		}catch(ProjectNotExistException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();	
		}
		
		return response;
	}
	
	/**
	 * Entfernen eines Projektmitglieds
	 * @param projectId = Parameter zur Identifizierung des Projektes.
	 * @param phoneNumber = Telefonnummer zur Identifizierung des Projektmitglieds.
	 * @return = Rueckgabe eines Statuscodes.
	 */
	public ReturncodeResponse removeProjectMember(long projectId, String phoneNumber) {
		ReturncodeResponse response = new ReturncodeResponse();
		try {
			Project project = projectDAO.findProjectById(projectId);
			if(project == null){
				LOGGER.info("Es gibt kein Projekt mit der Id: " + projectId);
				throw new ProjectNotExistException("Es gibt kein Projekt mit der ID: " + projectId);
			} 
			User user = userDAO.findUserByNumber(phoneNumber);
			List<User> members = project.getMembers();
			members.remove(user);
			
			projectDAO.updateProject(project);
		}catch (ProjectNotExistException ex) {
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());
			ex.printStackTrace();
		}
		return response;
	}
	
	/**
	 * Diese Methode/Schnittstelle fŸhrt ein Projektupdate vor.
	 * @param id = Parameter welcher das Projekt identifiziert.
	 * @param projectName = Einen evtl. neuen Projektnamen der Aktualisiert wird.
	 * @param description = Eine Neue Projektdeskripion die aktualisiert werden wŸrde.
	 * @param projectStatus = ein aktualisierter Projektstatus.
	 * @return = Rueckgabe eines Statuscodes
	 */
	public ProjectResponse updateProject(long id, String projectName, String description, String projectStatus) {	
		ProjectResponse response = new ProjectResponse();
		try {
			Project project = projectDAO.findProjectById(id);
			
			if(project == null){
				LOGGER.info("Es wurde kein Project mit der ID: " + id + "gefunden.");
				throw new ProjectNotExistException("Es gibt kein Project mit der angefragten ID.");
			}			
				project.setDescription(description);
				project.setProjectName(projectName);
				project.setProjectStatus(ProjectStatus.valueOf(projectStatus));
				projectDAO.updateProject(project);
				
				LOGGER.info("Project mit der id " + project.getId() + "wurde aktualisiert.");
		}catch(ProjectNotExistException ex){
			response.setReturnCode(ex.getErrorCode());
			response.setMessage(ex.getMessage());	
		}		
		return response;		
	}
	
}
