package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.testContextSetup;


public class Hooks {
testContextSetup mummy;

	public Hooks(testContextSetup instanceVar1) 
	{
		this.mummy = instanceVar1;
	}
	@After
	public void AfterScenario() throws IOException
	{
		mummy.testBase.WebDriverManager().quit();
	}
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException//ikkada manam scenario ane parameter pass chesthunnam. cucumber lo inbuilt class untundi scenario ani. idi mana scenario ki related all infoni save chesthundi.
	{
		WebDriver driver = mummy.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			File sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);//ikkada manam extent reports generate chesthunnam kabatti extent ki screenshot generation kooda idea undi so vallu manam screenshot teesthey danni default ga valla report lo save chesi manaki report chesthaaru.
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}
	
}
