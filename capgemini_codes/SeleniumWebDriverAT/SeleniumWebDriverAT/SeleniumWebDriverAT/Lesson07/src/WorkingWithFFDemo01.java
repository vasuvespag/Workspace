import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WorkingWithFFDemo01 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver=new FirefoxDriver();
		
		//Use the driver to visit the URL
		driver.get("http://demo.opencart.com/");
		
		//Wait for 10 seconds
		Thread.sleep(10000);
		
		//Closing the browser
		driver.quit();

	}
}