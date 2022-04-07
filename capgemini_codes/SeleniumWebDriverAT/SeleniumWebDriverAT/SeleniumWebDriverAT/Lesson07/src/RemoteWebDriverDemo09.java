import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class RemoteWebDriverDemo09 
{

	public static void main(String[] args) throws InterruptedException, IOException
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setJavascriptEnabled(true); // not really needed: JS enabled by default
		caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/Advanced Selenium Libs/WebDriver API/PhantomJS/phantomjs.exe");
		caps.setCapability("takesScreenshot", true);
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);
		//opening URL
		driver.navigate().to("http://demo.opencart.com/");
		//waiting for 10 sec
		Thread.sleep(10000);
		//Getting page title
		System.out.println("******"+driver.getTitle());
		//taking screenshot
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("./sample.jpeg")); 
		//quitting driver
		driver.quit();

	}
}