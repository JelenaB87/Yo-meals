package pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
		return driver.findElement(By.className("favourite itemfav  link "));
	}
	public WebElement getProductQty() {
		return driver.findElement(By.name("product_qty"));
	}
	public List<WebElement> getProducts(){
		return driver.findElements(By.xpath("//*[@class='featured-img']/a"));
	}
	
	public WebElement getAddToCart() {
		return driver.findElement(By.linkText("Add To Cart"));
	}
	
	// Method for add food
	
	public void addToCart(String quantity) {
		this.getProductQty().sendKeys(quantity);
		this.getAddToCart().click();
	}

	// Method for add to favorites
	
	public void addFavorite() {
		this.getFavorite().click();
	}
	
}
