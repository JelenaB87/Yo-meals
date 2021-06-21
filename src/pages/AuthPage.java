package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver) {
		super(driver);
	}

	public WebElement getFilled() {
		return driver.findElement(By.xpath("//*[@class='filled']/a"));
	}

	public WebElement getAccount() {
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li/a"));
	}
	public WebElement getLogOut(){
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li[2]/a"));
	}

	
	// Method for logout
	
	public void logOut() {
		this.getLogOut().click();
	}
}
