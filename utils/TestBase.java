package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	
	public WebDriver driver;
	public FirefoxOptions options = new FirefoxOptions();
	
	public WebDriver WebDriverManager() throws IOException 
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");//ikkada manam system.getproperty ani enduku isthunnam ante ila rayadam valla any machine lo work avthundi.
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		// result = testCondition ? value1 : value2
		//kinda line lo em avthundi ante manam okavela command prompt lo ey browser tho run avvalo chepthey browser_maven condition(firefox) anedi browser variable lo store ayyi run avthundi.
		//okavela manam em command ivvakapothey apudu browser_properties(chrome) anedi browser variable lo store ayyi adi run avthundi.
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		
		if(driver == null)//deenivalla manam driver manager ni call chesina prathisaari oka new browser create avvadu avasaram untene create avthundi
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//test//resources//chromedriver.exe");
				driver = new ChromeDriver();
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C://Users//KJAYANTH//OneDrive - Capgemini//Desktop//Kasula Jayanthi//chromedriver//geckodriver-v0.33.0-win32//geckodriver.exe");
				options.setBinary("C://Program Files//Mozilla Firefox//firefox.exe");
				driver = new FirefoxDriver(options);
			}
		driver.get(url);
		}
		return driver;
	}
	
}
