package param.dataproviderdemo.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestCaseLogin {
	
	static String driverPath = "C:\\Selenium Lib\\";
	
	@DataProvider(name="Testdata")
	public Object[][] getData()
	{
		Object[][] data = new Object[3][2];// 2 dimentional array rows and col
		//row 1 data
		data[0][0]="capgemini";
		data[0][1]="capgemini";
		//row 2 data
		data[1][0]="capgemini1";
		data[1][1]="capgemini1";
		//row 2 data
		data[2][0]="capgemini2";
		data[2][1]="capgemini2";
		return data;
	}
	@Test(dataProvider="Testdata")
	public void Loginvalidation(String username, String password)
	{
		System.setProperty("webdriver.chrome.driver",driverPath+"chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("file:///D:/Shubhangi/Shubhi's%20Artifacts/Artifacts%202018/April/AT%20M4%20Selenium%20Demos/LoginDemoPage.html");
		driver.findElement(By.id("un")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		driver.close();
	}

}
