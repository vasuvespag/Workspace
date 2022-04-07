import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnitWD02 
{
	@Test
	public  void testCaseOne() throws InterruptedException
	{
		
		WebDriver driver=new FirefoxDriver();

		driver.get("http://demo.opencart.com/");
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		String title=driver.getTitle();
		
		assertEquals("Your Store2", title);

		WebElement searchBox=driver.findElement(By.name("search"));
		
		searchBox.sendKeys("Phone");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("input-group-btn")).click();
		
		Thread.sleep(5000);
		
		String searchText=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		
		assertTrue(searchText.contains("Phone"));
		
		driver.quit();
	}

}