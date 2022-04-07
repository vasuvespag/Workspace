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
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

public class TestPepperfry {
	
	private WebDriver driver;
	private Map<String, Object> vars;
	  JavascriptExecutor js;
	  private String baseUrl;
	  
	  @Before
		public void setUp() throws Exception {
			System.setProperty("webdriver.gecko.driver","C:\\Vasu\\geckodriver.exe");
			//FirefoxOptions options = new FirefoxOptions().setLegacy(true);
			//options.setCapability("marionette", false);
			driver = new FirefoxDriver();
			js = (JavascriptExecutor) driver;
		    vars = new HashMap<String, Object>();
			
			baseUrl = "http://www.pepperfry.com";
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			
		}

		@After
		public void tearDown() throws Exception {
			driver.quit();
		}

		@Test
		public void test() {
			System.out.println("Simple Test");
			driver.navigate().to(baseUrl);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//driver.findElement(By.link("twotabsearchtextbox")).sendKeys("mobile smartphones under 30000");
		    //driver.findElement(By.id("nav-search-submit-button")).click();
		    driver.findElement(By.linkText("Furniture")).click();
		    WebDriverWait wait = new WebDriverWait(driver, 120);
		    wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Benches")));
		    driver.findElement(By.linkText("Benches")).click();
		    //driver.findElement(By.id("s-result-sort-select_4")).click();
		}


}
