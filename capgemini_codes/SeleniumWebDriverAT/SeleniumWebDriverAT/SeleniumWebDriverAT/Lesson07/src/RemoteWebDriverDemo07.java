import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RemoteWebDriverDemo07
{

	public static void main(String[] args) throws InterruptedException
	{
		DesiredCapabilities capabilities=DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		
		//Allows the user to choose between one of three pre-specified locations
		//in which to store file downloads.
		//0=Desktop,1=Download,2=Most recent download location
		profile.setPreference("browser.download.folderList",1);
		
		//Allows the user to specify whether or not the Download Manager window
		//is displayed when a file download is initiated.
		profile.setPreference("browser.download.manager.showWhenStarting",false);
		
		//A comma-separated list of MIME types to save to disk without asking what to use to open the file.
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/msword,application/pdf,application/excel,application/vnd.ms-excel,application/x-excel,application/x-msexcel,application/csv,text/csv");
		
		//To disable Firefox’s native built-in PDF viewer
		profile.setPreference("pdfjs.disabled", true);
		
		//To prevent scanning the Acrobat installation directories and increase the value
		//of the minimum version to a number greater than the version you have installed.
		profile.setPreference("plugin.scan.Acrobat", "99.0");
		
		//To prevent scanning the directories specified in the Windows registry for PLIDs,
		//modify the plugin.scan.plid.all preference value from "true" to "false". 
		profile.setPreference("plugin.scan.plid.all", false);		
		
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		
		WebDriver driver=new FirefoxDriver(capabilities);

		driver.get("http://demo.opencart.com/");

		Thread.sleep(10000);

		driver.quit();

	}

}