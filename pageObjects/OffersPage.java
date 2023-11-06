package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
		public 	WebDriver driver;
		
		public OffersPage(WebDriver driver)
		//ikkada paina line lo unna driver ki manam constructor dwaara oka driver vasthadi danni public lo declare chesina daaniki assign chesthaamu.
		{
			this.driver = driver;
		}
		By search = By.id("search-field");
		By productName = By.cssSelector("tr td:nth-child(1)");
		

		public void searchItem(String name)
		{
			driver.findElement(search).sendKeys(name);
		}
		
		public void getSearchText()
		{
			driver.findElement(search).getText();
		}
		public String getProductName()
		{
			return driver.findElement(productName).getText();
		}
	
}
