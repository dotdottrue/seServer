package de.project.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.project.integration.ProjectsResponse;
import de.project.integration.ReturnCode;
import de.project.integration.ProjectSessionTO;
import de.project.integration.ProjectUserResponse;
import de.project.integration.ProjectIntegration;
import de.project.integration.ProjectIntegrationService;
import de.project.integration.ReturncodeResponse;
import de.project.integration.UserIntegration;
import de.project.integration.UserIntegrationService;


/**
 * 
 * Testet alle Server-Schnittstellen der projectIntegration.
 * @author tobiaskappert
 *
 */
public class ProjectIntegretionTest {

	private static ProjectIntegration remote;
	
	private static ProjectSessionTO userSession; 	
	
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
		
		if(userResponse.getReturnCode().equals(ReturnCode.ERROR)){
			userResponse = userIntegrationPort.login("01607798983");
		}
		
		userSession = userResponse.getSession();		
		
	}
	
	/**
	 * Test zum erzeugen eines Projektes. Der RŸckgabecode sollte OK betragen.
	 */
	@Test
	public void createProjectTest() {
		ReturncodeResponse projectResponse = remote.createProject("01607798983", "TestProject", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
	}
	
	@Test
	public void getProjectsByPhoneTest() {
		ReturncodeResponse projectResponse = remote.createProject("01607798983", "TestProject2", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
		
		projectResponse = remote.createProject("01607798983", "TestProject3", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
		
		projectResponse = remote.createProject("01607798983", "TestProject4", "Kurzbeschreibung des Tests");
		Assert.assertEquals(projectResponse.getReturnCode(), ReturnCode.OK);
		
		ProjectsResponse projectsResponse = remote.getProjectsByPhone("01607798983");
		Assert.assertEquals(projectsResponse.getProjects().size(), 10);
	}
}
