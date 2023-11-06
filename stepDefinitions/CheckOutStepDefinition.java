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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.testContextSetup;

public class CheckOutStepDefinition {
public WebDriver driver;	// ee global variable ki life kinda declaration valla vasthundi
public String landingPageproductName;
public CheckoutPage checkOutPage;
testContextSetup mummy;

public CheckOutStepDefinition(testContextSetup instanceVar1)
{
	this.mummy = instanceVar1;
	this.checkOutPage = mummy.pageObjectManager.CheckoutPage(); //Ikkada manam testContextSetup dantlo declare chesina vatini ikada call chesi mummy ane public variable ki assign chesthunnam. daani valla avi global avthai and manam ekkadaina vaadukovachu motham code lo. 
}

@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout_and_do_validation(String items) throws InterruptedException	
	{
	//LandingPage landingPage = mummy.pageObjectManager.getLandingPage();
	//mummy.landingPageproductName = landingPage.getProductName().split("-") [0].trim();
	//System.out.println(mummy.landingPageproductName + " is extracted from HomePage");
	checkOutPage.proceedToCheckout();
	Thread.sleep(2000);
	mummy.checkOutItemName = checkOutPage.getCheckoutProductName().split("-") [0].trim();
	System.out.println(mummy.checkOutItemName + " is what added to cart");
	Assert.assertEquals(mummy.checkOutItemName, mummy.landingPageproductName);
	}

@Then("verify user has ability to enter promo code and place the order")
public void user_checks_for_promocode_and_place_order()	
	{	
	Assert.assertTrue(checkOutPage.verifyPromoBtn());
	Assert.assertTrue(checkOutPage.verifyPlaceOrder());
	}
}
