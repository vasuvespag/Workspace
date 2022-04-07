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



public class DynamicUIObjectTest extends HotelApp_BusinessFunctions{
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
    driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
	  
	driver.get(sAppURL);
    //Comment - Call to Login Function
    HA_BF_Login(driver, "adactin123", "adactin123");
    
    String strFile = "./DataPool/HA_HotelSearch.xls";
 	String strLocation =  HA_GF_readXL(1,"Location",strFile);
 	
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
    
    Thread.sleep(30);
    String strOrderNo = driver.findElement(By.id(prop.getProperty("Txt_BookingHotel_OrderNo"))).getAttribute("value");
	System.out.println("Order Number Generated is "+ strOrderNo);
	
	driver.findElement(By.id(prop.getProperty("Btn_BookingHotel_MyItinerary"))).click();
	driver.findElement(By.id(prop.getProperty("Txt_BookedItinerary_SearchOrderid"))).sendKeys(strOrderNo);

	
	driver.findElement(By.id(prop.getProperty("Btn_BookedItinerary_Go"))).click();
	
	Thread.sleep(10);

	//driver.findElement(By.xpath(".//*[@value= ‘Cancel JDJ22MCUPI’]")).click();
	//driver.findElement(By.xpath(".//*[@value='Cancel "+strOrderNo+"']")).click();
	//driver.findElement(By.xpath(".//*[contains(@id,'btn_id_')]")).click();
	driver.findElement(By.xpath(".//*[@id='btn_id_.*']")).click();
	
	Alert javascriptAlert = driver.switchTo().alert();
 	System.out.println(javascriptAlert.getText()); // Get text on alert box
 	javascriptAlert.accept();
	
 	
    driver.findElement(By.linkText(prop.getProperty("Lnk_BookingHotel_Logout"))).click();
    driver.findElement(By.linkText(prop.getProperty("Lnk_Logout_ClickHeretoLoginAgain"))).click(); 
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
