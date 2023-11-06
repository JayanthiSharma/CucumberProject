package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public 	WebDriver driver;
	public LandingPage(WebDriver driver1)
	//ikkada paina line lo unna driver ki manam constructor dwaara oka driver vasthadi danni public lo declare chesina daaniki assign chesthaamu.
	{
		this.driver = driver1;
	}
	By search = By.className("search-keyword");
	By productName = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/h4");
	By topDeals = By.linkText("Top Deals"); 
	By increment =  By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}		
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchText()
	{
		driver.findElement(search).getText();
	}
	public 	String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}	
	
	
	//kinda code antha related to checkout feature file
	public void IncrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	public void addToCart()
	{
			driver.findElement(addToCart).click();
	}


}
