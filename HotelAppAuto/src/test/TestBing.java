package test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBing {
	private WebDriver driver;
	private String baseURL;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Vasu\\Vasu\\Vasu\\drivers\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		baseURL = "http://bing.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	

	@Test
	public void test() {
		driver.get(baseURL);
		driver.findElement(By.xpath(".//*[@id='sb_form_q']")).sendKeys("notepad");
	}
	
	@After
	public void tearDown() throws Exception {
	}

}
