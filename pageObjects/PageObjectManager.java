package pageObjects;

import org.openqa.selenium.WebDriver;


public class PageObjectManager {
	
	public LandingPage landingPage;	
	public OffersPage offersPage;
	public CheckoutPage checkoutPage;
	public WebDriver driver;//kinda constructor nunchi ikkadiki vachi motham code ki global ga available avthundi.--3
	
	
	public PageObjectManager(WebDriver driver)//ikkada driver argument manam code lo enter chesinapudu initial ga ichina rahushetty page Ikkada vasthadi.--1
	{
		this.driver = driver;//paina nunchu rahulshetty page ikkada allocate avthundi --2
	}	
	public LandingPage getLandingPage()//ikkada manam void place lo LandingPage ani rasam endukante manam aa LandingPage class ki relate ga obj create chesthunnam kabatti adey return cheyali.
	{
		landingPage = new LandingPage(driver);	//idi last ikkada manaki landing page driver valla open ayyi functions anni avthai --4
		return landingPage;
	}
	
	public OffersPage OffersPage()
	{
		offersPage = new OffersPage(driver);
		return offersPage;
	}
	public CheckoutPage CheckoutPage() 
	{
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
 