import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;   

public class PhantomJSDemo01 
{

	public static void main(String[] args)
	{
		System.setProperty("phantomjs.binary.path", "C:/Advanced Selenium Libs/WebDriver API/PhantomJS/phantomjs.exe");
        WebDriver driver = new PhantomJSDriver();
                   
        driver.get("http://demo.opencart.com/");
        //driver.get("file:///D:/SeleniumWebDriverAT/Lesson05/src/AlertExample.html");
        System.out.println("Page title is: " + driver.getTitle());      
        
        driver.quit();         

	}

}
