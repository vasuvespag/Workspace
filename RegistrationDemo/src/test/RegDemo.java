package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegDemo {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Vasu\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		String baseUrl = "https://webapps.tekstac.com/FormRegistration/UserRegistration.html";
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
	}

	@Test
	public void test() {
		
		WebElement ele = driver.findElement(By.name("city"));
		
		Select sel = new Select(ele);
		List<WebElement> options = sel.getOptions();
		List<String> lst = new ArrayList<String>();
		for(WebElement we : options) {
			lst.add(we.getText());
		}
		
		int i = lst.size();
		System.out.println(i);
		int j = 0;
		
		while (j < lst.size()) {
			
		    System.out.println(lst.get(j).toString());
		    j++;
		}
	}

}
