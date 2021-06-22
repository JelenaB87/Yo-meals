package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultPage extends BasicPage {

	public SearchResultPage(WebDriver driver, JavascriptExecutor js) {
		super(driver, js);

	}

	// Method for all search results

	public List<WebElement> getSearchResults() {
		return driver.findElements(By.xpath("//*[@class='product-name']/a"));
	}

	// Method for all search meal titles

	public ArrayList<String> getAllResultsNames() {
		ArrayList<String> names = new ArrayList<>();

		for (int i = 0; i < getSearchResults().size(); i++) {
			String name = getSearchResults().get(i).getText();
			names.add(name);
		}
		return names;
	}

	// Method for result number

	public int getResultsNumber() {
		return getSearchResults().size();
	}

}
