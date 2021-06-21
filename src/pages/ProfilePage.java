package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage {

	public ProfilePage(WebDriver driver) {
		super(driver);
	}

	// http://demo.yo-meals.com/member/profile

	public WebElement getFirstName() {
		return driver.findElement(By.name("user_first_name"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.name("user_last_name"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.name("user_address"));
	}

	public WebElement getPhone() {
		return driver.findElement(By.name("user_phone"));
	}

	public WebElement getZipCode() {
		return driver.findElement(By.name("user_zip"));
	}

	public Select getCountry() {
		Select dropdown = new Select(driver.findElement(By.id("user_country_id")));
		return dropdown;
	}

	public Select getState() {
		Select dropdown = new Select(driver.findElement(By.id("user_state_id")));
		return dropdown;
	}

	public Select getCity() {
		Select dropdown = new Select(driver.findElement(By.id("user_city")));
		return dropdown;
	}

	public WebElement getPassword() {
		return driver.findElement(By.name("current_password"));
	}

	public WebElement getNewPassword() {
		return driver.findElement(By.name("new_password"));
	}

	public WebElement getConfirmPassword() {
		return driver.findElement(By.name("conf_new_password"));
	}
	
	public WebElement getSubmitChangeProfile() {
		return driver.findElement(By.xpath("//*[@id=\"profileInfoFrm\"]/div[5]/div/fieldset/input"));
	}
	
	public WebElement getSubmitChangePassword() {
		return driver.findElement(By.xpath("//*[@id=\"frm_fat_id_changePwdFrm\"]/div/div[4]/fieldset/input"));
	}
		
	public WebElement getUploadImage() {
		return driver.findElement(By.name("ion-camera"));
	}
	
	public WebElement getRemoveImage() {
		return driver.findElement(By.name("ion-android-close"));
	}
	
	public WebElement getFilePath() {
		return driver.findElement(By.xpath("//input[@type='file']"));
	}
	
	// Method for upload profile image
	
	public void imgUpload(String pathImg) {
		this.js.executeScript("arguments[0].click();", this.getUploadImage());
		this.getFilePath().sendKeys(pathImg);
	}
	
	// Method for remove profile image

	public void removeImg() {
		this.js.executeScript("arguments[0].click();", this.getRemoveImage());
	}
	
	// Method for change profile

	public void changeProfile(String firstName, String lastName, String address, String phone,
							String zipCode, String country, String state, String city ) throws InterruptedException {
		this.getFirstName().clear();
		this.getFirstName().sendKeys(firstName);
		this.getLastName().clear();
		this.getLastName().sendKeys(lastName);
		this.getAddress().clear();
		this.getAddress().sendKeys(address);
		this.getPhone().clear();
		this.getPhone().sendKeys(phone);
		this.getZipCode().clear();
		this.getZipCode().sendKeys(zipCode);
		Thread.sleep(2000);
		this.getCountry().selectByVisibleText(country);
		Thread.sleep(2000);
		this.getState().selectByVisibleText(state);
		Thread.sleep(2000);
		this.getCity().selectByVisibleText(city);
		Thread.sleep(2000);
		this.getSubmitChangeProfile().click();
	}

}
