import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverDemo05
{

	public static void main(String[] args) throws InterruptedException, MalformedURLException
	{
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		
		capabilities.setPlatform(Platform.WINDOWS);
		capabilities.setBrowserName("chrome");
		capabilities.setVersion("48");
		
		WebDriver driver=new RemoteWebDriver(new URL("http://10.51.92.9:4444/wd/hub"), capabilities);

		driver.get("http://demo.opencart.com/");

		Thread.sleep(10000);

		driver.quit();
	}

}
