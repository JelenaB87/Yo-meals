package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BasicTest {

	public String mealsPg = baseUrl + "/meals";
	public String locationName = "City Center - Albany";
	public String errorMsgData = "[ERROR] Number of results dont match with Data(1).xslx file";

	@Test (priority=1)
	public void searchResults() throws InterruptedException, IOException {
		this.driver.get(mealsPg);
		
		Thread.sleep(500);
		this.locationPopupPage.setLocation(locationName);
		

		File file = new File("data/Data(1).xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet("Meal Search Results");
		
		SoftAssert sa = new SoftAssert();

		
		for (int i = 1; i <= 6; i++) {
			String searchUrl = sheet.getRow(i).getCell(1).getStringCellValue();
			String searchLocation = sheet.getRow(i).getCell(0).getStringCellValue();
			int numberOfresults = (int) sheet.getRow(i).getCell(2).getNumericCellValue();
			
			Thread.sleep(1000);
			driver.get(searchUrl);
			
			locationPopupPage.getHeaderLocation().click();
			
			locationPopupPage.setLocation(searchLocation);
			Thread.sleep(1000);
			
			sa.assertEquals(this.searchResultPage.getResultsNumber(), numberOfresults,errorMsgData);

			wb.close();
			sa.assertAll();
		}

	}

}
