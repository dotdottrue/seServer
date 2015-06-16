package de.project.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.project.integration.ReturnCode;
import de.project.integration.ProjectUserResponse;
import de.project.integration.UserIntegration;
import de.project.integration.UserIntegrationService;

public class UserIntegrationTest {
	
	private static UserIntegration remote;
	
	@BeforeClass
	public static void  initTest() {
		UserIntegrationService service = new UserIntegrationService();
		remote = service.getUserIntegrationPort();
	}
	
	/*
	 * Dieser Test prüft ob ein Benutzer registriert werden kann. 
	 * Der ReturnCode sollte OK lauten und der Benutzer sollte dem gewünschten entsprechen.
	 */	
	@Test
	public void userRegistrationTest() {
		ProjectUserResponse userResponse = remote.registerUser("015144530578");
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.OK);
		Assert.assertEquals(userResponse.getSession().getUser().getPhoneNumber(), "015144530578");
	}
	
//	@Test
//	public void userRegistrationTest() {
//		ProjectUserResponse userResponse = remote.login("015144530578");
//		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.OK);
//		Assert.assertEquals(userResponse.getSession().getUser().getPhoneNumber(), "015144530578");
//	}
}
