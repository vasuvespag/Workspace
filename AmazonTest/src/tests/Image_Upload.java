package tests;



import java.io.File; 
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;

public class Image_Upload 
{
	WebDriver driver = null;
	static String filename;
	static String projectDirpath =System.getProperty("user.dir");
	static int select;
	
public static void main(String[] args)throws IOException 
{
	System.out.println("Select 1 for chrome and 2 for Mozilla");
	Scanner sc = new Scanner(System.in);
	select = sc.nextInt();
	if (select==1)
	{
		//To open Chrome Browser C:\Users\vignesh\eclipse-workspace\Selenium\screenshots\img1.jpg
		System.setProperty("webdriver.chrome.driver",
				"C:\\Vasu\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//To open google page in Specified Browser
		driver.navigate().to("http://google.com");
		
		System.out.println("Opening webpage in chrome");
		
		//Displaying title of the page
		System.out.println(driver.getTitle());
		
		//Maximaizing
		driver.manage().window().maximize();
		
		//Verifying title of the page
		
		Assert.assertEquals(driver.getTitle(), "Google");
		
		System.out.println("Title of the Page- "+driver.getTitle());
		
		//Navigate to the image link to search for the image
		driver.findElement(By.linkText("Images")).click();
		
		//Taking Screenshot 
		takescreenshot(driver, "image");
		
		//Navigate to the image upload page
		driver.findElement(By.className("BwoPOe")).click();
		
		//Taking Screenshot 
		takescreenshot(driver, "image");
		
		//Select upload option in image search page
		driver.findElement(By.linkText("Upload an image")).click();
		
		//Taking Screenshot 
		takescreenshot(driver, "image");
		
		
		//uploading image
		String imagepath = projectDirpath + "\\screenshots\\img1.jpg";
		driver.findElement(By.xpath("//input[@id=\"awyMjb\"]")).sendKeys(imagepath);
		
		
		//Validating the result 
		WebElement verify = driver.findElement(By.xpath("//div[@id='result-stats']"));
		String val = verify.getText();
		System.out.println(val);
		
		
		//Taking Screenshot of the result
		takescreenshot(driver, "image");
		
		//finding number of links in the reult page
		List<WebElement>
		links= driver.findElements(By.tagName("a"));
		
		System.out.println("No of Links:"+links.size());
		
		//Closing the Browser 
		driver.close();
	}
	else {
		System.setProperty("webdriver.gecko.driver",
				"C:\\\\Vasu\\\\geckodriver.exe");
		
		WebDriver drivers = new FirefoxDriver();
		
		drivers.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		//OPen the google search page in the Specified browser
		drivers.navigate().to("http://www.google.com");
		
		System.out.println("Opening	webpage in Firefox");
		
		//Displaying title of the page
		System.out.println(drivers.getTitle());
		
		//Maximizing the windows
		drivers.manage().window().maximize();
		
		//Verifying title of the page
		Assert.assertEquals(drivers.getTitle(), "Google");
		System.out.println("Title of the page- "+drivers.getTitle());
		
		//Navigate to the image link to search for image
		drivers.findElement(By.linkText("Images")).click();
		
		//Taking Screenshot 
		takescreenshot(drivers, "image");
				
		
		//Select upload option ini mage search page
		drivers.findElement(By.className("BwoPOe")).click();
		
		//Taking Screenshot 
		takescreenshot(drivers, "image");
		
		//Select upload option in image search page
		drivers.findElement(By.linkText("Upload an image")).click();
		
		//Taking Screenshot 
		takescreenshot(drivers, "image");
		
		//Uploading image
		String imagepath = projectDirpath + "\\screenshots\\img1.jpg";
		drivers.findElement(By.xpath("//input[@id=\"awyMjb\"]")).sendKeys(imagepath);;
		
		
		//validating the result
		WebElement verify = drivers.findElement(By.xpath("/html/body/div[7]/div/div[7]/div/div/div/div/div"));
		String val1 = verify.getText();
		System.out.println(val1);
		
		//Taking Screenshot 
		takescreenshot(drivers, "image");
		
		
		//finding number of links in the result page
		List<WebElement>
		links= drivers.findElements(By.tagName("a"));
		
		System.out.println("No of Links:"+links.size());
		
		//Closing the Browser 
		drivers.close();
		

		
		
	}
}

private static void takescreenshot(WebDriver driver, String name) throws IOException 
{
	Random randNumber = new Random();
	String filename = name + String.valueOf(randNumber.nextInt());
	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler.copy(file, new File(projectDirpath + "\\screenshots\\"+ filename + ".jpg"));
	// TODO Auto-generated method stub
	
}


}

