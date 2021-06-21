package tests;

import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {
	
	public String loginForm="http://demo.yo-meals.com/guest-user/login-form";
			
	
	@Test
	public void editProfileTest() {
		this.driver.get(loginForm);
		
	}
}
