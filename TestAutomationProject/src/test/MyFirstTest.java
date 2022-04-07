package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select; 

public class MyFirstTest {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.adactinhotelapp.com");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.id("username")).sendKeys("vasuvespag");
		driver.findElement(By.id("password")).sendKeys("Vasu1234");
		driver.findElement(By.id("login")).click();
		
		new Select(driver.findElement(By.id("location"))).selectByIndex(4);
		driver.findElement(By.id("Submit")).click();
	    driver.findElement(By.id("radiobutton_1")).click();
	    driver.findElement(By.id("continue")).click();
	    driver.findElement(By.id("first_name")).clear();
	    driver.findElement(By.id("first_name")).sendKeys("test");
	    driver.findElement(By.id("last_name")).clear();
	    driver.findElement(By.id("last_name")).sendKeys("test");
	    driver.findElement(By.id("address")).clear();
	    driver.findElement(By.id("address")).sendKeys("test");
	    driver.findElement(By.id("cc_num")).clear();
	    driver.findElement(By.id("cc_num")).sendKeys("1212121212121212");
	    new Select(driver.findElement(By.id("cc_type"))).selectByVisibleText("American Express");
	    new Select(driver.findElement(By.id("cc_exp_month"))).selectByVisibleText("March");
	    new Select(driver.findElement(By.id("cc_exp_year"))).selectByVisibleText("2015");
	    driver.findElement(By.id("cc_cvv")).clear();
	    driver.findElement(By.id("cc_cvv")).sendKeys("111");
	    driver.findElement(By.id("book_now")).click();

	}

}
