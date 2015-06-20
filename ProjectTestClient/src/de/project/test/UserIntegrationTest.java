package de.project.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import de.project.integration.ReturncodeResponse;
import de.project.integration.ReturnCode;
import de.project.integration.ProjectUserResponse;
import de.project.integration.UserIntegration;
import de.project.integration.UserIntegrationService;

/**
 * 
 * Testet alle Server-Schnittstellen der UserIntegration.
 * @author Tobias Kappert
 *
 */
public class UserIntegrationTest {
	
	private static UserIntegration remote;
	
	/**
	 * Verbindungsaufbau zum Server.
	 */
	@BeforeClass
	public static void  initTest() {
		UserIntegrationService service = new UserIntegrationService();
		remote = service.getUserIntegrationPort();
	}
	
	/**
	 * Dieser Test prueft ob ein Benutzer registriert werden kann. 
	 * Der ReturnCode sollte OK lauten und der Benutzer sollte dem gewuenschten entsprechen.
	 */	
	@Test
	public void userRegistrationTest() {
		ProjectUserResponse userResponse = remote.registerUser("015144530578");
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.OK);
		Assert.assertEquals(userResponse.getSession().getUser().getPhoneNumber(), "015144530578");
	}
	
	/**
	 * Dieser Test prueft ob ein Benutzer registriert werden kann. 
	 * Der ReturnCode sollte ERROR da derBenutzer schon vorhanden ist.
	 */	
	@Test
	public void userRegistrationFailedTest() {
		ProjectUserResponse userResponse = remote.registerUser("015144530578");
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.ERROR);
	}
	
	/**
	 * Dieser Test prueft ob ein Benutzer sich einloggen kann. 
	 * Der Returncode sollte OK haben und der Session besitzer die Nummer des Logins.
	 */
	@Test
	public void userLoginTest() {
		ProjectUserResponse userResponse = remote.login("015144530578");
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.OK);
		Assert.assertEquals(userResponse.getSession().getUser().getPhoneNumber(), "015144530578");
	}
	
	/**
	 * Dieser Test prueft ob ein Benutzer sich einloggen und auch wieder Ausloggen kann
	 */
	@Test
	public void userLogoutTest() {
		ProjectUserResponse userResponse = remote.login("015144530578");
		Assert.assertEquals(userResponse.getReturnCode(), ReturnCode.OK);
		Assert.assertEquals(userResponse.getSession().getUser().getPhoneNumber(), "015144530578");
		
		ReturncodeResponse logoutCode = remote.logout(userResponse.getSession().getId());
		Assert.assertEquals(logoutCode.getReturnCode(), ReturnCode.OK);
	}
}
