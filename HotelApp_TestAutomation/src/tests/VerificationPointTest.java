package tests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VerificationPointTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  
  
  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.adactin.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
	  

	  
	  driver.get(baseUrl + "/HotelApp/");
    

    driver.findElement(By.xpath(".//*[@id='username']")).clear();
    driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("adactin123");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("adactin123");
    driver.findElement(By.id("login")).click();
    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
   
    
    driver.findElement(By.id("Submit")).click();
    
    String sLocation = driver.findElement(By.id("location_1")).getAttribute("value");
    
    if (sLocation.equalsIgnoreCase("Sydney"))
    		{
    	System.out.println("Searched location is correct on search page. Actual location is "+ sLocation);
    		}
  
    try {
    assertEquals("Sydney", sLocation);
    }
    catch 
    {
    	
    }
   //String sLocationFieldError = driver.findElement(By.xpath(".//*[@id='location_span']")).getText();
    
    // Verification Point to Check mandatory field error for Location
    
    //if (sLocationFieldError.equalsIgnoreCase("Please Select a Location"))
   // 	System.out.println("Mandatory Error check for Location field passed. Actual Location Field Error is " + sLocationFieldError);
  //  else
   // 	System.out.println("Mandatory Error check for Location field passed. Actual Location Field Error is " + sLocationFieldError);
  //  
  // String slocation = driver.findElement(By.xpath(".//*[@id='location_1']")).getAttribute("value");
    
    // Verification Point to Check Search location is correct in Select Hotel Page
    
   // if (slocation.equalsIgnoreCase("Sydney"))
  //  	System.out.println("The Search Results are correct");
 //   else
   // 	System.out.println("The Search Results are incorrect" );
    
    /*
    
  String sActualVal = driver.findElement(By.id("location_1")).getAttribute("value");
  
  if (sActualVal.equalsIgnoreCase("Sydney"))
		 System.out.println("Search results are correct");
  		 
  else
	  System.out.println("Search results are incorrect");

  assertEquals("Sydney", sActualVal);
    // Verification Point to Check page Title
     * 
     * */
    
    
    
    String spageTitle = driver.getTitle();
    if (spageTitle.equalsIgnoreCase("AdactIn.com - Select Hotel"))
    	System.out.println("Page Title is correct" + spageTitle);
    else
    	System.out.println("Page Title is incorrect" + spageTitle);


    driver.findElement(By.id("radiobutton_1")).click();
    driver.findElement(By.id("continue")).click();
    driver.findElement(By.id("first_name")).clear();
    driver.findElement(By.id("first_name")).sendKeys("test");
    driver.findElement(By.id("last_name")).clear();
    driver.findElement(By.id("last_name")).sendKeys("test");
    driver.findElement(By.id("address")).clear();
    driver.findElement(By.id("address")).sendKeys("test");
    driver.findElement(By.id("cc_num")).clear();
    driver.findElement(By.id("cc_num")).sendKeys("1212121212121212");
    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("American Express");
    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("March");
    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2015");
    driver.findElement(By.id("cc_cvv")).clear();
    driver.findElement(By.id("cc_cvv")).sendKeys("111");
    driver.findElement(By.id("book_now")).click();
    driver.findElement(By.linkText("Logout")).click();
    driver.findElement(By.linkText("Click here to login again")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
