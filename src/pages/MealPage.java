package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage {

	public MealPage(WebDriver driver, JavascriptExecutor js) {
		super(driver,js);
	}
	
	public WebElement getShowFilters() {
		return driver.findElement(By.className("js-filter-text"));
	}
	public WebElement getSortBy() {
		return driver.findElement(By.className("sort-toggle is-active"));
	}
	public WebElement getFavorite() {
		return driver.findElement(By.className("favourite"));
	}
	public WebElement getProductQty() {
		return driver.findElement(By.name("product_qty"));
	}
	public List<WebElement> getProducts(){
		return driver.findElements(By.xpath("//*[@class='featured-img']/a"));
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(By.className("js-proceedtoAddInCart"));
	}
	
	// Method for add food
	
	public void addToCart(int quantity) {
		String qty = Integer.toString(quantity);
		this.getProductQty().click();
		this.getProductQty().sendKeys(Keys.BACK_SPACE);
		this.getProductQty().sendKeys(qty);
		this.getAddToCart().click();
	}

	// Method for add to favorites
	
	public void addFavorite() {
		this.getFavorite().click();
	}
	
}
