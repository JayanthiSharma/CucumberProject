package stepDefinitions;

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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.testContextSetup;

public class OfferPageStepDefinition {
	
public String offerPageProductName;
testContextSetup mummy;
PageObjectManager pageObjectManager;
//Single Responsibilty Principle
//loosly coupled
//Factory Design Pattern(ante deentlo manam anni object creations okadeggara raastham)

public OfferPageStepDefinition(testContextSetup instanceVar1)//testContextSetup class lo evaithey manam objects create chesamo avanni manam instanceVar1 ni mummy ki equate chesi mummy variable ni code lo ekkadaina vaadukoni access cheyochu.
{
	this.mummy=instanceVar1;
}	

@Then("^User searched for (.+) shortname in offers page$")
public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
	  
	 switchToOffersPage(); 
	 OffersPage offersPage = mummy.pageObjectManager.OffersPage();
	 offersPage.searchItem(shortName); 
	 Thread.sleep(2000);
	 offerPageProductName = offersPage.getProductName();
	  
}

public void switchToOffersPage() 
{
	// pageObjectManager = new PageObjectManager(mummy.driver);
	  LandingPage landingPage = mummy.pageObjectManager.getLandingPage();
	  landingPage.selectTopDealsPage();
	  mummy.genericUtils.SwitchWindowToChild();
}
	
		
	@And("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_Landing_Page() 
	{
		Assert.assertEquals(offerPageProductName, mummy.landingPageproductName);
	}

}
