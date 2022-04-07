/package param.xmldemo.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginVerification {
	static String driverPath = "C:\\Selenium Lib\\";
	@Test
	@Parameters({"sUsername", "sPassword"})
	public void login(String sUsername, String sPassword)
	{
		
		System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Shubhangi/Shubhi's%20Artifacts/Artifacts%202018/April/AT%20M4%20Selenium%20Demos/LoginDemoPage.html");
		driver.findElement(By.id("un")).sendKeys(sUsername);
		driver.findElement(By.id("pass")).sendKeys(sPassword);
		driver.findElement(By.id("login")).click();
		driver.close();
		
	}
	
	
	
	
}
