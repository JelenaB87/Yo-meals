package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage {

	public LocationPopupPage(WebDriver driver) {
		super(driver);
	}
	
	//get metoda za element koji prikazuje lokaciju u hederu 

	public WebElement getHeaderLocation() {
		return driver.findElement(By.className("location-selector"));
	}

	public WebElement getClose() {
		return driver.findElement(By.className("close-btn close-btn-white"));
	}
}
