import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverDemo01
{

	public static void main(String[] args) throws InterruptedException, MalformedURLException
	{
		//WebDriver driver1=new RemoteWebDriver(new URL("http://10.207.222.93:5566/wd/hub"), DesiredCapabilities.firefox());
        
		WebDriver d1=new FirefoxDriver();
		try
		{
		
		d1.get("http://demo.opencart.coms/");
				
		Thread.sleep(10000);
		}

		catch(Exception ex)
		{
			System.out.println("Hello");
		}
		System.out.println("Hi");
		}
	

}

