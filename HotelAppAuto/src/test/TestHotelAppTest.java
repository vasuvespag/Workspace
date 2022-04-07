package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestHotelAppTest {
	private WebDriver driver;
	private String baseURL;
	
	@Before
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\Vasu\\Vasu\\Vasu\\drivers\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "https://adactinhotelapp.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void test() {
		driver.get(baseURL);
		
		
		driver.findElement(By.xpath(".//*[@name='username']")).clear();
	    driver.findElement(By.xpath(".//*[@name='username']")).sendKeys("vasu1234");
	    driver.findElement(By.id("password")).clear();
	    driver.findElement(By.id("password")).sendKeys("vasu1234");
	    driver.findElement(By.id("login")).click();
	    //HomePage homePage= new HomePage(driver);
	    //homePage.typeEmailId("adactin123");
	    //homePage.typePassword("password123"); 
	    //homePage.clickSignIn();

	    
	    //driver.findElement(By.id("login")).click();
	    new Select(driver.findElement(By.id("location"))).selectByVisibleText("Sydney");
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
	    driver.findElement(By.linkText("Logout")).click();
	}
	
	@After
	public void tearDown()
	{
		driver.close();
	}

}
