import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkingWithChromeDemo01
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "C:/Advanced Selenium Libs/Drivers/chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();

		driver.get("http://demo.opencart.com/");

		Thread.sleep(10000);

		driver.quit();

	}

}
