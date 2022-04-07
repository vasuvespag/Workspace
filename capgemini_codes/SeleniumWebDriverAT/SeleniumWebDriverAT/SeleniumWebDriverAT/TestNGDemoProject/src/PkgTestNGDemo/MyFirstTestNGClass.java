package PkgTestNGDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstTestNGClass
{
	   public String baseURL="http://demo.opencart.com/";
			
		WebDriver driver = new FirefoxDriver();
		
	  @Test
	  public void verifyHomePageTitle() 
	  {
		  driver.get(baseURL);
		  String expectedTitle="Your Store";
		  String actualTitle = driver.getTitle();
		  Assert.assertEquals(actualTitle, expectedTitle);
		  
		  driver.quit();
	  }
}