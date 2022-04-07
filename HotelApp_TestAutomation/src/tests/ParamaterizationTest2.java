package tests;

import functions.Function2;
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

public class ParamaterizationTest2 extends Function2{
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  //public Properties prop;

  @Before
  public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver","C:\\Vasu\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://www.adactin.com/";
    prop = new Properties();
	prop.load(new FileInputStream("./SharedUIMap/SharedUIMap.properties"));
	
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyFirstWebDriver() throws Exception {
	
    driver.get(baseUrl + "/HotelApp/");
    //driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).clear();
   // driver.findElement(By.xpath(prop.getProperty("Txt_Login_Username"))).sendKeys("adactin123");
    //driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).clear();
   // driver.findElement(By.id(prop.getProperty("Txt_Login_Password"))).sendKeys("adactin123");  
    //driver.findElement(By.id(prop.getProperty("Btn_Login_Login"))).click();
    
    Login (driver, "adactin123", "adactin123");
    String sLocation = HA_GF_readXL(1, "Location", "./DataPool/HA_HotelSearch.xls");
    new Select(driver.findElement(By.id("location"))).selectByVisibleText(sLocation);
    driver.findElement(By.id("Submit")).click();
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
    assertEquals("test", "test");
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
