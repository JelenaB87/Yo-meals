package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest {

	public String mealLobster = baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo";
	public String locationMsg = "The Following Errors Occurred";
	public String locationName = "City Center - Albany";
	public String addCartMsg = "Meal Added To Cart";
	public String addFavoriteMsg = "Please login first!";
	public String logInPg = baseUrl + "/guest-user/login-form";
	public String favoriteMealMsg = "Product has been added to your favorites";
	public String mealsPg = baseUrl + "/meals";
	public String msgCartNoVisible = "The Meal Added To Cart message is not visible";
	public String removedMsg = "All meals removed from Cart successfully";
	public String removedMsgNoVisible = "The All meals removed from Cart successfully message is not visible.";

	@Test (priority= 0)
	public void addToCartTest() throws InterruptedException {
		this.driver.get(mealLobster);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.mealPage.addToCart(2);
		Assert.assertTrue(notificationSistemPage.getMsgText().contains(locationMsg));
		this.notificationSistemPage.waitMsgDisapear();

		// Set location and add meal

		this.locationPopupPage.dialogueOpen();
		Thread.sleep(2000);
		this.locationPopupPage.setLocation(locationName);
		Thread.sleep(2000);

		this.mealPage.addToCart(2);
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains(addCartMsg));
	}

	@Test (priority= 1)
	public void addToFavorite() throws InterruptedException {

		this.driver.get(mealLobster);
		this.locationPopupPage.closeDialog();
		Thread.sleep(2000);
		this.mealPage.addFavorite();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains(addFavoriteMsg));

		// LogIn

		this.driver.get(logInPg);
		Thread.sleep(2000);
		this.logInPage.logIn(emailDemo, passwordDemo);

		// Add to favorite

		this.driver.get(mealLobster);
		Thread.sleep(2000);
		this.mealPage.addFavorite();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains(favoriteMealMsg));

	}

	@Test(priority= 2)
	public void clearCart() throws InterruptedException, IOException {

		this.driver.get(mealsPg);
		this.locationPopupPage.setLocation(locationName);
		Thread.sleep(2000);

		// Data

		File file = new File("data/Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Meals");

		SoftAssert sa = new SoftAssert();

		// Add to cart

		for (int i = 1; i <= 5; i++) {
			String mealUrl = sheet.getRow(i).getCell(0).getStringCellValue();
			int quantity = (int) sheet.getRow(i).getCell(1).getNumericCellValue();

			this.driver.get(mealUrl);
			Thread.sleep(2000);
			this.mealPage.addToCart(quantity);

			sa.assertTrue(notificationSistemPage.getMsgText().contains(addCartMsg), msgCartNoVisible);

			Thread.sleep(2000);
			cartSummaryPage.clearAll();
			Assert.assertTrue(notificationSistemPage.getMsgText().contains(removedMsg), removedMsgNoVisible);
		}

	}
}
