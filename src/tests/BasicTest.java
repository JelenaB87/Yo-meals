package tests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;
import pages.SearchResultPage;
import java.util.Date;

public abstract class BasicTest {

	protected WebDriver driver;
	protected LocationPopupPage locationPopupPage;
	protected LoginPage logInPage;
	protected NotificationSistemPage notificationSistemPage;
	protected ProfilePage profilePage;
	protected AuthPage authPage;
	protected MealPage mealPage;
	protected CartSummaryPage cartSummaryPage;
	protected SearchResultPage searchResultPage;
	protected String baseUrl = "http://demo.yo-meals.com";
	protected String emailDemo = "customer@dummyid.com";
	protected String passwordDemo = "12345678a";
	Date currentdate = new Date();
	protected String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");

	@BeforeMethod
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		this.driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;


		logInPage = new LoginPage(driver, js);
		locationPopupPage = new LocationPopupPage(driver,js);
		notificationSistemPage = new NotificationSistemPage(driver,js);
		profilePage = new ProfilePage(driver,js);
		authPage = new AuthPage(driver,js);
		mealPage = new MealPage(driver,js);
		cartSummaryPage = new CartSummaryPage(driver,js);
		searchResultPage = new SearchResultPage(driver,js);
	}

	@AfterMethod
	public void ifTestFAil() throws IOException {
		try {
			File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(".//screenshot//" + screenshotfilename + ".png"));
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		}

		this.driver.quit();
	}


}
