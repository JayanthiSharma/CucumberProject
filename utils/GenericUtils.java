package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	public WebDriver driver;

	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	public void SwitchWindowToChild()
	{
	  Set<String> s1 = driver.getWindowHandles();
	  		//ikkada manam em chesthunnam ante oka page lo unna top deals link click chesthey inko
	  		//inko page open avthundi kada adi child page.ante ipudu manaki 2 webpages unai kada
	  		//vaatini manam oka set lo save chesthunnamu.
	  Iterator<String> i1=s1.iterator();
	  		//ikkada intiial ga iterator null ki point chesi untundi
	  String parentWindow = i1.next();//ee step valla iterator 0 index ki point chesi untundi and andulo parent window undi
	  String childWindow = i1.next();//ee step valla iterator 1 index ki point chesthundi and dantlo child window store ayi undi.
	  driver.switchTo().window(childWindow);//ikkada manam selenium ki instruct chesthunnam aa childwindow ni use cheyamani.
	}

}
