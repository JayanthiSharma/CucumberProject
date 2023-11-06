package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.testContextSetup;

public class LandingPageStepDefinition {
public WebDriver driver;	// ee global variable ki life kinda declaration valla vasthundi
public String landingPageproductName;
LandingPage landingPage;
testContextSetup mummy;

public LandingPageStepDefinition(testContextSetup instanceVar1)
{
	this.mummy = instanceVar1; 
	this.landingPage = mummy.pageObjectManager.getLandingPage();//Ikkada manam testContextSetup dantlo declare chesina vatini ikada call chesi mummy ane public variable ki assign chesthunnam. daani valla avi global avthai and manam ekkadaina vaadukovachu motham code lo. 
}

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() 
	{
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
        //System.setProperty("webdriver.chrome.driver","C:\\Users\\KJAYANTH\\OneDrive - Capgemini\\Desktop\\Kasula Jayanthi\\chromedriver\\chromedriver-win32\\chromedriver.exe");
		//mummy.driver = new ChromeDriver();//driver gets the life here
		//mummy.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	@When("^User searched wih Shortname (.+) and extracted actual name of product$")
	public void user_searched_wih_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
	
		//TestContextSetup.driver.findElement(By.className("search-keyword")).sendKeys(shortName);
		Thread.sleep(2000);
		mummy.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(mummy.landingPageproductName + " is extracted from HomePage");
			
	}
	
	@When("Added {string} items of selected product to cart")
	public void Added_3_items_of_product_to_cart(String quantity)
	{
		landingPage.IncrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}


}
