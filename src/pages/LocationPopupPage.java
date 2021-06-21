package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver, JavascriptExecutor js) {
		super(driver,js);
	}

	// get metoda za element koji prikazuje lokaciju u hederu

	public WebElement getHeaderLocation() {
		return driver.findElement(By.className("location-selector"));
	}

	public WebElement getClose() {
		return driver.findElement(By.className("close-btn close-btn-white"));
	}

	public WebElement getKeyword() {
		return driver.findElement(By.xpath("//*[@id='locality_keyword']"));
	}

	public WebElement getLocationItem(String locationName) {
		return driver.findElement(By.xpath("//li/a[contains(text(), '" + locationName + "')]/.."));
	}

	public WebElement getLocationInput() {
		return driver.findElement(By.xpath("//*[@id='location_id']"));
	}

	public WebElement getSubmit() {
		return driver.findElement(By.xpath("//*[@name='btn_submit']"));
	}

	// Method for opening a dialog

	public void dialogueOpen() {
		this.getHeaderLocation().click();
	}

	// Method that sets the location

	public void setLocation(String locationName) throws InterruptedException {
		this.getKeyword().click();
		WebElement locationItem = this.getLocationItem(locationName);
		String dataValue = locationItem.getAttribute("data-value");
		WebElement locationInput = this.getLocationInput();
		this.js.executeScript("arguments[0].value=arguments[1]", locationInput, dataValue);
		Thread.sleep(2000);
		this.js.executeScript("arguments[0].click()", this.getSubmit());
	}

	// Method that close dialog

	public void closeDialog() {
		this.getClose().click();
	}
}
