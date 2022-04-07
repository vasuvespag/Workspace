package tests;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class IrctcTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.driver","C:\\Vasu\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void irctc() {
    driver.get("https://www.irctc.co.in/nget/train-search");
    driver.manage().window().setSize(new Dimension(1382, 744));
    //driver.findElement(By.cssSelector(".ng-tns-c58-8 > .ui-inputtext")).click();
    driver.findElement(By.cssSelector(".ng-tns-c58-8 > .ui-inputtext")).sendKeys("hyd");
    driver.findElement(By.cssSelector("#p-highlighted-option > .ng-star-inserted")).click();
    driver.switchTo().frame(10);
    js.executeScript("window.scrollTo(0,0)");
    driver.switchTo().defaultContent();
    driver.findElement(By.cssSelector(".ng-tns-c58-9 > .ui-inputtext")).click();
    driver.switchTo().frame(10);
    js.executeScript("window.scrollTo(0,0)");
    driver.switchTo().defaultContent();
    driver.findElement(By.id("p-highlighted-option")).click();
    driver.findElement(By.cssSelector(".ng-tns-c59-10 > .ui-inputtext")).click();
    driver.findElement(By.linkText("24")).click();
    driver.findElement(By.cssSelector(".ng-tns-c66-11 > .ui-dropdown-trigger-icon")).click();
    js.executeScript("window.scrollTo(0,0)");
    driver.findElement(By.cssSelector(".ng-tns-c66-11:nth-child(10) > .ui-dropdown-item")).click();
    driver.findElement(By.cssSelector(".ng-star-inserted > .css-label_c")).click();
    driver.findElement(By.cssSelector(".ui-button-text")).click();
    driver.findElement(By.cssSelector(".train_Search")).click();
    WebDriverWait wait = new WebDriverWait(driver, 120);
    wait.until(ExpectedConditions.titleIs("IRCTC Next Generation eTicketing System"));
  }
}