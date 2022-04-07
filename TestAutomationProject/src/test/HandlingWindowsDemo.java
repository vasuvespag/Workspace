package test;

import java.util.List;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class HandlingWindowsDemo {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/popup.php");
		driver.manage().window().maximize();
		
		String MainWindow = driver.getWindowHandle();
		driver.findElement(By.xpath("/html/body/p/a")).click();
		
		Set<String> l1 = driver.getWindowHandles();
		Iterator<String> it1 = l1.iterator();
		
		while(it1.hasNext())
		{
			String ChildWindow = it1.next();
			
			if(!MainWindow.equalsIgnoreCase(ChildWindow))
			{
				driver.switchTo().window(ChildWindow);
				driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("vasu.vespag@gmail.com");
				driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
				driver.close();
			}
			
		}
		driver.switchTo().window(MainWindow);

	}

}
