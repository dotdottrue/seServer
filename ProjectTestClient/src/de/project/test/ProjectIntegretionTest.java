package de.project.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import de.project.integration.NotesResponse;
import de.project.integration.DiscussionResponse;
import de.project.integration.ProjectsResponse;
import de.project.integration.ReturnCode;
//import de.project.integration.ProjectSessionTO;
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
		
		if(userResponse.getReturnCode().equals(ReturnCode.ERROR)){
			userResponse = userIntegrationPort.login("01607798983");
		}		
//		userSession = userResponse.getSession();
		
		remote.createProject("01609998983", "TestProject", "Kurzbeschreibung des Tests");
		remote.createProject("01600098983", "TestProject", "Kurzbeschreibung des Tests");
	}
	
	/**
	 * Test zum erzeugen eines Projektes. Der Rückgabecode sollte OK lauten.
	 */
	@Test
	public void aCreateProjectTest() {		
		ReturncodeResponse projectResponse = remote.createProject("01607798983", "TestProject", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum erzeugen eines Projektes. Der Rückgabecode sollte OK lauten.
	 */
	@Test
	public void createNoProjectTest() {
		ReturncodeResponse projectResponse = remote.createProject("9999999", "TestProject", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Tests um alle Projecte anzufragen, die zu einem Project gehören!
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
	 * Tests um alle Projecte anzufragen, die zu einem Project gehören!
	 * Dieser Test soll fehlschlagen.
	 */
	@Test
	public void getNoProjectsByPhoneTest() {		
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("0160xx98983");
		Assert.assertEquals(projectsResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum Prüfen ob eine Diskussion einem Project zugeordnet werden kann. Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void cAddDiscussionsByProjectTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		ReturncodeResponse discussionProject = remote.addDiscussionToProject(projectsResponse.getProjects().get(0).getId(), "DiskussionThema");
		Assert.assertEquals(discussionProject.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum Prüfen ob keine Diskussion einem Project zugeordnet wurde. Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void addNoDiscussionsByProjectTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("0160xy98983");
		if(projectsResponse.getReturnCode().equals(ReturnCode.ERROR)){
			Assert.assertEquals(projectsResponse.getReturnCode(), ReturnCode.ERROR);
		}else{
			ReturncodeResponse discussionProject = remote.addDiscussionToProject(projectsResponse.getProjects().get(0).getId(), "DiskussionThema");			
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
	 * Es wir der ReturnCode ERROR erwartet.
	 */
	@Test
	public void getNoDiscussionByProjectTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01600098983");
		DiscussionResponse discussionProject = remote.getDiscussionsByProject(1);
		Assert.assertEquals(discussionProject.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Test zum hinzufügen einer Notiz zu einer Diskussion. Es wird der ReturnCode OK erwartet.
	 */
	@Test
	public void dAddNoteToDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		ReturncodeResponse noteRepsonse = remote.addNoteToDiscussion(projectsResponse.getProjects().get(0).getDiscussions().get(0).getId(), "Das ist eine Testnotiz.", "01607798983");
		Assert.assertEquals(noteRepsonse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum hinzufügen einer Notiz zu einer Diskussion welche fehlschlagen soll.
	 * Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void addNoNoteToDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01609998983");
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
		NotesResponse notesRepsonse = remote.getNotesByDiscussion(projectsResponse.getProjects().get(0).getDiscussions().get(0).getId());
		Assert.assertEquals(notesRepsonse.getReturnCode(), ReturnCode.OK);
	}
	
	/**
	 * Test zum Abfragen einer Notiz aus einer Diskussion welcher fehlschlagen soll. 
	 * Es wird der ReturnCode ERROR erwartet.
	 */
	@Test
	public void getNoNotesByDiscussionTest() {
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01609998983");
		NotesResponse notesRepsonse = remote.getNotesByDiscussion(1);
		Assert.assertEquals(notesRepsonse.getReturnCode(), ReturnCode.ERROR);
	}
	
}
