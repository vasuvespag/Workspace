package tests;

import functions.HotelApp_BusinessFunctions;

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
import org.openqa.selenium.support.ui.WebDriverWait;



public class ParametrizationLoopTest extends HotelApp_BusinessFunctions{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
//  public Properties prop;
  public static String sAppURL;
  public static String sSharedUIMapPath;
  
  @Before
  public void setUp() throws Exception {
	  prop = new Properties();
	  
	  prop.load(new FileInputStream("./Configuration/HA_Configuration.properties"));
	  sAppURL = prop.getProperty("sAppURL");
	  sSharedUIMapPath = prop.getProperty("SharedUIMap");
	  
	  prop.load(new FileInputStream(sSharedUIMapPath));
      driver = new FirefoxDriver();
      baseUrl = "http://www.adactin.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
	  
	driver.get(sAppURL);

    //Comment - Call to Login Function
	int intRowCount = HA_GF_XLRowCount ( "./DataPool/HA_HotelSearch.xls", "Location");
	
	for(int j = 1; j<intRowCount; j++)	
		{
			HA_BF_Login(driver, "adactin123", "adactin123");
    
			String strFile = "./DataPool/HA_HotelSearch.xls";
			String strLocation =  HA_GF_readXL(j,"Location",strFile);

			new Select(driver.findElement(By.id(prop.getProperty("Lst_SearchHotel_Location")))).selectByVisibleText(strLocation);
			driver.findElement(By.id(prop.getProperty("Btn_SearchHotel_Search"))).click();
			driver.findElement(By.id(prop.getProperty("Rad_SelectHotel_RadioButton_1"))).click();
			driver.findElement(By.id(prop.getProperty("Btn_SelectHotel_Continue"))).click();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_FirstName"))).sendKeys("test");
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_LastName"))).sendKeys("test");
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_Address"))).sendKeys("test");
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCNumber"))).sendKeys("1212121212121212");
			new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCType")))).selectByVisibleText("American Express");
			new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpMonth")))).selectByVisibleText("March");
			new Select(driver.findElement(By.id(prop.getProperty("Lst_BookingHotel_CCExpYear")))).selectByVisibleText("2015");
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).clear();
			driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_CCCvvNumber"))).sendKeys("111");
			driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_BookNow"))).click();
			driver.findElement(By.linkText(prop.getProperty("Lnk_BookingHotel_Logout"))).click();
			driver.findElement(By.linkText(prop.getProperty("Lnk_Logout_ClickHeretoLoginAgain"))).click(); 
			WebDriver driver = new FirefoxDriver();
			WebDriverWait myWaitVar = new WebDriverWait(driver, 10);

		}
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
