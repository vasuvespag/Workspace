import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindElementDemo01
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new FirefoxDriver();

		driver.get("http://demo.opencart.com/");

		Thread.sleep(10000);

		WebElement searchBox=driver.findElement(By.name("search"));
		
		//WebElement searchBox=driver.findElement(By.className("form-control input-lg"));
		searchBox.sendKeys("Phone");
		
		Thread.sleep(10000);
		
		driver.quit();
	}
}