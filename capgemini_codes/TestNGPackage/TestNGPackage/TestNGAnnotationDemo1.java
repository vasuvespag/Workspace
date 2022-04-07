package TestNGPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationDemo1 
{
	public String baseUrl = "http://newtours.demoaut.com/";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
    
    @BeforeTest
    public void launchBrowser()
    {
        System.out.println("launching Chrome browser"); 
        System.setProperty("webdriver.chrome.driver","D:/Advanced Selenium Libs/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(baseUrl);
    }
    
    @BeforeMethod
    public void verifyHomepageTitle()
    {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test(priority = 0)
    public void register()
    {
        driver.findElement(By.linkText("REGISTER")).click() ;
        expected = "Register: Mercury Tours";
        actual = driver.getTitle();
        Assert.assertEquals(actual, expected);
    }
    @Test(priority = 1)
    public void support()
    {
          driver.findElement(By.linkText("SUPPORT")).click() ;
          expected = "Under Construction: Mercury Tours";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
    }
    
    @AfterMethod
    public void goBackToHomepage()
    {
          driver.findElement(By.linkText("Home")).click() ;
    }
     
    @AfterTest
    public void terminateBrowser()
    {
        driver.close();
    }
}