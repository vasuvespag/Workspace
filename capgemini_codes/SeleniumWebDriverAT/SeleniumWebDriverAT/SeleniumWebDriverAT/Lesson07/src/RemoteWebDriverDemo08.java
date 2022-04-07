import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RemoteWebDriverDemo08 
{

	public static void main(String[] args) throws InterruptedException
	{
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		
		ProfilesIni profilesIni=new ProfilesIni();
		
		FirefoxProfile profile = profilesIni.getProfile("default");
		
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		
		WebDriver driver=new FirefoxDriver(capabilities);

		driver.get("http://demo.opencart.com/");

		Thread.sleep(10000);

		driver.quit();
	}
}