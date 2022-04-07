package TestNGPackage;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJSDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:/Advanced Selenium Libs/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");				
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
        System.out.println(file.getAbsolutePath());
        WebDriver driver = new PhantomJSDriver();	
        driver.get("http://www.google.com");         
        WebElement element = driver.findElement(By.name("q"));	
        element.sendKeys("Selenium");					
        element.submit();         			
        System.out.println("Page title is: " + driver.getTitle());		
        driver.quit();	
	}
}