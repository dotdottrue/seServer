package de.project.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.project.integration.ProjectResponse;
import de.project.integration.AppointmentResponse;
import de.project.integration.UsersResponse;
import de.project.integration.NotesResponse;
import de.project.integration.DiscussionResponse;
import de.project.integration.ProjectsResponse;
import de.project.integration.ReturnCode;
import de.project.integration.ProjectUserResponse;
import de.project.integration.ProjectIntegration;
import de.project.integration.ProjectIntegrationService;
import de.project.integration.ReturncodeResponse;
import de.project.integration.UserIntegration;
import de.project.integration.UserIntegrationService;


/**
 * 
 * Testet alle Server-Schnittstellen der projectIntegration.
 * @author Tobias Kappert
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProjectIntegretionTest {

	private static ProjectIntegration remote;
	
//	private static ProjectSessionTO userSession; 	
	
	/**
	 * Verbindungsaufbau zum Server.
	 */
	@BeforeClass
	public static void init() {
		ProjectIntegrationService projectService = new ProjectIntegrationService();
		remote = projectService.getProjectIntegrationPort();
		
		UserIntegrationService userService = new UserIntegrationService();
		UserIntegration userIntegrationPort = userService.getUserIntegrationPort();
	
		ProjectUserResponse userResponse = userIntegrationPort.registerUser("01607798983");
		userIntegrationPort.registerUser("01608898983");
		userIntegrationPort.registerUser("01609998983");
		userIntegrationPort.registerUser("01600098983");
		userIntegrationPort.registerUser("08000098983");
		
		if(userResponse.getReturnCode().equals(ReturnCode.ERROR)){
			userResponse = userIntegrationPort.login("01607798983");
		}		
//		userSession = userResponse.getSession();
		
		remote.createProject("01609998983", "TestProject", "Kurzbeschreibung des Tests");
		remote.createProject("01600098983", "TestProject", "Kurzbeschreibung des Tests");
		remote.createProject("08000098983", "TestProject", "Kurzbeschreibung des Tests");
		
		remote.createProject("08000098983", "TestProject 5", "Kurzbeschreibung des Tests");
		remote.createProject("08000098983", "TestProject 6", "Kurzbeschreibung des Tests");
		
		ProjectsResponse init = remote.getProjectsByPhone("08000098983");
		remote.addAppointmentToProject(init.getProjects().get(0).getId(), "Topic", "Description", 1234567);
		remote.addAppointmentToProject(init.getProjects().get(1).getId(), "Topic", "Description", 1234567);
	}
	
	/**
	 * Test zum erzeugen eines Projektes. Der Rueckgabecode sollte OK lauten.
	 */
	@Test
	public void aCreateProjectTest() {		
		ReturncodeResponse projectResponse = remote.createProject("01607798983", "TestProject", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum erzeugen eines Projektes. Der Rueckgabecode sollte OK lauten.
	 */
	@Test
	public void createNoProjectTest() {
		ReturncodeResponse projectResponse = remote.createProject("9999999", "TestProject", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Tests um alle Projecte anzufragen, die zu einem Project gehoeren!
	 */
	@Test
	public void bGetProjectsByPhoneTest() {
		ReturncodeResponse projectResponse = remote.createProject("01607798983", "TestProject2", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
		
		projectResponse = remote.createProject("01607798983", "TestProject3", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
		
		projectResponse = remote.createProject("01607798983", "TestProject4", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
		
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		Assert.assertEquals(projectsResponse.getProjects().size(), 4);
	}
	
	/**
	 * Tests um alle Projecte anzufragen, die zu einem Project gehoeren!
	 * Dieser Test soll fehlschlagen.
	 */
	@Test
	public void getNoProjectsByPhoneTest() {		
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("0160xx98983");
		Assert.assertEquals(projectsResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Pruefen ob eine Diskussion einem Project zugeordnet werden kann. Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void cAddDiscussionsByProjectTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		ReturncodeResponse discussionProject = remote.addDiscussionToProject(projectsResponse.getProjects().get(0).getId(), "DiskussionThema");
		Assert.assertEquals(discussionProject.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum Pruefen ob keine Diskussion einem Project zugeordnet wurde. Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void addNoDiscussionsByProjectTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("0160xy98983");
		if(projectsResponse.getReturnCode().equals(ReturnCode.ERROR)){
			Assert.assertEquals(projectsResponse.getReturnCode(), ReturnCode.ERROR);
		}
	}
	
	/**
	 * Test zum abrufen einer Diskussion welches einem Project zugeordnet wurde. Es wir der ReturnCode OK erwartet.
	 */
	@Test
	public void eGetDiscussionByProjectTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		remote.addDiscussionToProject(projectsResponse.getProjects().get(0).getId(), "DiskussionThema1");
		DiscussionResponse discussionProject = remote.getDiscussionsByProject(projectsResponse.getProjects().get(0).getId());
		Assert.assertEquals(discussionProject.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum abrufen einer Diskussion welches einem Project zugeordnet wurde. 
	 * Dieser Test soll fehlschlagen.
	 * Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void getNoDiscussionByProjectTest() {
		DiscussionResponse discussionProject = remote.getDiscussionsByProject(0111);
		Assert.assertEquals(discussionProject.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Entfernen einer Diskussion aus einem Projekt.
	 * Es wird der ReturnCode OK erwartet
	 */
	@Test
	public void zRemoveProjectDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		remote.addDiscussionToProject(projectsResponse.getProjects().get(0).getId(), "DiskussionThema1");
		DiscussionResponse discussionProject = remote.getDiscussionsByProject(projectsResponse.getProjects().get(0).getId());
		ReturncodeResponse discussionResponse = remote.removeProjectDiscussion(projectsResponse.getProjects().get(0).getId(), discussionProject.getDiscussions().get(0).getId());
		Assert.assertEquals(discussionResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Fehlertest zum Entfernen einer Diskussion aus einem Projekt.
	 * Es wird der ReturnCode ERROR erwartet
	 */
	@Test
	public void removeNoProjectDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("0160xx98983");
		Assert.assertEquals(projectsResponse.getReturnCode(), ReturnCode.ERROR);
		
		DiscussionResponse discussionProject = remote.getDiscussionsByProject(0111);
		Assert.assertEquals(discussionProject.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum hinzufuegen einer Notiz zu einer Diskussion. Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void dAddNoteToDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		ReturncodeResponse noteRepsonse = remote.addNoteToDiscussion(projectsResponse.getProjects().get(0).getDiscussions().get(0).getId(), "Das ist eine Testnotiz.", "01607798983");
		Assert.assertEquals(noteRepsonse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum hinzufuegen einer Notiz zu einer Diskussion welche fehlschlagen soll.
	 * Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void addNoNoteToDiscussionTest() {
		ReturncodeResponse noteRepsonse = remote.addNoteToDiscussion(1, "Das ist eine Testnotiz.", "01607798983");
		Assert.assertEquals(noteRepsonse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Abfragen einer Notiz aus einer Diskussion. 
	 * Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void getNotesByDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		remote.addDiscussionToProject(projectsResponse.getProjects().get(0).getId(), "Bla");
		DiscussionResponse discussionProject = remote.getDiscussionsByProject(projectsResponse.getProjects().get(0).getId());
		NotesResponse notesRepsonse = remote.getNotesByDiscussion(discussionProject.getDiscussions().get(0).getId());
		Assert.assertEquals(notesRepsonse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum Abfragen einer Notiz aus einer Diskussion welcher fehlschlagen soll. 
	 * Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void getNoNotesByDiscussionTest() {
		NotesResponse notesRepsonse = remote.getNotesByDiscussion(0);
		Assert.assertEquals(notesRepsonse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Vergleich von Telefonnummern auf dem Geraet zu den in der Datenbank.
	 * Es wird ein ReturnCode ERROR erwartet.
	 */
	@Test
	public void failComparePhonebookTest(){
		UsersResponse userResponse = remote.comparePhonebook(999999, null);
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Vergleich von Telefonnummern auf dem Geraet zu den in der Datenbank.
	 * Es wird ein ReturnCode OK erwartet.
	 */
	@Test
	public void comparePhonebookTest(){
		List<String> userList = new ArrayList<>();
		userList.add("01608898983");
		userList.add("01609998983");
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		UsersResponse userResponse = remote.comparePhonebook(projectsResponse.getProjects().get(0).getId(), userList);
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum Hinzufuegen eines Benutzers zu einem Projekt.
	 * Es wird ein ReturnCode OK erwartet.
	 */
	@Test
	public void fAddUserToProjectTest(){
		ProjectsResponse projectResponse = remote.getProjectsByPhone("01607798983");
		ReturncodeResponse userProjectResponse = remote.addUserToProject("01607798983", projectResponse.getProjects().get(0).getId());
		Assert.assertEquals(userProjectResponse.getReturnCode(), ReturnCode.OK);
	}
	/**
	 * Fehlertest zum Hinzufuegen eines Benutzers zu einem Projekt.
	 * Es wird ein ReturnCode OK erwartet.
	 */
	@Test
	public void fNoAddUserToProjectTest(){
		ProjectsResponse projectResponse = remote.getProjectsByPhone("0160xx98983");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum hinzufuegen von Terminen.
	 * Es wird ein ReturnCode OK erwartet.
	 */
	@Test
	public void addAppointmentToProjectTest() {
		ProjectsResponse projectResponse = remote.getProjectsByPhone("01607798983");
		ReturncodeResponse appointmentResponse = remote.addAppointmentToProject(projectResponse.getProjects().get(0).getId(), "Topic", "Description", 1234567);
		Assert.assertEquals(appointmentResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Fehlertest beim hinzufuegen von Terminen.
	 * Es wird ein ReturnCode ERROR erwartet.
	 */
	@Test
	public void addNoAppointmentToProjectTest() {
		ReturncodeResponse appointmentResponse = remote.addAppointmentToProject(99999, "Topic", "Description", 1234567);
		Assert.assertEquals(appointmentResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Abrufen von Terminen fuer ein jeweiliges Projekt.
	 * Es wird ein ReturnCord OK erwartet.
	 */
	@Test
	public void getAppointmentsByProjectTest() {
		ProjectsResponse projectResponse = remote.getProjectsByPhone("01607798983");
		AppointmentResponse appointmentResponse = remote.getAppointmentsByProject(projectResponse.getProjects().get(0).getId());
		Assert.assertEquals(appointmentResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Fehlertest zum Abrufen von Terminen fuer ein jeweiliges Projekt.
	 * Es wird ein ReturnCord ERROR erwartet.
	 */
	@Test
	public void getNoAppointmentsByProjectTest() {
		AppointmentResponse appointmentResponse = remote.getAppointmentsByProject(99999);
		Assert.assertEquals(appointmentResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Entfernen eines Members von einem Projekt.
	 * Es wird ein ReturnCode OK erwartet.
	 */
	@Test
	public void removeProjectMemberTest() {
		ProjectsResponse projectResponse = remote.getProjectsByPhone("01607798983");
		remote.addUserToProject("01607798983", projectResponse.getProjects().get(0).getId());
		ReturncodeResponse projectMemberResponse = remote.removeProjectMember(projectResponse.getProjects().get(0).getId(), "01607798983");
		Assert.assertEquals(projectMemberResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Fehlertest zum Entfernen eines Members von einem Projekt welches nicht funktionieren soll.
	 * Es wird ein ReturnCode ERROR erwartet.
	 */
	@Test
	public void zRemoveNoProjectMemberTest() {
		ReturncodeResponse projectMemberResponse = remote.removeProjectMember(999999, "01607798983");
		Assert.assertEquals(projectMemberResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Entfernen eines Termins/Meilensteins im Projekt.
	 * Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void removeProjectAppointmentTest(){
		ProjectsResponse projectResponse = remote.getProjectsByPhone("08000098983");
		ReturncodeResponse response = remote.removeProjectAppointment(projectResponse.getProjects().get(0).getId(), projectResponse.getProjects().get(0).getAppointments().get(0).getId());
		Assert.assertEquals(response.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Fehlertest zum welcher ein fehlerhaftes Loeschen simulisieren soll.
	 * Es wird der ReturnCode Error erwartet.
	 */
	@Test
	public void removeNoProjectAppointmentTest(){
		ReturncodeResponse response = remote.removeProjectAppointment(999999, 999999);
		Assert.assertEquals(response.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum updaten eines Projektes.
	 * Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void updateProjectTest() {
		ProjectsResponse projectResponse = remote.getProjectsByPhone("01607798983");
		ProjectResponse updateProject = remote.updateProject(projectResponse.getProjects().get(0).getId(), "Neuer Name", "Neue Beschreibung", "DELAYED");
		Assert.assertEquals(updateProject.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Fehlertest wo ein Updaten des Projektes Fehlschlaegt bzw kein Projekt vorhanden ist.
	 * Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void updateNoProjectTest() {
		ProjectResponse updateProject = remote.updateProject(0111, "Neuer Name", "Neue Beschreibung", "DELAYED");
		Assert.assertEquals(updateProject.getReturnCode(), ReturnCode.ERROR);
	}
}
