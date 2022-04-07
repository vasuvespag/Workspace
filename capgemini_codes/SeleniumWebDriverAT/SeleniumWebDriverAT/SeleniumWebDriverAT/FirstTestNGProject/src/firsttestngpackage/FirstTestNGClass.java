package firsttestngpackage;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstTestNGClass 
{
	//public String baseURL="https://www.google.co.in/";
	
	public String baseURL="file:///D:/SeleniumWebDriverAT/Lesson05/src/AlertExample.html";
	WebDriver driver = new FirefoxDriver();
	
  @Test
  public void verifyHomePageTitle() 
  {
	  driver.get(baseURL);
	  String expectedTitle="Alert Example";
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  //driver.quit();
  }
}