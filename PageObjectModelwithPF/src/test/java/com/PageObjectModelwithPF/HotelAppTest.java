package com.PageObjectModelwithPF;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class HotelAppTest {
public static WebDriver driver = null;
	
	@BeforeSuite
	public void initialize() throws IOException{
			
		System.setProperty("webdriver.chrome.driver", "C:\\Vasu\\chromedriver.exe");
		driver = new ChromeDriver();		
		//To maximize browser
                driver.manage().window().maximize();
	        //Implicit wait
        	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//To open HotelApp
                driver.get("http://www.adactin.com/HotelApp/");
		

}
	
	@AfterSuite
	//Test cleanup
	public void TeardownTest()
    {
        HotelAppTest.driver.quit();
    }
}