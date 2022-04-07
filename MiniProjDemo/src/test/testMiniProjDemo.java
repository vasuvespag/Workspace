package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class testMiniProjDemo {
	private WebDriver driver;
	String baseURL;
	
	public WebDriver setUpDriver(String browser)
	{
		if(browser.equalsIgnoreCase("firefox"))
		{
		System.setProperty("webdriver.gecko.driver", "C:\\Vasu\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.navigate().to("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		}
		else if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C:\\Vasu\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		}
		
		return driver;
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String browser = "CHROME";
		testMiniProjDemo obj = new testMiniProjDemo();
		WebDriver driver = obj.setUpDriver(browser);
		obj.closeBrowser();

	}

}
