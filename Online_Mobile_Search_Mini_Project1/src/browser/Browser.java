package browser;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;

public class Browser {
	public static WebDriver driver;
	public static Actions act;
	
	// WebDriver Setup Selection Method
	public static WebDriver setDriver() throws Exception {
		try{
			String filelocation = System.getProperty("user.dir") + "\\Resources\\configuration.properties";
			File file = new File(filelocation);
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = setChromeDriver();
		} 
		else if (browser.equalsIgnoreCase("firefox")) {
			driver = setFirefoxDriver();
		} 
		else if(browser.equalsIgnoreCase("opera")) {
			driver = setOperaDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver = setEdgeDriver();
		}
		else {
			System.out.println("Invalid data...");
		}
		act = new Actions(driver);
		}
		catch(Exception e ) {
			e.printStackTrace();
		}
		return driver;
	}

	// ChromeDriver Setup Method
	private static WebDriver setChromeDriver() throws Exception  {
	    String driverPath;
		try {
		//driverPath = System.getProperty("user.dir") + "\\Vasu\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", "C:\\Vasu\\drivers\\geckodriver.exe");
		driver = new ChromeDriver();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	// FireFox Driver Setup Method
	private static WebDriver setFirefoxDriver() throws Exception {
		String driverPath;
		try {
		//driverPath=System.getProperty("user.dir") + "\\Vasu\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", "C:\\Vasu\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	//Opera Driver setup Method
	private static WebDriver setOperaDriver() throws Exception  {
	    String driverPath;
		try {
		driverPath = System.getProperty("user.dir") + "\\drivers\\operadriver.exe";
		System.setProperty("webdriver.opera.driver", driverPath);
		driver = new OperaDriver();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
	//Edge Driver Setup Method
	private static WebDriver setEdgeDriver() throws Exception  {
	    String driverPath;
		try {
		driverPath = System.getProperty("user.dir") + "\\drivers\\msedgedriver.exe";
		System.setProperty("webdriver.edge.driver", driverPath);
		driver = new EdgeDriver();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	// URL Setup Method
	public static void getUrl() throws Exception {
		try {
		String filelocation = System.getProperty("user.dir") + "\\Resources\\configuration.properties";
		File file = new File(filelocation);
		FileInputStream fileinput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileinput);
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Method to close browser
	public static void closeBrowser() throws Exception {
		try {
		driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
