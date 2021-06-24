package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest {

	public String loginForm = baseUrl + "/guest-user/login-form";
	public String memberPage = baseUrl + "/member/profile";
	String imgPath = new File("C:/Users/Lucifer/Desktop/Projekti/Yo-meals/img/cuteBunny.png").getAbsolutePath();
	String logInSuccessfull = "Login Successfull";
	String logOutSuccessfull = "Logout Successfull";
	String setupSuccessfull = "Setup Successful";
	String profileImageUpload = "Profile Image Uploaded Successfully";
	String profileImageDelete = "Profile Image Deleted Successfully";

	@Test (priority= 1)
	public void editProfileTest() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.locationPopupPage.closeDialog();

		this.logInPage.logIn(this.emailDemo, this.passwordDemo);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains(logInSuccessfull));

		Thread.sleep(500);

		this.driver.get(memberPage);
		Thread.sleep(500);

		profilePage.changeProfile("Jelena", "Bozinovic", "Kradjordjeva 1", "0642597452", "6155", "United Kingdom", "London",
				"London");
		Thread.sleep(500);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains(setupSuccessfull));

		this.authPage.logOut();
		Assert.assertTrue(notificationSistemPage.getMsgText().contains(logOutSuccessfull));

	}

	@Test (priority= 2)
	public void changeProfileTest() throws InterruptedException {
		this.driver.get(loginForm);
		Thread.sleep(500);
		this.locationPopupPage.closeDialog();

		this.logInPage.logIn(this.emailDemo, this.passwordDemo);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains(logInSuccessfull));

		Thread.sleep(500);

		this.driver.get(memberPage);
		Thread.sleep(500);

		profilePage.imgUpload(imgPath);

		Thread.sleep(3000);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains(profileImageUpload));

		notificationSistemPage.waitMsgDisapear();
		profilePage.removeImg();

		Thread.sleep(1000);

		Assert.assertTrue(notificationSistemPage.getMsgText().contains(profileImageDelete));
		notificationSistemPage.waitMsgDisapear();

		this.authPage.logOut();
		Assert.assertTrue(notificationSistemPage.getMsgText().contains(logOutSuccessfull));

			
	}
}
