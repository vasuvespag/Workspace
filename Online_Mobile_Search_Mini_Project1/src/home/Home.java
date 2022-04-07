package home;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import browser.Browser;
import locators.Locators;

public class Home extends Browser{
	private static String searchKeys;
	public static void main(String [] args) throws Exception {
		
		try{
			
			//get search key from properties file
			String filelocation = System.getProperty("user.dir") + "\\Resources\\configuration.properties";
			File file = new File(filelocation);
			FileInputStream fileinput = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fileinput);
			searchKeys = prop.getProperty("searchKeys");
			
			Browser.setDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			Browser.getUrl();
			
			WebElement searchBox = Locators.findSearch();
			searchBox.sendKeys(searchKeys);
			WebElement searchIcon = Locators.clickSearch();
			searchIcon.click();
			
			WebElement page = Locators.validatePage();
			String pageString = page.getText();
			WebElement search = Locators.validateSearch();
			String searchString = search.getText();
			
			
			if(searchString.contains(searchKeys)) {
				System.out.println("----------------------------------------------------------------");
				System.out.println("Passed! Landed on the correct Page");
				System.out.println("----------------------------------------------------------------");
				System.out.println(pageString +" "+searchString);
				System.out.println("----------------------------------------------------------------");
				
				//WebElement sort = Locators.findSortList();
				
				WebDriverWait wait = new WebDriverWait(driver,200);
				wait.until(ExpectedConditions.elementToBeClickable(By.id("a-autoid-0-announce")));
				driver.findElement(By.id("a-autoid-0-announce")).click();
				//sort.click();
				//WebElement element = driver.findElement(By.cssSelector(".nav-imageHref>img"));
				//Actions builder = new Actions(driver);
				//builder.moveToElement(element).perform();
				
				WebElement newArrival = Locators.findNewArrivalOption();
				newArrival.click();
				WebElement validateNewArrival = Locators.validateNewArrival();
				String arrivalString = validateNewArrival.getText();
				
				if(arrivalString.contains("New"))
					System.out.println("Passed! "+arrivalString);
				else
					System.out.println("Failed! "+arrivalString);
				System.out.println("----------------------------------------------------------------");
			}
			else {
				System.out.println("Page loaded not matches the search");
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}finally {
			
			Browser.closeBrowser();
			
		}
	}
}
