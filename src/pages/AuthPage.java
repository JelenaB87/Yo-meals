package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage {

	public AuthPage(WebDriver driver, JavascriptExecutor js) {
		super(driver,js);
	}

	public WebElement getFilled() {
		return driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div[2]/div[2]/ul/li/a"));
	}

	public WebElement getAccount() {
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li/a"));
	}
	public WebElement getLogOut(){
		return driver.findElement(By.xpath("//*[@class='my-account-dropdown']/ul/li[2]/a"));
	}

	
	// Method for logout
	
	public void logOut() {
		this.getFilled().click();
		this.getLogOut().click();
	}
}
