package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public 	WebDriver driver;
	public CheckoutPage(WebDriver driver1)
	//ikkada paina line lo unna driver ki manam constructor dwaara oka driver vasthadi danni public lo declare chesina daaniki assign chesthaamu.
	{
		this.driver = driver1;
	}

	By cartBag = By.cssSelector("[alt='Cart']");
	By checkOut = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By checkoutProductName = By.xpath("//*[@id=\"productCartTables\"]/tbody/tr/td[2]/p");
	By promoBtn = By.cssSelector(".promoBtn");
	By placeOrder = By.xpath("//*[@id=\"root\"]/div/div/div/div/button");
	

	public String getCheckoutProductName()
	{
		return driver.findElement(checkoutProductName).getText();
	}

	public void proceedToCheckout()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOut).click();
	}
	
	public Boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
	}
	public Boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}
}
