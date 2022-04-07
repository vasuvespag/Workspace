import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WorkingWithIEDemo01
{

	public static void main(String[] args) throws InterruptedException 
	{
        System.setProperty("webdriver.ie.driver", "C:/Advanced Selenium Libs/Drivers/IEDriverServer.exe");
		
		WebDriver driver=new InternetExplorerDriver();

		driver.get("http://demo.opencart.com/");

		Thread.sleep(10000);

		driver.quit();

	}

}
