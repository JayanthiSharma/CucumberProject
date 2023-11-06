package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class testContextSetup {
//ikkada manam split cheyabadina rendu step definition files em properties or things ni share cheskuntunnayo cheppali.
//and alane manam ikkada oka framework ni create chesthunnapudu create cheyavalsina objects ani mention chesthunnam
	public WebDriver driver;
	public String landingPageproductName;
	public String checkOutItemName;
	public PageObjectManager pageObjectManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public testContextSetup() throws IOException 
	{
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());  
		//paina idi object creation
		genericUtils = new GenericUtils(testBase.WebDriverManager()); 
	
	}
}
//Generic Utils lo manam anni pages evaithey general ga use cheskuntamo avey rasthunnam
