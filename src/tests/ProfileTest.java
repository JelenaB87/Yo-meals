package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	public String loginForm = baseUrl + "/guest-user/login-form";
	public String memberPage = baseUrl + "/member/profile";
	String imgPath = new File("C:/Users/Lucifer/Desktop/Projekti/Yo-meals/img/cuteBunny.png").getAbsolutePath();

	@Test
	public void editProfileTest() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.locationPopupPage.closeDialog();

		this.logInPage.logIn(this.emailDemo, this.passwordDemo);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains("Login Successfull"));

		Thread.sleep(500);

		this.driver.get(memberPage);
		Thread.sleep(500);

		profilePage.changeProfile("Pera", "Peric", "Kradjordjeva 1", "0642597452", "6155", "United Kingdom", "London",
				"London");
		Thread.sleep(500);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains("Setup Successful"));

		this.authPage.logOut();
	}

	@Test
	public void changeProfileTest() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.locationPopupPage.closeDialog();

		this.logInPage.logIn(this.emailDemo, this.passwordDemo);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains("Login Successfull"));

		Thread.sleep(500);

		this.driver.get(memberPage);
		Thread.sleep(500);
		
		
		profilePage.imgUpload(imgPath);
		
		Thread.sleep(3000);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains("Profile Image Uploaded Successfully"));

		notificationSistemPage.waitMsgDisapear();
		profilePage.removeImg();
		
		Thread.sleep(1000);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains("Profile Image Deleted Successfully"));
		notificationSistemPage.waitMsgDisapear();
		
		this.authPage.logOut();
	}
}
