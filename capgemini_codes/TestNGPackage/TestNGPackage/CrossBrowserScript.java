package TestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript
{
	WebDriver driver;
		
	@BeforeTest
	@Parameters("browser")
	public void setupTest(String browser) throws Exception
	{
		//Verify if parameter passed from TestNG is Internet Explorer
		if(browser.equalsIgnoreCase("ie"))
		{
		    //create IE instance
			System.setProperty("webdriver.ie.driver","D:/Advanced Selenium Libs/IEDriverServer_Win32_3.4.0/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}		
		
		//Verify if parameter passed from TestNG is Chrome
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver","D:/Advanced Selenium Libs/chromedriver_win32/chromedriver.exe");
			//create Chrome instance
			driver = new ChromeDriver();
		}
		else
		{
			//If no browser passed throw exception
			throw new Exception("No browser specified");
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void RunCrossBrowserScript() throws InterruptedException
	{
		driver.get("http://demo.opencart.com/");		
	}
}