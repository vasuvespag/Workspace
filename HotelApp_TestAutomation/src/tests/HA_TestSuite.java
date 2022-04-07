package tests;


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class HA_TestSuite  {

   public static WebDriver driver;
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
    
	  //Instantiating Object for each of the tests
	  
	  MyFirstWebDriverTest bp1 = new MyFirstWebDriverTest();
	  VerificationPointTest bp2 = new VerificationPointTest();
	  SynchronizationTest bp3 = new SynchronizationTest();
	  SharedUIMapTest bp4 = new SharedUIMapTest();

	  // Defining which tests to run
	  
	  Boolean bMyFirstWebDriverTest = true;
	  Boolean bVerificationPointTest = true;
	  Boolean bSynchronizationTest = false;
	  Boolean bSharedUIMapTest = false;
	  
	  //Call and run tests
	  
	  if(bMyFirstWebDriverTest)
			bp1.testMyFirstWebDriver();
	  
	  if(bVerificationPointTest)
			bp2.testMyFirstWebDriver();
	  
	  if(bSynchronizationTest)
			bp3.testMyFirstWebDriver();
	  
	  if(bSharedUIMapTest)
			bp4.testMyFirstWebDriver();
	  
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
