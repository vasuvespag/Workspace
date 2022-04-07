import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverDemo02 
{

	public static void main(String[] args) throws InterruptedException, MalformedURLException 
	{
		
		WebDriver driver=new RemoteWebDriver(new URL("http://10.207.222.93:5566/wd/hub"), DesiredCapabilities.chrome());

		driver.get("http://demo.opencart.com/");		
		
		Thread.sleep(10000);

		driver.quit();
	}

}
