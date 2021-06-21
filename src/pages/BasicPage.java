package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public abstract class BasicPage {
	protected WebDriver driver;
	protected JavascriptExecutor js = (JavascriptExecutor) driver;

	public BasicPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean elementExist(By by) {
		boolean exist= true;
		try {
			driver.findElement(by);
		} catch (Exception e) {
			exist=false;
		}
		return exist;

	}

}
