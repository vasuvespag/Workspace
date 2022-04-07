package TestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.chrome.*;

public class TestNGWD01
{
	WebDriver driver;
	SoftAssert softAssert=new SoftAssert();
	
	@BeforeTest
	public  void openBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","D:/Advanced Selenium Libs/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demo.opencart.com/");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
		String title=driver.getTitle();
		//Assert.assertEquals(title, "Your Store2");
		softAssert.assertEquals(title,"Your Store2");
		System.out.println("Using Hard Assert");
		softAssert.assertAll();
	}
	
	@Test
	public  void testCaseOne() throws InterruptedException
	{
		
		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Phone");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
						
		Thread.sleep(5000);
		driver.quit();
	}

	@AfterTest
	public  void closeBrowser()
	{
		driver.quit();
	}
}