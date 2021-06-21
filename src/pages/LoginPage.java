package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage {
	public LoginPage(WebDriver driver, JavascriptExecutor js) {
		super(driver,js);
	}

	public WebElement getUserName() {
		return driver.findElement(By.name("username"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.name("password"));
	}

	public WebElement getBtn() {
		return driver.findElement(By.name("btn_submit"));
	}

	// Method for login

	public void logIn(String username, String password) {
		this.getUserName().clear();
		this.getUserName().sendKeys(username);
		this.getPassword().clear();
		this.getPassword().sendKeys(password);
		this.getBtn().click();
	}
}
